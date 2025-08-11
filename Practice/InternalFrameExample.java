import javax.swing.*;

public class InternalFrameExample extends JFrame {

    public InternalFrameExample() {
        setTitle("Internal Frame Demo");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Desktop pane to hold internal frames
        JDesktopPane desktopPane = new JDesktopPane();

        // === First Internal Frame ===
        JInternalFrame frame1 = new JInternalFrame("Frame 1", true, true, true, true);
        frame1.setSize(200, 150);
        frame1.setLocation(30, 30);
        frame1.setVisible(true);
        frame1.add(new JLabel("This is Frame 1"));

        // === Second Internal Frame ===
        JInternalFrame frame2 = new JInternalFrame("Frame 2", true, true, true, true);
        frame2.setSize(200, 150);
        frame2.setLocation(250, 100);
        frame2.setVisible(true);
        frame2.add(new JLabel("This is Frame 2"));

        // Add internal frames to the desktop pane
        desktopPane.add(frame1);
        desktopPane.add(frame2);

        // Add desktop pane to main frame
        add(desktopPane);

        setVisible(true);
    }

    public static void main(String[] args) {
        new InternalFrameExample();
    }
}
