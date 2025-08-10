import java.awt.*;

public class MenuDemo extends Frame {
    TextArea ta;

    public MenuDemo() {
        MenuBar mbar = new MenuBar();
        setMenuBar(mbar);
        Menu files = new Menu("Files");
        Menu date = new Menu("Date");
        Menu exit = new Menu("Exit");
        ta = new TextArea(10, 40);
        ta.setBackground(Color.cyan);
        add(ta);

        mbar.add(files);
        mbar.add(date);
        mbar.add(exit);

        Menu mnew = new Menu("New");
        files.add(mnew);
        Menu mn = new Menu("New Menu");
        mnew.add(mn);
        MenuItem save = new MenuItem("Save");
        files.add(save);
        MenuItem open = new MenuItem("Open");
        files.add(open);
        files.addSeparator();
        MenuItem print = new MenuItem("Print");
        files.add(print);
        CheckboxMenuItem tb = new CheckboxMenuItem("Toolbar");
        files.add(tb);
        date.add(new MenuItem("Today"));
        exit.add(new MenuItem("Close"));
        setSize(500, 300);
        setVisible(true);
    }

    public static void main(String args[]) {
        new MenuDemo();
    }
}
