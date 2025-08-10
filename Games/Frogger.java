import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class Frogger extends JPanel implements ActionListener, KeyListener {

    private final int WIDTH = 600, HEIGHT = 600;
    private final int LANE_HEIGHT = 50;
    private final int FROG_SIZE = 40;

    private Timer timer;
    private int frogX, frogY;
    private boolean gameOver = false;
    private boolean gameWon = false;

    private ArrayList<CarLane> lanes = new ArrayList<>();

    public Frogger() {
        JFrame frame = new JFrame("Frogger - Java Classic");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        setFocusable(true);
        addKeyListener(this);
        setBackground(Color.black);

        initGame();

        timer = new Timer(30, this);
        timer.start();
    }

    private void initGame() {
        frogX = WIDTH / 2 - FROG_SIZE / 2;
        frogY = HEIGHT - FROG_SIZE - 10;

        lanes.clear();
        Random rand = new Random();

        // Create 5 dynamic car lanes (leaving bottom lane as safe zone)
        for (int i = 1; i <= 5; i++) {
            int y = HEIGHT - (i + 1) * LANE_HEIGHT;
            int dir = rand.nextBoolean() ? 1 : -1;
            int speed = 2 + rand.nextInt(3);
            lanes.add(new CarLane(y, dir * speed));
        }

        gameOver = false;
        gameWon = false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw background and lanes
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        for (int i = 0; i < HEIGHT / LANE_HEIGHT; i++) {
            g.setColor(i % 2 == 0 ? Color.gray : Color.lightGray);
            g.fillRect(0, HEIGHT - (i + 1) * LANE_HEIGHT, WIDTH, LANE_HEIGHT);
        }

        // Draw frog
        g.setColor(Color.green);
        g.fillOval(frogX, frogY, FROG_SIZE, FROG_SIZE);

        // Draw cars
        g.setColor(Color.red);
        for (CarLane lane : lanes) {
            for (Car car : lane.cars) {
                g.fillRect(car.x, car.y, car.width, car.height);
            }
        }

        // Game over or win message
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 28));
        if (gameOver) {
            g.drawString("Game Over! Press R to Restart", 100, HEIGHT / 2);
        } else if (gameWon) {
            g.drawString("You Win! Press R to Restart", 120, HEIGHT / 2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver && !gameWon) {
            for (CarLane lane : lanes) {
                lane.update();
                for (Car car : lane.cars) {
                    if (checkCollision(car)) {
                        gameOver = true;
                        timer.stop();
                    }
                }
            }

            if (frogY <= 10) {
                gameWon = true;
                timer.stop();
            }
        }
        repaint();
    }

    private boolean checkCollision(Car car) {
        Rectangle frogRect = new Rectangle(frogX, frogY, FROG_SIZE, FROG_SIZE);
        Rectangle carRect = new Rectangle(car.x, car.y, car.width, car.height);
        return frogRect.intersects(carRect);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (gameOver || gameWon) {
            if (e.getKeyCode() == KeyEvent.VK_R) {
                initGame();
                timer.start();
                repaint();
            }
            return;
        }

        int key = e.getKeyCode();
        int moveStep = LANE_HEIGHT;

        if (key == KeyEvent.VK_LEFT && frogX - moveStep >= 0) {
            frogX -= moveStep;
        } else if (key == KeyEvent.VK_RIGHT && frogX + moveStep + FROG_SIZE <= WIDTH) {
            frogX += moveStep;
        } else if (key == KeyEvent.VK_UP && frogY - moveStep >= 0) {
            frogY -= moveStep;
        } else if (key == KeyEvent.VK_DOWN && frogY + moveStep + FROG_SIZE <= HEIGHT) {
            frogY += moveStep;
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    // === CarLane manages its own car list & spawning ===
    private static class CarLane {
        int y, speed;
        ArrayList<Car> cars = new ArrayList<>();
        int spawnCooldown = 0;
        Random rand = new Random();

        public CarLane(int y, int speed) {
            this.y = y;
            this.speed = speed;
        }

        public void update() {
            spawnCooldown--;
            if (spawnCooldown <= 0) {
                int x = (speed > 0) ? -60 : 660;
                cars.add(new Car(x, y, speed));
                spawnCooldown = 60 + rand.nextInt(80); // adjust spawn delay
            }

            for (int i = 0; i < cars.size(); i++) {
                Car car = cars.get(i);
                car.move(600);
                if (car.x < -car.width || car.x > 660) {
                    cars.remove(i--);
                }
            }
        }
    }

    // === Car object ===
    private static class Car {
        int x, y, speed;
        int width = 60, height = 40;

        public Car(int x, int y, int speed) {
            this.x = x;
            this.y = y;
            this.speed = speed;
        }

        public void move(int boundaryWidth) {
            x += speed;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Frogger::new);
    }
}
