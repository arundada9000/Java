import javax.swing.*;

public class GroupLayoutDemo {
    public static void main(String[] args) {
        JFrame f = new JFrame("GroupLayout");
        JButton b1 = new JButton("One");
        JButton b2 = new JButton("Two");

        GroupLayout layout = new GroupLayout(f.getContentPane());
        f.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(b1)
                        .addComponent(b2));

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(b1)
                        .addComponent(b2));

        f.setSize(300, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
