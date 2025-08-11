import javax.swing.*;
import java.awt.*;

public class MenuDemo extends JFrame {
    MenuDemo() {
        setTitle("Menu Example");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(200, 100);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create top-level menu items
        JMenu save = new JMenu("Save");
        JMenu more = new JMenu("More");

        // Create sub-menu items
        JMenuItem share = new JMenuItem("Share");
        JMenuItem picture = new JMenuItem("Picture", new ImageIcon("tulsa1.png"));

        Icon icon = new ImageIcon("tulsa1.png");
        JMenuItem pic = new JMenuItem();
        pic.setIcon(icon);

        // Add menu items to menus
        more.add(share);
        more.add(picture);
        more.add(pic);

        // Add top-level menus to menu bar
        menuBar.add(save);
        menuBar.add(more);

        // Set the menu bar on the frame
        setJMenuBar(menuBar);

        // Optional layout and visibility
        setLayout(new FlowLayout());
        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuDemo();
    }
}
