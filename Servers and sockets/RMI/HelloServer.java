
/*
 * Create the Server Program:
This creates and binds the remote object to the RMI registry.
 */
import java.rmi.*;
import java.rmi.registry.*;

public class HelloServer {
    public static void main(String[] args) {
        try {
            HelloImpl obj = new HelloImpl();
            Naming.rebind("rmi://localhost/Hello", obj);
            System.out.println("Hello Server is ready.");
        } catch (Exception e) {
            System.out.println("Server failed: " + e);
        }
    }
}
