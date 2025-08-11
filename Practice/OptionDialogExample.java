import javax.swing.*;

public class OptionDialogExample {
    public static void main(String[] args) {
        String[] options = { "Yes", "No", "Maybe" };

        int choice = JOptionPane.showOptionDialog(
                null, // parent component
                "Do you like Java?", // message
                "Question", // title
                JOptionPane.DEFAULT_OPTION, // option type
                JOptionPane.QUESTION_MESSAGE, // message type (icon)
                null, // custom icon (null = default)
                options, // custom button labels
                options[0] // default selected button
        );

        // Show what was selected
        switch (choice) {
            case 0 -> JOptionPane.showMessageDialog(null, "You chose Yes!");
            case 1 -> JOptionPane.showMessageDialog(null, "You chose No.");
            case 2 -> JOptionPane.showMessageDialog(null, "You chose Maybe?");
            default -> JOptionPane.showMessageDialog(null, "You closed the dialog.");
        }
    }
}
