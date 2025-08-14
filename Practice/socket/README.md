# Practice/socket

A simple **TCP socket** demo: the client sends two numbers, the server replies with the greatest of the two.

| File | Role |
| --- | --- |
| `GreatestServer.java` | Server, listens on port `5000`, computes the max |
| `GreatestClient.java` | Client, connects, sends two numbers, prints the result |

## Requirements
- JDK 8+
- Both sides run on the same machine (client uses `localhost`)

## Run
In two terminals:

```bash
# Terminal 1, server
cd "Practice/socket"
javac GreatestServer.java
java GreatestServer
```

```bash
# Terminal 2, client
cd "Practice/socket"
javac GreatestClient.java
java GreatestClient
```