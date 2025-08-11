import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class LayoutManager extends JFrame {

    LayoutManager() {
        setBackground(Color.black);
        setForeground(Color.white);
        setLocation(250, 200);

        JTextField textField = new JTextField(10);
        add(textField);

        JTextArea textArea = new JTextArea(5, 10);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        JScrollPane scrollableTextArea = new JScrollPane(textArea);
        textArea.setEditable(true);
        add(textArea);

        JButton btn1 = new JButton("Button 1");
        // btn1.setBounds(10, 10, 200, 200);
        btn1.setPreferredSize(new Dimension(150, 100));
        JButton btn2 = new JButton("Button 2");
        // btn2.setBounds(220, 10, 200, 200);
        btn2.setPreferredSize(new Dimension(100, 100));
        JButton btn3 = new JButton("Button 3");
        // btn3.setBounds(430, 10, 200, 200);
        btn3.setPreferredSize(new Dimension(200, 150));
        // add(btn1, BorderLayout.CENTER);
        // add(btn2, BorderLayout.NORTH);
        // add(btn3, BorderLayout.SOUTH);
        add(btn1);
        add(btn2);
        add(btn3);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        // setLayout(new GridLayout(3, 2));
        setVisible(true);
    }

    public static void main(String[] args) {
        new LayoutManager();
    }
}
