import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActionEventDemo {
    public static void main(String[] args) {
        JFrame f = new JFrame("Action Event Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());

        JButton b1 = new JButton("Save");
        JButton b2 = new JButton("Load");

        ActionListener listener = e -> {
            String cmd = e.getActionCommand();
            JOptionPane.showMessageDialog(f, "You clicked: " + cmd);
        };

        b1.setActionCommand("SAVE");
        b2.setActionCommand("LOAD");

        b1.addActionListener(listener);
        b2.addActionListener(listener);

        f.add(b1);
        f.add(b2);

        f.pack();
        f.setVisible(true);
    }
}
