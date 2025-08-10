
/*
 * Implement the Remote Interface:
This is the actual implementation of the remote object.
 */
import java.rmi.*;
import java.rmi.server.*;

public class HelloImpl extends UnicastRemoteObject implements Hello {
    public HelloImpl() throws RemoteException {
        super();
    }

    public String sayHello() {
        return "Hello, world!";
    }
}
