package by.epam.webproject.exception;

/**
 * The {@code DaoException} class represents dao exception
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class DaoException extends Exception{
    public DaoException(){}

    /**
     * Instantiates a new Dao exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Dao exception.
     *
     * @param cause the cause
     */
    public DaoException(Throwable cause){
        super(cause);
    }

    /**
     * Instantiates a new Dao exception.
     *
     * @param message the message
     */
    public DaoException(String message){
        super(message);
    }
}
