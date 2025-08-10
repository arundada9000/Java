import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.*;

public class AdvancedSwingDemo {
    public static void main(String[] args) {
        JFrame f = new JFrame("Advanced Swing Components");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800, 600);
        f.setLayout(new BorderLayout());

        // ===== DESKTOP PANE for Internal Frames =====
        JDesktopPane desktopPane = new JDesktopPane();
        f.add(desktopPane, BorderLayout.CENTER);

        // ===== BUTTON PANEL =====
        JPanel buttonPanel = new JPanel(new FlowLayout());

        // Option Dialog
        JButton dialogBtn = new JButton("Show Option Dialog");
        dialogBtn.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(f, "Enter your name:");
            if (name != null) {
                JOptionPane.showMessageDialog(f, "Hello, " + name);
            }
        });
        buttonPanel.add(dialogBtn);

        // File Chooser
        JButton fileBtn = new JButton("Open File");
        fileBtn.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            int result = fc.showOpenDialog(f);
            if (result == JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(f, "Selected: " + fc.getSelectedFile());
            }
        });
        buttonPanel.add(fileBtn);

        // Color Chooser
        JButton colorBtn = new JButton("Pick Color");
        colorBtn.addActionListener(e -> {
            Color color = JColorChooser.showDialog(f, "Pick a Color", Color.WHITE);
            if (color != null) {
                f.getContentPane().setBackground(color);
            }
        });
        buttonPanel.add(colorBtn);

        // Internal Frame with Table
        JButton tableBtn = new JButton("Show Table Frame");
        tableBtn.addActionListener(e -> {
            JInternalFrame tableFrame = new JInternalFrame("Table", true, true, true, true);
            String[] columns = {"ID", "Name", "Age"};
            Object[][] data = {
                {1, "Arun", 21},
                {2, "Bishal", 22},
                {3, "Kiran", 20}
            };
            JTable table = new JTable(new DefaultTableModel(data, columns));
            tableFrame.add(new JScrollPane(table), BorderLayout.CENTER);
            tableFrame.pack();
            tableFrame.setVisible(true);
            desktopPane.add(tableFrame);
        });
        buttonPanel.add(tableBtn);

        // Internal Frame with Tree
        JButton treeBtn = new JButton("Show Tree Frame");
        treeBtn.addActionListener(e -> {
            JInternalFrame treeFrame = new JInternalFrame("Tree", true, true, true, true);
            DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
            DefaultMutableTreeNode child1 = new DefaultMutableTreeNode("Child 1");
            DefaultMutableTreeNode child2 = new DefaultMutableTreeNode("Child 2");
            root.add(child1);
            root.add(child2);
            child1.add(new DefaultMutableTreeNode("Leaf 1"));
            child2.add(new DefaultMutableTreeNode("Leaf 2"));
            JTree tree = new JTree(root);
            treeFrame.add(new JScrollPane(tree), BorderLayout.CENTER);
            treeFrame.pack();
            treeFrame.setVisible(true);
            desktopPane.add(treeFrame);
        });
        buttonPanel.add(treeBtn);

        f.add(buttonPanel, BorderLayout.NORTH);

        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
