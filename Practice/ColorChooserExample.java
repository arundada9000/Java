import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorChooserExample extends JFrame {

    public ColorChooserExample() {
        setTitle("Color Chooser Example");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton button = new JButton("Choose Color");
        JPanel panel = new JPanel();

        button.addActionListener(e -> {
            Color color = JColorChooser.showDialog(this, "Pick a Color", panel.getBackground());
            if (color != null) {
                panel.setBackground(color);
            }
        });

        add(button, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ColorChooserExample();
    }
}
