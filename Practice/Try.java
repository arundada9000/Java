import javax.swing.*;
import java.awt.*;

public class Try extends JFrame {
    Try() {
        setTitle("Choice Buttons");
        setLocation(250, 100);
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel genderPanel = new JPanel();
        JLabel genderLabel = new JLabel("Gender");
        ButtonGroup genderGroup = new ButtonGroup();
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        JRadioButton others = new JRadioButton("Others");

        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(others);

        genderPanel.add(genderLabel);
        genderPanel.add(male);
        genderPanel.add(female);
        genderPanel.add(others);

        JLabel hobbiesLabel = new JLabel("Hobbies");
        JPanel hobbiesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JCheckBox reading = new JCheckBox("Reading");
        JCheckBox writing = new JCheckBox("Writing");
        JCheckBox walking = new JCheckBox("Walking");

        hobbiesPanel.add(hobbiesLabel);
        hobbiesPanel.add(reading);
        hobbiesPanel.add(writing);
        hobbiesPanel.add(walking);

        JLabel countryLabel = new JLabel("Country");
        String countries[] = { "America", "Nepal", "India", "Pakistan" };
        JComboBox<String> comboBox = new JComboBox<>(countries);
        JPanel countryPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        countryPanel.add(countryLabel);
        countryPanel.add(comboBox);

        JPanel sliderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JSlider slider = new JSlider(0, 100, 25);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        JLabel sliderLabel = new JLabel("Sound");
        sliderPanel.add(sliderLabel);
        sliderPanel.add(slider);

        add(genderPanel);
        add(hobbiesPanel);
        add(countryPanel);
        add(sliderPanel);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setVisible(true);
    }

    public static void main(String args[]) {
        new Try();
    }
}
