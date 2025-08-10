import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TodoListApp extends JFrame {
    private DefaultListModel<String> taskModel;
    private JList<String> taskList;
    private JTextField taskField;
    private JButton addButton, removeButton;

    public TodoListApp() {
        setTitle("Simple To-Do List");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        taskModel = new DefaultListModel<>();
        taskList = new JList<>(taskModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(taskList);

        taskField = new JTextField();
        addButton = new JButton("Add Task");
        removeButton = new JButton("Remove Selected");

        addButton.addActionListener(e -> addTask());
        removeButton.addActionListener(e -> removeTask());

        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        inputPanel.add(taskField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        JPanel controlPanel = new JPanel(new BorderLayout());
        controlPanel.add(inputPanel, BorderLayout.NORTH);
        controlPanel.add(removeButton, BorderLayout.SOUTH);

        setLayout(new BorderLayout(10, 10));
        add(scrollPane, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
    }

    private void addTask() {
        String task = taskField.getText().trim();
        if (!task.isEmpty()) {
            taskModel.addElement(task);
            taskField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Task cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removeTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            taskModel.remove(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(this, "Select a task to remove.", "No Selection",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TodoListApp app = new TodoListApp();
            app.setVisible(true);
        });
    }
}
