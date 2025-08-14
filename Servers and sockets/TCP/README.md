# TCP

A minimal **TCP echo server** and client.

| File | Role |
| --- | --- |
| `TCPServer.java` | Listens on port `1234`, echoes received data back |
| `TCPClient.java` | Connects, sends a message, prints the echo |

## Run

```bash
# Terminal 1
cd "Servers and sockets/TCP"
javac TCPServer.java
java TCPServer

# Terminal 2
javac TCPClient.java
java TCPClient
```