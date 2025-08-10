import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AllControlsDemo {
    public static void main(String[] args) {
        JFrame f = new JFrame("Swing Controls Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());

        // TextField
        JTextField tf = new JTextField(10);
        f.add(new JLabel("Name:"));
        f.add(tf);

        // PasswordField
        JPasswordField pf = new JPasswordField(10);
        f.add(new JLabel("Password:"));
        f.add(pf);

        // TextArea with scroll
        JTextArea ta = new JTextArea(3, 15);
        ta.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        f.add(new JScrollPane(ta));

        // CheckBox
        JCheckBox cb1 = new JCheckBox("Java");
        JCheckBox cb2 = new JCheckBox("Python");
        f.add(cb1);
        f.add(cb2);

        // RadioButton
        JRadioButton rb1 = new JRadioButton("Male");
        JRadioButton rb2 = new JRadioButton("Female");
        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        f.add(rb1);
        f.add(rb2);

        // ComboBox
        JComboBox<String> combo = new JComboBox<>(new String[] { "Nepal", "India", "China" });
        f.add(combo);

        // Slider
        JSlider slider = new JSlider(0, 100, 50);
        f.add(slider);

        // Button to print all selections
        JButton submit = new JButton("Submit");
        submit.addActionListener(e -> {
            System.out.println("Name: " + tf.getText());
            System.out.println("Password: " + new String(pf.getPassword()));
            System.out.println("TextArea: " + ta.getText());
            System.out.println("Java Selected: " + cb1.isSelected());
            System.out.println("Python Selected: " + cb2.isSelected());
            System.out.println("Gender: " + (rb1.isSelected() ? "Male" : rb2.isSelected() ? "Female" : "None"));
            System.out.println("Country: " + combo.getSelectedItem());
            System.out.println("Slider: " + slider.getValue());
        });
        f.add(submit);

        f.setSize(500, 400);
        f.setVisible(true);
    }
}
