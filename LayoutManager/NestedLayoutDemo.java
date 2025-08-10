import javax.swing.*;
import java.awt.*;

public class NestedLayoutDemo {
    public static void main(String[] args) {
        JFrame f = new JFrame("Nested Layout Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout(10, 10)); // Top-level layout

        // NORTH → FlowLayout
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        northPanel.add(new JButton("Login"));
        northPanel.add(new JButton("Register"));
        f.add(northPanel, BorderLayout.NORTH);

        // WEST → BoxLayout (vertical menu)
        JPanel westPanel = new JPanel();
        westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
        westPanel.add(new JButton("Home"));
        westPanel.add(new JButton("Profile"));
        westPanel.add(new JButton("Settings"));
        westPanel.add(Box.createVerticalStrut(20));
        westPanel.add(new JButton("Logout"));
        f.add(westPanel, BorderLayout.WEST);

        // EAST → GridLayout (tools panel)
        JPanel eastPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        eastPanel.add(new JButton("Tool 1"));
        eastPanel.add(new JButton("Tool 2"));
        eastPanel.add(new JButton("Tool 3"));
        f.add(eastPanel, BorderLayout.EAST);

        // CENTER → GridBagLayout (main content area)
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(Color.LIGHT_GRAY);
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        centerPanel.add(new JButton("Main 1"), c);

        c.gridx = 1;
        c.gridy = 0;
        centerPanel.add(new JButton("Main 2"), c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        centerPanel.add(new JButton("Main Large"), c);

        f.add(centerPanel, BorderLayout.CENTER);

        // SOUTH → FlowLayout
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        southPanel.add(new JButton("Help"));
        southPanel.add(new JButton("Exit"));
        f.add(southPanel, BorderLayout.SOUTH);

        // Final setup
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
