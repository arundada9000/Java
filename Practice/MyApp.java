import javax.swing.*;
import java.awt.event.*;

public class MyApp extends JFrame {

    public MyApp() {
        setTitle("Mouse Adapter Example");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        // Use MouseAdapter anonymously
        panel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                System.out.println("Mouse entered panel");
            }

            // public void mouseExited(MouseEvent e) {
            // System.out.println("Mouse exited panel");
            // }
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyApp();
    }
}
