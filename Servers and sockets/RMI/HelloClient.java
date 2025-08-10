
/*
 * Create the Client Program:
This program looks up the remote object from the RMI registry and calls the remote method.
 */
import java.rmi.*;

public class HelloClient {
    public static void main(String[] args) {
        try {
            Hello hello = (Hello) Naming.lookup("rmi://localhost/Hello");
            System.out.println(hello.sayHello());
        } catch (Exception e) {
            System.out.println("Client failed: " + e);
        }
    }
}
