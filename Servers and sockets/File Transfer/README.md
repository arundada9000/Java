# File Transfer

Transfer a file from **client to server** over TCP.

| File | Role |
| --- | --- |
| `TCPFileServer.java` | Listens on port `12345`, receives file chunks, saves them |
| `TCPFileClient.java` | Connects to `localhost:12345`, sends a file |

## Run

```bash
# Terminal 1
cd "Servers and sockets/File Transfer"
javac TCPFileServer.java
java TCPFileServer

# Terminal 2
javac TCPFileClient.java
java TCPFileClient
```

The received file is written to the server's working directory (e.g. `received_file.txt`, git-ignored because it is runtime output).