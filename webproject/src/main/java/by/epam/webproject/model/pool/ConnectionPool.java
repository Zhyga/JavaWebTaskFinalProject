package by.epam.webproject.model.pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * The {@code ConnectionPool} class represents connection pool
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public enum ConnectionPool {
    /**
     * Instance connection pool.
     */
    INSTANCE;

    private final Logger logger = LogManager.getLogger();
    private static final int POOL_SIZE = 8;
    private final BlockingQueue<ProxyConnection> freeConnections;
    private final BlockingQueue<ProxyConnection> givenAwayConnections;


    ConnectionPool() {
        DatabaseConfig databaseConfig = new DatabaseConfig();
        try {
            String driverName = databaseConfig.getDriverName();
            String url = databaseConfig.getUrl();
            String username = databaseConfig.getUsername();
            String password = databaseConfig.getPassword();
            Class.forName(driverName);
            freeConnections = new LinkedBlockingQueue<>(POOL_SIZE);
            givenAwayConnections = new LinkedBlockingQueue<>();
            for (int i = 0; i < POOL_SIZE; i++) {
                Connection connection = DriverManager.getConnection(url, username, password);
                freeConnections.offer(new ProxyConnection(connection));
            }
        } catch (ClassNotFoundException | SQLException e) {
            logger.fatal("Cant register driver", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets connection
     *
     * @return the connection
     */
    public Connection getConnection() {
        ProxyConnection connection = null;
        try {
            connection = freeConnections.take();
            givenAwayConnections.put(connection);
        } catch (InterruptedException e) {
            logger.warn("Thread was interrupted", e);
        }
        return connection;
    }

    /**
     * Releases connection
     *
     * @param connection the connection
     */
    public void releaseConnection(Connection connection) {
        if (connection instanceof ProxyConnection) {
            givenAwayConnections.remove(connection);
            freeConnections.offer((ProxyConnection) connection);
        } else {
            logger.error("Connection {} is not instance of ProxyConnection", connection);
        }
    }

    /**
     * Destroy pool
     */
    public void destroyPool() {
        for (int i = 0; i < POOL_SIZE; i++) {
            try {
                freeConnections.take().reallyClose();
            } catch (InterruptedException | SQLException e) {
                logger.error("Connection is not deleted");
            }
        }
        deregisterDriver();
    }

    /**
     * Deregister driver
     */
    private void deregisterDriver() {
        DriverManager.getDrivers().asIterator().forEachRemaining(driver -> {
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                logger.error("Driver wasn't deregister");
            }
        });
    }
}
