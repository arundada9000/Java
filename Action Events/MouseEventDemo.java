import javax.swing.*;
import java.awt.event.*;

public class MouseEventDemo {
    public static void main(String[] args) {
        JFrame f = new JFrame("Mouse Event Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Click or hover here");
        label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse clicked at: " + e.getX() + "," + e.getY());
            }

            public void mouseEntered(MouseEvent e) {
                label.setText("Mouse entered");
            }

            public void mouseExited(MouseEvent e) {
                label.setText("Mouse exited");
            }
        });

        f.add(label);
        f.setSize(300, 200);
        f.setVisible(true);
    }
}
