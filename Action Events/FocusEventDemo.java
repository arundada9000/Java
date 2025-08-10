import javax.swing.*;
import java.awt.event.*;

public class FocusEventDemo {
    public static void main(String[] args) {
        JFrame f = new JFrame("Focus Event Demo");
        f.setLocation(300, 300);
        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField tf1 = new JTextField(10);
        JTextField tf2 = new JTextField(10);

        FocusListener fl = new FocusListener() {
            public void focusGained(FocusEvent e) {
                System.out.println("Focus gained on: " + ((JTextField) e.getComponent()).getText());
            }

            public void focusLost(FocusEvent e) {
                System.out.println("Focus lost from: " + ((JTextField) e.getComponent()).getText());
            }
        };

        tf1.addFocusListener(fl);
        tf2.addFocusListener(fl);

        f.add(tf1, "North");
        f.add(tf2, "South");
        // f.pack();
        f.setVisible(true);
    }
}
