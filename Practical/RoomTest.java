class Room {
    int length;
    int breadth;

    Room(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    int getArea() {
        return length * breadth;
    }
}

class Bedroom extends Room {
    int height;

    Bedroom(int length, int breadth, int height) {
        super(length, breadth);
        this.height = height;
    }

    int getVolume() {
        return getArea() * height;
    }
}

public class RoomTest {
    public static void main(String[] args) {
        Bedroom room1 = new Bedroom(10, 12, 8);
        Bedroom room2 = new Bedroom(15, 14, 10);

        System.out.println("Bedroom 1 -> Area: " + room1.getArea() + ", Volume: " + room1.getVolume());
        System.out.println("Bedroom 2 -> Area: " + room2.getArea() + ", Volume: " + room2.getVolume());
    }
}
