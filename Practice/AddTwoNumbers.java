import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddTwoNumbers extends JFrame {
    AddTwoNumbers() {
        setTitle("Add two numbers");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(250, 100);
        setSize(300, 300);

        JLabel labelA = new JLabel("Enter a : ");
        JTextField a = new JTextField(10);
        JLabel labelB = new JLabel("Enter b : ");
        JTextField b = new JTextField(10);

        JTextField result = new JTextField(10);
        result.setEditable(false);
        JButton btn = new JButton("Add");
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String input = a.getText();
                    double aInput = Double.parseDouble(input);
                    input = b.getText();
                    double bInput = Double.parseDouble(input);
                    double sum = aInput + bInput;
                    result.setText(String.valueOf(sum));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers!");
                }
            }
        });

        JLabel primeLabel = new JLabel("Enter Number to Check Prime");
        JTextField primeText = new JTextField(10);
        JButton primeCheck = new JButton("Check");
        JLabel resultPrime = new JLabel("Result");
        primeCheck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = primeText.getText();
                int inputInteger = Integer.parseInt(input);
                boolean isPrime = true;
                for (int i = 2; i < inputInteger; i++) {
                    if (inputInteger % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
                resultPrime.setText(isPrime ? "Prime" : "Not Prime");
            }
        });

        add(labelA);
        add(a);
        add(labelB);
        add(b);
        add(btn);
        add(result);
        add(primeLabel);
        add(primeText);
        add(primeCheck);
        add(resultPrime);

        setLayout(new GridLayout(4, 2, 5, 5));
        setVisible(true);
    }

    public static void main(String args[]) {
        new AddTwoNumbers();
    }
}
