import javax.swing.*;
import java.awt.*;

public class FlowLayoutDemo {
    public static void main(String[] args) {
        JFrame f = new JFrame("FlowLayout");
        f.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));

        for (int i = 1; i <= 5; i++) {
            f.add(new JButton("Button " + i));
        }

        f.setSize(300, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
