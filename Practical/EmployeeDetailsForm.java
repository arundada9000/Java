import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class EmployeeDetailsForm extends JFrame implements ActionListener {
    private JTextField nameField, ageField, salaryField;
    private JComboBox<String> genderComboBox;
    private JButton saveButton;

    public EmployeeDetailsForm() {
        setTitle("Employee Details Form");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 2));

        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Age:"));
        ageField = new JTextField();
        panel.add(ageField);

        panel.add(new JLabel("Gender:"));
        genderComboBox = new JComboBox<>(new String[] { "Male", "Female" });
        panel.add(genderComboBox);

        panel.add(new JLabel("Salary:"));
        salaryField = new JTextField();
        panel.add(salaryField);

        saveButton = new JButton("Save");
        saveButton.addActionListener(this);
        panel.add(saveButton);

        add(panel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            saveEmployeeDetails();
        }
    }

    private void saveEmployeeDetails() {
        String name = nameField.getText();
        String age = ageField.getText();
        String gender = (String) genderComboBox.getSelectedItem();
        String salary = salaryField.getText();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("employee_details.txt", true))) {
            bw.write("Name: " + name + ", Age: " + age + ", Gender: " + gender + ", Salary: " + salary);
            bw.newLine();
            JOptionPane.showMessageDialog(this, "Employee details saved successfully!", "Success",
                    JOptionPane.INFORMATION_MESSAGE);

            // Clear fields after saving
            nameField.setText("");
            ageField.setText("");
            salaryField.setText("");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error while saving employee details.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EmployeeDetailsForm().setVisible(true);
        });
    }
}
