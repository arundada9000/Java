import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventHandlingDemo extends JFrame implements
        ActionListener, KeyListener, FocusListener,
        MouseListener, MouseMotionListener,
        WindowListener, ItemListener {

    JTextArea log;
    JButton btn;
    JTextField tf;
    JCheckBox cb;
    JComboBox<String> combo;

    public EventHandlingDemo() {
        super("Event Handling Demo");
        setLayout(new FlowLayout());

        // Components
        btn = new JButton("Click Me");
        tf = new JTextField(10);
        cb = new JCheckBox("Check me");
        combo = new JComboBox<>(new String[] { "Option 1", "Option 2", "Option 3" });
        log = new JTextArea(15, 40);
        log.setEditable(false);

        JScrollPane sp = new JScrollPane(log);

        // Action Events
        btn.setActionCommand("BUTTON_CLICK");
        tf.setActionCommand("TEXTFIELD_ENTER");
        btn.addActionListener(this);
        tf.addActionListener(this);

        // Item Events
        cb.addItemListener(this);
        combo.addItemListener(this);

        // Key Events
        tf.addKeyListener(this);

        // Focus Events
        tf.addFocusListener(this);

        // Mouse Events
        btn.addMouseListener(this);
        btn.addMouseMotionListener(this);

        // Window Events
        addWindowListener(this);

        add(btn);
        add(tf);
        add(cb);
        add(combo);
        add(sp);

        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // ===== ActionListener =====
    @Override
    public void actionPerformed(ActionEvent e) {
        log.append("Action Event from: " + e.getSource().getClass().getSimpleName()
                + " | Command: " + e.getActionCommand() + "\n");
    }

    // ===== ItemListener =====
    @Override
    public void itemStateChanged(ItemEvent e) {
        String state = (e.getStateChange() == ItemEvent.SELECTED) ? "Selected" : "Deselected";
        log.append("Item Event: " + e.getItem() + " - " + state + "\n");
    }

    // ===== KeyListener =====
    @Override
    public void keyPressed(KeyEvent e) {
        log.append("Key Pressed: " + e.getKeyChar() + "\n");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        log.append("Key Released: " + e.getKeyChar() + "\n");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        log.append("Key Typed: " + e.getKeyChar() + "\n");
    }

    // ===== FocusListener =====
    @Override
    public void focusGained(FocusEvent e) {
        log.append("Focus Gained on: " + e.getComponent().getClass().getSimpleName() + "\n");
    }

    @Override
    public void focusLost(FocusEvent e) {
        log.append("Focus Lost from: " + e.getComponent().getClass().getSimpleName() + "\n");
    }

    // ===== MouseListener =====
    @Override
    public void mouseClicked(MouseEvent e) {
        log.append("Mouse Clicked on Button\n");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        log.append("Mouse Pressed on Button\n");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        log.append("Mouse Released on Button\n");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        log.append("Mouse Entered Button\n");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        log.append("Mouse Exited Button\n");
    }

    // ===== MouseMotionListener =====
    @Override
    public void mouseDragged(MouseEvent e) {
        log.append("Mouse Dragged on Button\n");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        log.append("Mouse Moved over Button\n");
    }

    // ===== WindowListener =====
    @Override
    public void windowOpened(WindowEvent e) {
        log.append("Window Opened\n");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        log.append("Window Closing\n");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        log.append("Window Closed\n");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        log.append("Window Minimized\n");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        log.append("Window Restored\n");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        log.append("Window Activated\n");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        log.append("Window Deactivated\n");
    }

    public static void main(String[] args) {
        new EventHandlingDemo();
    }
}
