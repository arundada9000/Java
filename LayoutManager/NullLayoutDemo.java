import javax.swing.*;

public class NullLayoutDemo {
    public static void main(String[] args) {
        JFrame f = new JFrame("Null Layout");
        f.setSize(300, 200);
        f.setLayout(null);

        JButton b1 = new JButton("One");
        b1.setBounds(50, 30, 80, 30);
        f.add(b1);

        JButton b2 = new JButton("Two");
        b2.setBounds(150, 80, 80, 30);
        f.add(b2);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
