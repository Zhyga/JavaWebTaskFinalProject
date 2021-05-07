package by.epam.webproject.util;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmailSenderThread implements Runnable{
    private MimeMessage message;
    private final String sendToEmail;
    private final String mailSubject;
    private final String mailText;
    private final Properties properties;
    private static final Logger logger = LogManager.getLogger();
    private static final String TEXT_TYPE = "text/html";
    private static final String MAIL_USER_NAME = "mail.user.name";
    private static final String MAIL_USER_PASSWORD = "mail.user.password";

    public EmailSenderThread(String sendToEmail, String mailSubject, String mailText, Properties properties) {
        this.sendToEmail = sendToEmail;
        this.mailSubject = mailSubject;
        this.mailText = mailText;
        this.properties = properties;
    }

    @Override
    public void run() {
        try {
            initMessage();
            Transport.send(message);
        } catch (MessagingException e) {
            logger.error("Error while generating or sending message: {}", message, e);
        }
    }

    private void initMessage() {
        Session mailSession = createSession(properties);
        try {
            message = new MimeMessage(mailSession);
            message.setSubject(mailSubject);
            message.setContent(mailText, TEXT_TYPE);
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(sendToEmail));
        } catch (AddressException e) {
            logger.error("Invalid address: {}", sendToEmail, e);
        } catch (MessagingException e) {
            logger.error("Error while generating or sending message: {}", message, e);
        }
    }

    private Session createSession(Properties properties) {
        String userName = properties.getProperty(MAIL_USER_NAME);
        String userPassword = properties.getProperty(MAIL_USER_PASSWORD);
        return Session.getDefaultInstance(properties,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(userName, userPassword);
                    }
                });
    }
}
