import javax.swing.*;
import java.awt.*;

public class MenuPractice extends JFrame {
    MenuPractice() {
        setTitle("Menu Bar example");
        setSize(500, 500);
        setLocation(250, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        JMenu filesMenu = new JMenu("Files");
        filesMenu.setMnemonic('m');
        filesMenu.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));

        JMenuItem open = new JMenuItem("Open", new ImageIcon("tulsa1.png"));
        JMenuItem savePlaylist = new JMenuItem("Save Playlist", new ImageIcon("tulsa1.png"));
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(e -> System.exit(0));
        exit.setToolTipText("Click to Exit");

        filesMenu.add(open);
        filesMenu.add(savePlaylist);
        filesMenu.add(exit);

        JMenu settingMenu = new JMenu("Setting");
        JMenu themes = new JMenu("Themes");
        JMenuItem darkMode = new JMenuItem("Dark Mode", new ImageIcon("tulsa1.png"));
        JMenuItem lightMode = new JMenuItem("Light Mode", new ImageIcon("tulsa1.png"));
        JCheckBoxMenuItem checkBoxMenuItem = new JCheckBoxMenuItem("Sorry");
        JCheckBoxMenuItem checkBoxMenuItem1 = new JCheckBoxMenuItem("Sorry1");
        JRadioButtonMenuItem radioButtonMenuItem1 = new JRadioButtonMenuItem("Radio1");
        JRadioButtonMenuItem radioButtonMenuItem2 = new JRadioButtonMenuItem("Radio2");

        themes.add(darkMode);
        themes.add(lightMode);
        themes.add(checkBoxMenuItem);
        themes.add(checkBoxMenuItem1);
        themes.add(radioButtonMenuItem1);
        themes.add(radioButtonMenuItem2);
        settingMenu.add(themes);

        JMenu soundMenu = new JMenu();
        soundMenu.setIcon(new ImageIcon("tulsa1.png"));
        JMenuItem equalizer = new JMenuItem("Equalizer", new ImageIcon("tulsa1.png"));
        JMenuItem volume = new JMenuItem("Volume", new ImageIcon("tulsa1.png"));

        soundMenu.add(equalizer);
        soundMenu.add(volume);

        menuBar.add(filesMenu);
        menuBar.add(settingMenu);
        menuBar.add(soundMenu);
        setJMenuBar(menuBar);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuPractice();
    }
}