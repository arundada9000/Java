# Java Mail

Send and receive email with the **JavaMail API** (SMTP / IMAP).

| File | Purpose |
| --- | --- |
| `SendEmailExample.java` | Sends a text email through Gmail SMTP (`smtp.gmail.com:587`, STARTTLS) |
| `ReceiveEmailExample.java` | Reads mail from an IMAP account (`imap.gmail.com:993`) |
| `dependency.xml` | Maven-style dependency declarations for the required jars |

## Requirements
- The **JavaMail API** jar. Add these dependencies (see `dependency.xml`):
  - `com.sun.mail:javax.mail:1.6.2`
  - `javax.activation:activation:1.1.1`

## Configure
Edit the constants at the top of each file:
```java
String user = "your_email@gmail.com";
String password = "your_credentials";   // app password recommended
```

## Run
```bash
javac -cp ".;javax.mail.jar;activation.jar" SendEmailExample.java
java  -cp ".;javax.mail.jar;activation.jar" SendEmailExample
```

> Using your real account password is risky. Prefer a Gmail "app password".