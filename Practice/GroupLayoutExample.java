import javax.swing.*;
import java.awt.*;

public class GroupLayoutExample extends JFrame {

    public GroupLayoutExample() {
        setTitle("GroupLayout Example");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a container and layout
        Container container = getContentPane();
        GroupLayout layout = new GroupLayout(container);
        container.setLayout(layout);

        // Auto gaps between components and container edges
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Create components
        JButton btn1 = new JButton("Button 1");
        JButton btn2 = new JButton("Button 2");
        JButton btn3 = new JButton("Button 3");

        // Horizontal group (lay out buttons side by side)
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(btn1)
                        .addComponent(btn2)
                        .addComponent(btn3));

        // Vertical group (align buttons vertically with same baseline)
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btn1)
                        .addComponent(btn2)
                        .addComponent(btn3));

        setVisible(true);
    }

    public static void main(String[] args) {
        new GroupLayoutExample();
    }
}
