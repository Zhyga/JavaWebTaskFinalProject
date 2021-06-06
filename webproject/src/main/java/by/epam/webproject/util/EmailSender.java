package by.epam.webproject.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The {@code EmailSender} class represents email sender
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class EmailSender {
    private static final String EMAIL_HEAD = "LYM bets";
    private static final String EMAIL_BODY = "Follow link to confirm your mail to register "
            + "on site bullfinch: %s?command=confirm_email&login=";
    private static final String FILE_NAME = "properties/mail.properties";
    private static final Logger LOGGER = LogManager.getLogger();

    private EmailSender() {
    }

    /**
     * Send message
     *
     * @param email the email
     * @param login the login
     * @param url the url
     */
    public static void sendMessage(String email, String login, String url) {
        try {
            Properties properties = new Properties();
            ClassLoader classLoader = EmailSender.class.getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(FILE_NAME);
            properties.load(inputStream);
            Thread thread = new Thread(new EmailSenderThread(email, EMAIL_HEAD,
                    String.format(EMAIL_BODY, url) + login, properties));
            thread.start();
        } catch (IOException e) {
            LOGGER.error("Error while reading properties file: {}", FILE_NAME, e);
        }
    }
}
