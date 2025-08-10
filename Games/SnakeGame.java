import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class SnakeGame extends JPanel implements ActionListener, KeyListener {

    private final int WIDTH = 600, HEIGHT = 600;
    private final int UNIT_SIZE = 25;

    private final ArrayList<Point> snake = new ArrayList<>();
    private Point food;
    private char direction = 'R'; // U, D, L, R
    private boolean running = false;
    private Timer timer;
    private int score = 0;

    public SnakeGame() {
        JFrame frame = new JFrame("Snake Game - Java Classic");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        this.setBackground(Color.black);
        this.setFocusable(true);
        this.requestFocusInWindow(); // request focus to receive keyboard input
        this.addKeyListener(this); // add listener to JPanel, not JFrame

        startGame();
    }

    private void startGame() {
        snake.clear();

        // Initialize snake with 3 segments for safer start
        snake.add(new Point(UNIT_SIZE * 5, UNIT_SIZE * 5)); // Head
        snake.add(new Point(UNIT_SIZE * 4, UNIT_SIZE * 5)); // Body
        snake.add(new Point(UNIT_SIZE * 3, UNIT_SIZE * 5)); // Tail

        direction = 'R';
        score = 0;
        spawnFood();
        running = true;
        timer = new Timer(100, this);
        timer.start();
    }

    private void spawnFood() {
        Random rand = new Random();
        Point newFood;

        do {
            int x = rand.nextInt(WIDTH / UNIT_SIZE) * UNIT_SIZE;
            int y = rand.nextInt(HEIGHT / UNIT_SIZE) * UNIT_SIZE;
            newFood = new Point(x, y);
        } while (snake.contains(newFood)); // Avoid food spawning on snake

        food = newFood;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Optional grid - uncomment if needed
        /*
         * g.setColor(Color.darkGray);
         * for (int i = 0; i < WIDTH / UNIT_SIZE; i++) {
         * g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, HEIGHT);
         * g.drawLine(0, i * UNIT_SIZE, WIDTH, i * UNIT_SIZE);
         * }
         */

        // Draw food
        g.setColor(Color.red);
        g.fillOval(food.x, food.y, UNIT_SIZE, UNIT_SIZE);

        // Draw snake
        for (int i = 0; i < snake.size(); i++) {
            if (i == 0) {
                g.setColor(Color.green);
            } else {
                g.setColor(new Color(45, 180, 0));
            }
            Point p = snake.get(i);
            g.fillRect(p.x, p.y, UNIT_SIZE, UNIT_SIZE);
        }

        // Draw score
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score, 10, 25);

        // Game over screen
        if (!running) {
            g.setColor(Color.red);
            g.setFont(new Font("Arial", Font.BOLD, 48));
            g.drawString("Game Over", WIDTH / 2 - 140, HEIGHT / 2 - 20);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Press SPACE to restart", WIDTH / 2 - 110, HEIGHT / 2 + 20);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkFood();
            checkCollision();
        }
        repaint();
    }

    private void move() {
        Point head = new Point(snake.get(0));

        switch (direction) {
            case 'U':
                head.y -= UNIT_SIZE;
                break;
            case 'D':
                head.y += UNIT_SIZE;
                break;
            case 'L':
                head.x -= UNIT_SIZE;
                break;
            case 'R':
                head.x += UNIT_SIZE;
                break;
        }

        snake.add(0, head);
        snake.remove(snake.size() - 1);
    }

    private void checkFood() {
        if (snake.get(0).equals(food)) {
            // Grow snake by duplicating tail
            snake.add(new Point(snake.get(snake.size() - 1)));
            score++;
            spawnFood();
        }
    }

    private void checkCollision() {
        Point head = snake.get(0);

        // Check wall collision
        if (head.x < 0 || head.x >= WIDTH || head.y < 0 || head.y >= HEIGHT) {
            running = false;
            timer.stop();
        }

        // Check self collision only if snake size > 4
        if (snake.size() > 4) {
            for (int i = 1; i < snake.size(); i++) {
                if (head.equals(snake.get(i))) {
                    running = false;
                    timer.stop();
                    break;
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_SPACE && !running) {
            startGame();
        }

        // Prevent reversing directly
        switch (code) {
            case KeyEvent.VK_UP:
                if (direction != 'D')
                    direction = 'U';
                break;
            case KeyEvent.VK_DOWN:
                if (direction != 'U')
                    direction = 'D';
                break;
            case KeyEvent.VK_LEFT:
                if (direction != 'R')
                    direction = 'L';
                break;
            case KeyEvent.VK_RIGHT:
                if (direction != 'L')
                    direction = 'R';
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public static void main(String[] args) {
        new SnakeGame();
    }
}
