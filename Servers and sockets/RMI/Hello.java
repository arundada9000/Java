// Define the Remote Interface:
// This interface declares the methods that can be invoked remotely.

import java.rmi.*;

public interface Hello extends Remote {
    String sayHello() throws RemoteException;
}
