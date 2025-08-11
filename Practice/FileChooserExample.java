import javax.swing.*;
import java.io.File;

public class FileChooserExample {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();

        int result = fileChooser.showOpenDialog(null); // or showSaveDialog(null)

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(null, "Selected file: " + selectedFile.getAbsolutePath());
        } else {
            JOptionPane.showMessageDialog(null, "No file selected.");
        }
    }
}
