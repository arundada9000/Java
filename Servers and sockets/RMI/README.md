# RMI

A **Java Remote Method Invocation** "Hello" example. The server exposes a remote object that the client calls over the network.

| File | Role |
| --- | --- |
| `Hello.java` | Remote interface |
| `HelloImpl.java` | Implementation of the remote interface |
| `HelloServer.java` | Exports the object and binds it as `rmi://localhost/Hello` |
| `HelloClient.java` | Looks up the remote object and calls it |

## Run
In three steps (server first):

```bash
cd "Servers and sockets/RMI"

# 1. Compile everything
javac Hello.java HelloImpl.java HelloServer.java HelloClient.java

# 2. Start the RMI registry, then the server
rmiregistry &
java HelloServer

# 3. In another terminal, run the client
java HelloClient
```

> On Windows, start `rmiregistry` without the `&` (run it in its own prompt). If you get a `ClassNotFoundException`, run with `-Djava.rmi.server.codebase=file:./` or place the classes in the classpath from which `rmiregistry` launches.