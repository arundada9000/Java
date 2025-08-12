import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleInterestCalculator extends JFrame {
    private JTextField principalField, rateField, yearsField, resultField;

    public SimpleInterestCalculator() {
        setTitle("Simple Interest Calculator");
        setSize(350, 220);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

        JLabel principalLabel = new JLabel("Principal (Rs):");
        JLabel rateLabel = new JLabel("Rate (%):");
        JLabel yearsLabel = new JLabel("Years:");
        JLabel resultLabel = new JLabel("Simple Interest (Rs):");

        principalField = new JTextField();
        rateField = new JTextField();
        yearsField = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);

        JButton calculateButton = new JButton("Calculate");
        JButton clearButton = new JButton("Clear");

        calculateButton.addActionListener(e -> calculateSimpleInterest());
        clearButton.addActionListener(e -> clearFields());

        panel.add(principalLabel);
        panel.add(principalField);
        panel.add(rateLabel);
        panel.add(rateField);
        panel.add(yearsLabel);
        panel.add(yearsField);
        panel.add(resultLabel);
        panel.add(resultField);
        panel.add(calculateButton);
        panel.add(clearButton);

        add(panel);
    }

    private void calculateSimpleInterest() {
        try {
            double principal = Double.parseDouble(principalField.getText().trim());
            double rate = Double.parseDouble(rateField.getText().trim());
            double years = Double.parseDouble(yearsField.getText().trim());

            if (principal < 0 || rate < 0 || years < 0) {
                JOptionPane.showMessageDialog(this, "All values must be positive.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double simpleInterest = (principal * rate * years) / 100.0;
            resultField.setText(String.format("%.2f", simpleInterest));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        principalField.setText("");
        rateField.setText("");
        yearsField.setText("");
        resultField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SimpleInterestCalculator().setVisible(true);
        });
    }
}
