import java.awt.*;

public class FirstFrame extends Frame {
    FirstFrame() {
        Button b = new Button("Click me");
        b.setBounds(30, 100, 80, 30);
        setTitle("Frame by Inheritance");
        add(b);
        setSize(10000, 10000);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String args[]) {
        FirstFrame f = new FirstFrame();
    }
}