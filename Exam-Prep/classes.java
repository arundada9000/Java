public class classes {
    public static void main(String args[]) {
        Box.showCount();
        Box.count = 1;

        Box bx = new Box(1, 2, 3);
        int area = bx.findArea();
        int volume = bx.findVolume();
        System.out.println(area);
        System.out.println(volume);
        Box.showCount();

        Box b = new Box(2, 3, 4);
        System.out.println(bx.compareLength(b));
        Box.showCount();
    }
}

class Box {
    private int l;
    private int b;
    private int h;
    static int count = 0;

    Box(int x, int y, int z) {
        l = x;
        b = y;
        h = z;
        count++;
    }

    public boolean compareLength(Box b) {

        return this.l > b.l;
    }

    public int findArea() {
        return l * b;
    }

    public int findVolume() {
        return l * b * h;
    }

    static void showCount() {
        System.out.println("Total objects : " + count);
    }
}
