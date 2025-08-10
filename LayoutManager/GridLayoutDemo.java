import javax.swing.*;
import java.awt.*;

public class GridLayoutDemo {
    public static void main(String[] args) {
        JFrame f = new JFrame("GridLayout");
        f.setLayout(new GridLayout(1, 5, 10, 10));

        for (int i = 1; i <= 6; i++) {
            f.add(new JButton("B" + i));
        }

        f.setSize(400, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
