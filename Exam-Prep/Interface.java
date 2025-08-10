public class Interface {
    public static void main(String args[]) {
        Circle c = new Circle(5);
        System.out.println(c.showArea());

        Rectangle r = new Rectangle(1, 2, 3);
        System.out.println(r.showArea());
        System.out.println(r.showVolume());
    }
}

interface Shape {
    double PI = 3.1415;

    double showArea();
}

interface Volume extends Shape {
    double showVolume();
}

class Circle implements Shape {
    private double r;

    Circle(double r) {
        this.r = r;
    }

    public double showArea() {
        return PI * r * r;
    }
}

class Rectangle implements Shape, Volume {
    double l, b, h;

    Rectangle(double l, double b, double h) {
        this.l = l;
        this.b = b;
        this.h = h;
    }

    public double showArea() {
        return l * b;
    }

    public double showVolume() {
        return l * b * h;
    }
}