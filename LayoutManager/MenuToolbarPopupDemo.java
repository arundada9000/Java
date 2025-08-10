import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuToolbarPopupDemo {
    public static void main(String[] args) {
        JFrame f = new JFrame("Menus & Toolbars Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 400);
        f.setLayout(new BorderLayout());

        // ===== MENU BAR =====
        JMenuBar menuBar = new JMenuBar();

        // File Menu
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F); // Alt+F to open menu

        JMenuItem newItem = new JMenuItem("New", new ImageIcon("icon_new.png"));
        newItem.setMnemonic(KeyEvent.VK_N); // Keyboard letter in menu
        newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK)); // Ctrl+N
        newItem.addActionListener(e -> System.out.println("New File Created"));
        fileMenu.add(newItem);

        JMenuItem openItem = new JMenuItem("Open");
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        openItem.addActionListener(e -> System.out.println("File Opened"));
        fileMenu.add(openItem);

        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.setEnabled(false); // Disabled item
        fileMenu.add(saveItem);

        fileMenu.addSeparator(); // Separator line

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        // Edit Menu
        JMenu editMenu = new JMenu("Edit");

        JCheckBoxMenuItem wrapItem = new JCheckBoxMenuItem("Word Wrap");
        wrapItem.addItemListener(e -> System.out.println("Word Wrap: " + wrapItem.isSelected()));
        editMenu.add(wrapItem);

        JRadioButtonMenuItem rbLight = new JRadioButtonMenuItem("Light Mode");
        JRadioButtonMenuItem rbDark = new JRadioButtonMenuItem("Dark Mode");
        ButtonGroup themeGroup = new ButtonGroup();
        themeGroup.add(rbLight);
        themeGroup.add(rbDark);
        editMenu.add(rbLight);
        editMenu.add(rbDark);

        // Add Menus to MenuBar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        f.setJMenuBar(menuBar);

        // ===== TOOLBAR =====
        JToolBar toolBar = new JToolBar();
        JButton tbNew = new JButton("New");
        tbNew.setToolTipText("Create a new file (Ctrl+N)"); // Tooltip
        tbNew.addActionListener(e -> System.out.println("Toolbar: New clicked"));
        toolBar.add(tbNew);

        JButton tbOpen = new JButton("Open");
        tbOpen.setToolTipText("Open an existing file");
        tbOpen.addActionListener(e -> System.out.println("Toolbar: Open clicked"));
        toolBar.add(tbOpen);

        JButton tbSave = new JButton("Save");
        tbSave.setToolTipText("Save the current file");
        tbSave.setEnabled(false);
        toolBar.add(tbSave);

        f.add(toolBar, BorderLayout.NORTH);

        // ===== POPUP MENU =====
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem cutItem = new JMenuItem("Cut");
        cutItem.addActionListener(e -> System.out.println("Cut Action"));
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");
        popupMenu.add(cutItem);
        popupMenu.add(copyItem);
        popupMenu.add(pasteItem);

        JTextArea textArea = new JTextArea();
        textArea.setComponentPopupMenu(popupMenu); // right-click inside textarea shows popup
        textArea.setToolTipText("Right-click for options"); // Tooltip
        f.add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Show frame
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
