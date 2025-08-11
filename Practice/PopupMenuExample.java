import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PopupMenuExample extends JFrame {

    public PopupMenuExample() {
        setTitle("Popup Menu Example");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea textArea = new JTextArea("Right-click here!");
        textArea.setFont(new Font("Arial", Font.BOLD, 16));
        add(new JScrollPane(textArea));

        // ===== Create Popup Menu =====
        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem paste = new JMenuItem("Paste");

        popupMenu.add(cut);
        popupMenu.add(copy);
        popupMenu.add(paste);

        // copy.setAccelerator(KeyStroke.getKeyStroke("ctrl C"));
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        paste.setAccelerator(KeyStroke.getKeyStroke("ctrl v"));
        cut.setAccelerator(KeyStroke.getKeyStroke("ctrl x"));

        // ===== Add ActionListeners (Optional) =====
        cut.addActionListener(e -> textArea.cut());
        copy.addActionListener(e -> textArea.copy());
        paste.addActionListener(e -> textArea.paste());

        // ===== Show popup on right-click =====
        textArea.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                showPopup(e);
            }

            public void mouseReleased(MouseEvent e) {
                showPopup(e);
            }

            private void showPopup(MouseEvent e) {
                if (e.isPopupTrigger()) { // platform-independent right-click
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        JOptionPane.showMessageDialog(null, "You chose Yes!");
        setVisible(true);
    }

    public static void main(String[] args) {
        new PopupMenuExample();
    }
}
