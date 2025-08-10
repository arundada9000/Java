class ThreadDemo implements Runnable {
    String tName;

    ThreadDemo(String n) {
        tName = n;
        System.out.print("Creating : " + n + "   ");
    }

    public void run() {
        System.out.print("Running " + tName + "   ");
        try {
            for (int i = 4; i > 0; i--) {
                System.out.print("Thread " + tName + " Printing " + i + "   ");
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.print("Thread " + tName + " interrupted.   ");
        }
        System.out.print("Thread " + tName + " exiting.   ");
    }
}

public class TestThread {
    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo("One");
        Thread t1 = new Thread(td);
        t1.start();

        ThreadDemo td2 = new ThreadDemo("Two");
        Thread t2 = new Thread(td2);
        t2.start();

        System.out.println("End of Lines.");

    }
}