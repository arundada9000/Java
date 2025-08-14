# Chat server

A **multi-threaded TCP chat server** with a simple client.

| File | Role |
| --- | --- |
| `TCPChatServer.java` | Listens on port `12345`, spawns a `ClientHandler` thread per connection |
| `TCPChatClient.java` | Connects to `localhost:12345`, sends messages and prints the server's broadcast |
| `TCPChatServer$ClientHandler.class` | (compiled inner class, see source) |

## Run

Terminal 1 (server):
```bash
cd "Servers and sockets/Chat server"
javac TCPChatServer.java
java TCPChatServer
```

Terminal 2 (client):
```bash
javac TCPChatClient.java
java TCPChatClient
```

Type messages in the client terminal, they are echoed by the server.