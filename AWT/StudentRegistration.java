import java.awt.*;

import org.w3c.dom.Text;

public class StudentRegistration extends Frame {
    Label lblhd = new Label("Student details", Label.CENTER);
    Label lblname = new Label("Name", Label.LEFT);
    Label lblage = new Label("Age", Label.LEFT);
    Label lblsex = new Label("Sex(M/F)", Label.LEFT);
    Label lbladdress = new Label("Address", Label.LEFT);
    Label lblcourse = new Label("Course", Label.LEFT);
    Label lblsem = new Label("Semester", Label.LEFT);
    Label l7 = new Label("", Label.RIGHT);
    Label lblhobbies = new Label("Hobbies", Label.LEFT);
    TextField txtname = new TextField();
    Choice chage = new Choice();
    CheckboxGroup cbg = new CheckboxGroup();
    Checkbox chkmale = new Checkbox("Male", cbg, true);
    Checkbox chkfemale = new Checkbox("Female", cbg, true);
    List hb = new List(3, true);
    TextArea txtaddress = new TextArea("", 180, 90, TextArea.SCROLLBARS_VERTICAL_ONLY);
    Choice course = new Choice();
    Choice sem = new Choice();
    Choice age = new Choice();
    Button b1 = new Button("Save");

    StudentRegistration() {
        setBackground(Color.black);
        setForeground(Color.white);
        setLayout(null);

        lblhd.setBounds(10, 40, 280, 20);
        add(lblhd);

        lblname.setBounds(25, 65, 90, 20);
        add(lblname);

        txtname.setBounds(25, 90, 90, 20);
        txtname.setBackground(Color.black);
        txtname.setForeground(Color.white);
        add(txtname);

        lblage.setBounds(25, 90, 90, 20);
        add(lblage);
        chage.setBounds(120, 90, 50, 20);
        chage.setBackground(Color.black);
        chage.setForeground(Color.white);
        add(chage);
        chage.add("17");
        chage.add("18");
        chage.add("19");
        chage.add("20");
        chage.add("21");

        lblsex.setBounds(25, 120, 90, 20);
        add(lblsex);
        chkmale.setBounds(120, 120, 50, 20);
        chkfemale.setBounds(170, 120, 60, 20);
        add(chkmale);
        chkmale.setBackground(Color.black);
        chkmale.setForeground(Color.white);
        add(chkfemale);
        chkfemale.setBackground(Color.black);
        chkfemale.setForeground(Color.white);

        lblhobbies.setBounds(25, 150, 90, 20);
        add(lblhobbies);
        hb.setBounds(120, 150, 90, 50);
        hb.setBackground(Color.black);
        hb.setForeground(Color.white);
        add(hb);
        hb.add("Playing");
        hb.add("Visiting");
        hb.add("Reading");
        hb.add("Swimming");

        lbladdress.setBounds(25, 230, 90, 20);
        add(lbladdress);
        txtaddress.setBounds(120, 230, 170, 60);
        txtaddress.setBackground(Color.black);
        txtaddress.setForeground(Color.white);
        add(txtaddress);
        lblcourse.setBounds(25, 305, 90, 20);
        add(lblcourse);
        course.setBounds(120, 305, 100, 20);
        course.add("Bsc.csit");
        course.add("BIM");
        course.add("BIT");
        course.add("BCA");
        course.add("B.E. Computer");
        course.setBackground(Color.black);
        course.setForeground(Color.white);
        add(course);

        lblsem.setBounds(25, 335, 90, 20);
        add(lblsem);
        sem.add("1");
        sem.add("2");
        sem.add("3");
        sem.add("4");
        sem.add("5");
        sem.add("6");
        sem.add("7");
        sem.add("8");
        sem.setBounds(120, 335, 50, 20);
        sem.setBackground(Color.black);
        sem.setForeground(Color.white);
        add(sem);

        l7.setBounds(25, 225, 90, 20);
        add(l7);

        b1.setBounds(120, 400, 50, 30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        add(b1);

    }

    public static void main(String args[]) {
        StudentRegistration stu = new StudentRegistration();
        stu.setSize(new Dimension(500, 500));
        stu.setTitle("Student Registration");
        stu.setVisible(true);
    }
}
