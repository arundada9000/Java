import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CodeSnippetManager extends JFrame {
    private DefaultListModel<String> snippetTitlesModel;
    private JList<String> snippetList;
    private JTextArea snippetContentArea;
    private JTextField searchField, titleField;
    private JButton addButton, deleteButton;

    // Store snippets as objects for title + content
    private ArrayList<Snippet> snippets = new ArrayList<>();

    public CodeSnippetManager() {
        setTitle("Code Snippet Manager");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Top search bar
        JPanel topPanel = new JPanel(new BorderLayout(5, 5));
        searchField = new JTextField();
        searchField.setToolTipText("Search snippets...");
        topPanel.add(new JLabel("Search: "), BorderLayout.WEST);
        topPanel.add(searchField, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);

        // Left: snippet titles list
        snippetTitlesModel = new DefaultListModel<>();
        snippetList = new JList<>(snippetTitlesModel);
        snippetList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(snippetList);
        listScrollPane.setPreferredSize(new Dimension(200, 0));
        add(listScrollPane, BorderLayout.WEST);

        // Center: snippet content
        snippetContentArea = new JTextArea();
        snippetContentArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        snippetContentArea.setLineWrap(true);
        snippetContentArea.setWrapStyleWord(true);
        JScrollPane contentScrollPane = new JScrollPane(snippetContentArea);
        add(contentScrollPane, BorderLayout.CENTER);

        // Bottom: Add snippet panel
        JPanel bottomPanel = new JPanel(new BorderLayout(5, 5));
        titleField = new JTextField();
        titleField.setToolTipText("Snippet Title");
        addButton = new JButton("Add Snippet");
        deleteButton = new JButton("Delete Selected");

        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        inputPanel.add(new JLabel("Title:"), BorderLayout.WEST);
        inputPanel.add(titleField, BorderLayout.CENTER);

        bottomPanel.add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        bottomPanel.add(buttonPanel, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH);

        // Event handlers
        addButton.addActionListener(e -> addSnippet());
        deleteButton.addActionListener(e -> deleteSnippet());

        snippetList.addListSelectionListener(e -> showSelectedSnippet());

        searchField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                filterSnippets();
            }

            public void removeUpdate(DocumentEvent e) {
                filterSnippets();
            }

            public void changedUpdate(DocumentEvent e) {
                filterSnippets();
            }
        });
    }

    private void addSnippet() {
        String title = titleField.getText().trim();
        String content = snippetContentArea.getText().trim();

        if (title.isEmpty() || content.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Both title and content are required.", "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Prevent duplicate titles
        for (Snippet snip : snippets) {
            if (snip.title.equalsIgnoreCase(title)) {
                JOptionPane.showMessageDialog(this, "Snippet title must be unique.", "Duplicate Title",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        Snippet newSnippet = new Snippet(title, content);
        snippets.add(newSnippet);
        snippetTitlesModel.addElement(title);

        titleField.setText("");
        snippetContentArea.setText("");
        snippetList.setSelectedIndex(snippetTitlesModel.size() - 1);
    }

    private void deleteSnippet() {
        int idx = snippetList.getSelectedIndex();
        if (idx == -1) {
            JOptionPane.showMessageDialog(this, "Select a snippet to delete.", "No Selection",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        snippets.remove(idx);
        snippetTitlesModel.remove(idx);
        snippetContentArea.setText("");
    }

    private void showSelectedSnippet() {
        int idx = snippetList.getSelectedIndex();
        if (idx != -1) {
            Snippet selected = snippets.get(idx);
            snippetContentArea.setText(selected.content);
        }
    }

    private void filterSnippets() {
        String query = searchField.getText().toLowerCase();
        snippetTitlesModel.clear();
        for (Snippet snip : snippets) {
            if (snip.title.toLowerCase().contains(query) || snip.content.toLowerCase().contains(query)) {
                snippetTitlesModel.addElement(snip.title);
            }
        }
        snippetContentArea.setText("");
    }

    private static class Snippet {
        String title;
        String content;

        Snippet(String title, String content) {
            this.title = title;
            this.content = content;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CodeSnippetManager app = new CodeSnippetManager();
            app.setVisible(true);
        });
    }
}
