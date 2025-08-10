import javax.swing.*;
import java.awt.event.*;

public class WindowEventDemo {
    public static void main(String[] args) {
        JFrame f = new JFrame("Window Event Demo");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println("Closing window...");
                System.exit(0);
            }

            public void windowActivated(WindowEvent e) {
                System.out.println("Window activated");
            }
        });
        f.setSize(300, 200);
        f.setVisible(true);
    }
}
