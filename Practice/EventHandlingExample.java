import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.event.*;

public class EventHandlingExample extends JFrame {

    public EventHandlingExample() {
        setTitle("Event Handling Demo");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a button
        JButton button = new JButton("Click Me");
        button.setBounds(50, 50, 100, 100);

        // Add ActionListener to the button
        button.addActionListener(e -> JOptionPane.showMessageDialog(null, "You clicked"));

        JButton btn2 = new JButton("Button2");
        btn2.setBounds(100, 50, 100, 100);
        
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "You clicked button 2");
            }
        });

        // Add button to the frame
        add(button);
        add(btn2);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setVisible(true);
    }

    public static void main(String[] args) {
        new EventHandlingExample();
    }
}
