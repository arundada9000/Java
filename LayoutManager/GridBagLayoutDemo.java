import javax.swing.*;
import java.awt.*;

public class GridBagLayoutDemo {
    public static void main(String[] args) {
        JFrame f = new JFrame("GridBagLayout");
        f.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        f.add(new JButton("Button 1"), c);

        c.gridx = 1;
        c.gridy = 0;
        f.add(new JButton("Button 2"), c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        f.add(new JButton("Button 3 (wide)"), c);

        f.setSize(400, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
