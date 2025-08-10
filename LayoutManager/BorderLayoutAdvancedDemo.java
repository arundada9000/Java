import javax.swing.*;
import java.awt.*;

public class BorderLayoutAdvancedDemo {
    public static void main(String[] args) {
        JFrame f = new JFrame("BorderLayout Advanced Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout(10, 10)); // gaps between regions

        // 1. NORTH with multiple components using a nested FlowLayout
        JPanel northPanel = new JPanel(new FlowLayout());
        northPanel.add(new JButton("North 1"));
        northPanel.add(new JButton("North 2"));
        northPanel.add(new JButton("North 3"));
        f.add(northPanel, BorderLayout.NORTH);

        // 2. SOUTH with one big button
        f.add(new JButton("South Single"), BorderLayout.SOUTH);

        // 3. WEST with vertical box layout
        JPanel westPanel = new JPanel();
        westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
        westPanel.add(new JButton("West 1"));
        westPanel.add(new JButton("West 2"));
        westPanel.add(Box.createVerticalStrut(10)); // spacer
        westPanel.add(new JButton("West 3"));
        f.add(westPanel, BorderLayout.WEST);

        // 4. EAST with GridLayout for multiple buttons
        JPanel eastPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        eastPanel.add(new JButton("East 1"));
        eastPanel.add(new JButton("East 2"));
        eastPanel.add(new JButton("East 3"));
        f.add(eastPanel, BorderLayout.EAST);

        // 5. CENTER fixed-size panel with nested FlowLayout for multiple buttons
        JPanel centerPanel = new JPanel(new FlowLayout());
        centerPanel.setPreferredSize(new Dimension(200, 150)); // fixed size
        centerPanel.setBackground(Color.LIGHT_GRAY);
        centerPanel.add(new JButton("Center 1"));
        centerPanel.add(new JButton("Center 2"));
        centerPanel.add(new JButton("Center 3"));
        f.add(centerPanel, BorderLayout.CENTER);

        // Frame settings
        f.pack(); // Sizes frame to preferred sizes
        f.setLocationRelativeTo(null); // Center on screen
        f.setVisible(true);
    }
}
