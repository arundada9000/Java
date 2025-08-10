import javax.swing.*;
import java.awt.event.*;

public class ItemEventDemo {
    public static void main(String[] args) {
        JFrame f = new JFrame("Item Event Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JCheckBox cb = new JCheckBox("Accept Terms");
        cb.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED)
                System.out.println("Checked");
            else
                System.out.println("Unchecked");
        });

        f.add(cb);
        f.pack();
        f.setVisible(true);
    }
}
