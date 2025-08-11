import javax.swing.*;
import java.awt.event.*;

public class SimplePopup extends JFrame {

    public SimplePopup() {
        setTitle("Simple Popup Menu");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create popup menu
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem item1 = new JMenuItem("Option 1");
        JMenuItem item2 = new JMenuItem("Option 2");
        popupMenu.add(item1);
        popupMenu.add(item2);

        // Add popup to the frame (or any component)
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                showPopup(e);
            }

            public void mouseReleased(MouseEvent e) {
                showPopup(e);
            }

            private void showPopup(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new SimplePopup();
    }
}
