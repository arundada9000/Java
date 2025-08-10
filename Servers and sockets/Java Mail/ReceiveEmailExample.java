import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class ReceiveEmailExample {
    public static void main(String[] args) {
        String host = "imap.gmail.com"; // Use IMAP for Gmail
        String username = "your_email@gmail.com"; // Your email
        String password = "your_password"; // Your password

        Properties properties = new Properties();
        properties.put("mail.store.protocol", "imap");
        properties.put("mail.imap.host", host);
        properties.put("mail.imap.port", "993"); // IMAP over SSL

        try {
            // Get the session object
            Session emailSession = Session.getDefaultInstance(properties);

            // Connect to the mailbox
            Store store = emailSession.getStore("imap");
            store.connect(host, username, password);

            // Open the inbox folder
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            // Get the messages from the inbox
            Message[] messages = inbox.getMessages();
            System.out.println("Number of emails: " + messages.length);

            // Display the email subject and content
            for (Message message : messages) {
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Content: " + message.getContent().toString());
            }

            inbox.close(false); // Close inbox folder
            store.close(); // Close the connection

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
