import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ToDoApp extends JFrame {

    private JPanel taskPanel;
    private JTextField taskField;
    private JButton addButton;
    private JButton clearCompletedButton;
    private ArrayList<JCheckBox> tasks;

    public ToDoApp() {
        setTitle("To-Do List");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        tasks = new ArrayList<>();
        initComponents();
    }

    private void initComponents() {
        // Main container
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setContentPane(mainPanel);

        // Top input panel
        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        taskField = new JTextField();
        addButton = new JButton("Add");
        inputPanel.add(taskField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);
        mainPanel.add(inputPanel, BorderLayout.NORTH);

        // Task panel with scroll
        taskPanel = new JPanel();
        taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(taskPanel);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Bottom control panel
        clearCompletedButton = new JButton("Clear Completed");
        mainPanel.add(clearCompletedButton, BorderLayout.SOUTH);

        // Listeners
        addButton.addActionListener(e -> addTask());
        taskField.addActionListener(e -> addTask());
        clearCompletedButton.addActionListener(e -> clearCompleted());

        // Focus cursor
        SwingUtilities.invokeLater(() -> taskField.requestFocusInWindow());
    }

    private void addTask() {
        String taskText = taskField.getText().trim();
        if (!taskText.isEmpty()) {
            JCheckBox task = new JCheckBox(taskText);
            task.setFont(new Font("SansSerif", Font.PLAIN, 16));
            tasks.add(task);
            taskPanel.add(task);
            taskPanel.revalidate();
            taskPanel.repaint();
            taskField.setText("");
        }
    }

    private void clearCompleted() {
        tasks.removeIf(task -> {
            if (task.isSelected()) {
                taskPanel.remove(task);
                return true;
            }
            return false;
        });
        taskPanel.revalidate();
        taskPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ToDoApp().setVisible(true);
        });
    }
}
