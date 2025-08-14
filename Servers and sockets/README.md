# Servers and sockets

A collection of **Java networking** examples: TCP, UDP, RMI, URL/HTTP, JavaMail and JavaFX UI demos.

## Subfolders

| Folder | Description |
| --- | --- |
| [Chat server](Chat%20server/README.md) | Multi-threaded TCP chat server and client (port `12345`) |
| [TCP](TCP/README.md) | Basic TCP echo server and client (port `1234`) |
| [UDP](UDP/README.md) | UDP message send/receive (port `9876`) |
| [File Transfer](File%20Transfer/README.md) | TCP file transfer, send a file from client to server (port `12345`) |
| [URL](URL/README.md) | URL/HttpURLConnection examples, GET, POST, custom headers |
| [RMI](RMI/README.md) | Java Remote Method Invocation "Hello" example |
| [Java Mail](Java%20Mail/README.md) | Send and receive email via SMTP / IMAP (requires `javax.mail` jar) |
| [JavaFx](JavaFx/README.md) | JavaFX UI layout demos (requires the JavaFX SDK) |

## General run pattern

For every TCP/UDP server pair, run the **server first** then the **client** in a separate terminal:

```bash
# Terminal 1
cd "Servers and sockets/TCP"
javac TCPServer.java
java TCPServer

# Terminal 2
cd "Servers and sockets/TCP"
javac TCPClient.java
java TCPClient
```