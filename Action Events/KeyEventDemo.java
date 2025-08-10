import javax.swing.*;
import java.awt.event.*;

public class KeyEventDemo {
    public static void main(String[] args) {
        JFrame f = new JFrame("Key Event Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField tf = new JTextField(20);
        tf.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                System.out.println("Key Pressed: " + e.getKeyChar());
            }
            public void keyReleased(KeyEvent e) {
                System.out.println("Key Released: " + e.getKeyChar());
            }
            public void keyTyped(KeyEvent e) {
                System.out.println("Key Typed: " + e.getKeyChar());
            }
        });

        f.add(tf);
        f.pack();
        f.setVisible(true);
    }
}
