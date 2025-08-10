import java.awt.*;

public class FileDialogDemo extends Frame {
    public FileDialogDemo() {
        setSize(800, 500);
        setVisible(true);
        setTitle("Dialog Box Example");
        setLocation(300, 300);
        FileDialog d = new FileDialog(this, "Open dialog Box", FileDialog.LOAD);
        d.setSize(200, 100);
        d.setLocation(100, 100);
        d.setVisible(true);
    }

    public static void main(String args[]) {
        new FileDialogDemo();
    }
}
