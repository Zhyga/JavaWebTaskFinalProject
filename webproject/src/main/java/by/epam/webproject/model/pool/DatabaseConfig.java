package by.epam.webproject.model.pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The {@code DatabaseConfig} class represents database config
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
class DatabaseConfig {
    private static final Logger logger = LogManager.getLogger();
    private static final String FILE_NAME = "properties/database.properties";
    private static final String DATABASE_DRIVER_NAME = "db.driver";
    private static final String DATABASE_URL = "db.url";
    private static final String DATABASE_USERNAME = "db.username";
    private static final String DATABASE_PASSWORD = "db.password";
    private final String driverName;
    private final String url;
    private final String username;
    private final String password;

    /**
     * Instantiates a new Database config.
     */
    DatabaseConfig(){
        Properties properties = new Properties();
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(FILE_NAME);
            properties.load(inputStream);
        } catch (IOException e) {
            logger.fatal("Error while reading properties file: {}", FILE_NAME, e);
            throw new RuntimeException("Error while reading properties file: " + FILE_NAME, e);
        }
        driverName = properties.getProperty(DATABASE_DRIVER_NAME);
        url = properties.getProperty(DATABASE_URL);
        username = properties.getProperty(DATABASE_USERNAME);
        password = properties.getProperty(DATABASE_PASSWORD);
    }

    /**
     * Gets driver name
     *
     * @return
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     * Gets url
     *
     * @return
     */
    public String getUrl() {
        return url;
    }

    /**
     * Gets username
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets password
     *
     * @return
     */
    public String getPassword() {
        return password;
    }
}
