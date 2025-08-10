import javax.swing.*;
import java.awt.*;

public class SimpleInterestCalculator extends JFrame {
    private JTextField principalField, rateField, yearsField, resultField;

    public SimpleInterestCalculator() {
        setTitle("Simple Interest Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 2));

        JLabel principalLabel = new JLabel("Principal:");
        JLabel rateLabel = new JLabel("Rate:");
        JLabel yearsLabel = new JLabel("Years:");
        JLabel resultLabel = new JLabel("Simple Interest:");

        principalField = new JTextField();
        rateField = new JTextField();
        yearsField = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);

        JButton calculateButton = new JButton("FIND SI");
        calculateButton.addActionListener(e -> calculateSimpleInterest());

        panel.add(principalLabel);
        panel.add(principalField);
        panel.add(rateLabel);
        panel.add(rateField);
        panel.add(yearsLabel);
        panel.add(yearsField);
        panel.add(resultLabel);
        panel.add(resultField);

        add(panel, BorderLayout.CENTER);
        add(calculateButton, BorderLayout.SOUTH);
    }

    private void calculateSimpleInterest() {
        try {
            double principal = Double.parseDouble(principalField.getText());
            double rate = Double.parseDouble(rateField.getText());
            double years = Double.parseDouble(yearsField.getText());

            double si = (principal * rate * years) / 100;
            resultField.setText(String.format("%.2f", si));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter valid numbers in all fields.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SimpleInterestCalculator().setVisible(true);
        });
    }
}
