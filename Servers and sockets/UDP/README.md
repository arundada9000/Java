# UDP

An example of **UDP** (connectionless) communication.

| File | Role |
| --- | --- |
| `UDPServer.java` | Listens on port `9876`, prints incoming datagrams |
| `UDPClient.java` | Sends a datagram message to the server |

## Run

```bash
# Terminal 1
cd "Servers and sockets/UDP"
javac UDPServer.java
java UDPServer

# Terminal 2
javac UDPClient.java
java UDPClient
```