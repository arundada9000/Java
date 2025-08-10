import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmailExample {
    public static void main(String[] args) {
        // SMTP server details
        String host = "smtp.gmail.com";
        final String user = "your_email@gmail.com";  // Your email
        final String password = "your_password";  // Your email password

        // Set properties for the SMTP server
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");  // SMTP port for Gmail
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");  // Enable STARTTLS

        // Get the session object
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        try {
            // Create a default MimeMessage object
            MimeMessage message = new MimeMessage(session);

            // Set the FROM address
            message.setFrom(new InternetAddress(user));

            // Set the TO address
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("recipient_email@example.com"));

            // Set the subject
            message.setSubject("Test Email from Java");

            // Set the message body
            message.setText("This is a test email sent from a Java application.");

            // Send the message
            Transport.send(message);
            System.out.println("Email Sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
