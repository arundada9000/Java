import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class SwingWidgetsExample extends JFrame {

    public SwingWidgetsExample() {
        setTitle("Swing Widgets Demo");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main Panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        add(mainPanel);

        // ===== RADIO BUTTONS =====
        JPanel radioPanel = new JPanel();
        radioPanel.setBorder(new TitledBorder("Choose Gender"));

        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        JRadioButton other = new JRadioButton("Other");

        ButtonGroup genderGroup = new ButtonGroup(); // Only one can be selected
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        radioPanel.add(male);
        radioPanel.add(female);
        radioPanel.add(other);

        // ===== CHECKBOXES =====
        JPanel checkboxPanel = new JPanel();
        checkboxPanel.setBorder(new TitledBorder("Hobbies"));

        JCheckBox reading = new JCheckBox("Reading");
        JCheckBox sports = new JCheckBox("Sports");
        JCheckBox coding = new JCheckBox("Coding");

        checkboxPanel.add(reading);
        checkboxPanel.add(sports);
        checkboxPanel.add(coding);
        checkboxPanel.setLayout(new GridLayout(1, 3));

        // ===== SLIDER =====
        JPanel sliderPanel = new JPanel();
        sliderPanel.setBorder(new TitledBorder("Volume"));

        JSlider volumeSlider = new JSlider(0, 100, 50); // min, max, initial
        volumeSlider.setMajorTickSpacing(20);
        volumeSlider.setMinorTickSpacing(5);
        volumeSlider.setPaintTicks(true);
        volumeSlider.setPaintLabels(true);

        sliderPanel.add(volumeSlider);

        // ===== COMBO BOX =====
        JPanel comboPanel = new JPanel();
        comboPanel.setBorder(new TitledBorder("Select Country"));

        String[] countries = { "India", "USA", "UK", "Canada", "Germany" };
        JComboBox<String> countryCombo = new JComboBox<>(countries);

        comboPanel.add(countryCombo);

        // Add all panels to main panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        centerPanel.add(radioPanel);
        centerPanel.add(checkboxPanel);
        centerPanel.add(sliderPanel);
        centerPanel.add(comboPanel);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new SwingWidgetsExample();
    }
}
