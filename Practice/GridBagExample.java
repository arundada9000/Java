import javax.swing.*;
import java.awt.*;

public class GridBagExample extends JFrame {

    public GridBagExample() {
        setTitle("GridBagLayout Example");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridBagLayout()); // Set GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints(); // Constraint object

        // Button 1 at (0,0)
        JButton btn1 = new JButton("Button 1");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Padding around the component
        add(btn1, gbc);

        // Button 2 at (1,0)
        JButton btn2 = new JButton("Button 2");
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(btn2, gbc);

        // Button 3 at (0,1), spans 2 columns
        JButton btn3 = new JButton("Button 3");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2; // Span 2 columns
        gbc.fill = GridBagConstraints.HORIZONTAL; // Fill horizontally
        add(btn3, gbc);

        setVisible(true);
    }

    public static void main(String[] args) {
        new GridBagExample();
    }
}
