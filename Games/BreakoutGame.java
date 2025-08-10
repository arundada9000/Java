import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BreakoutGame extends JPanel implements KeyListener, ActionListener {

    private final int WIDTH = 700, HEIGHT = 600;
    private final int PADDLE_WIDTH = 100, PADDLE_HEIGHT = 15;
    private final int BALL_SIZE = 20;

    private int paddleX = WIDTH / 2 - PADDLE_WIDTH / 2;
    private final int paddleY = HEIGHT - 50;

    private int ballX = WIDTH / 2;
    private int ballY = HEIGHT - 70;
    private int ballXDir = -3;
    private int ballYDir = -4;

    private Timer timer;
    private boolean running = false;

    private int score = 0;
    private int lives = 3;

    private final int ROWS = 5;
    private final int COLS = 10;
    private Brick[][] bricks;

    // Declare these ONCE here
    private boolean leftPressed = false;
    private boolean rightPressed = false;

    public BreakoutGame() {
        JFrame frame = new JFrame("Breakout Game - Java Classic");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        setFocusable(true);
        addKeyListener(this);
        setBackground(Color.black);

        initBricks();
        startGame();
    }

    // Focus fix to ensure keyboard input works
    @Override
    public void addNotify() {
        super.addNotify();
        requestFocusInWindow();
    }

    private void initBricks() {
        bricks = new Brick[ROWS][COLS];
        int brickWidth = WIDTH / COLS;
        int brickHeight = 30;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                bricks[r][c] = new Brick(c * brickWidth, r * brickHeight + 50, brickWidth - 2, brickHeight - 2);
            }
        }
    }

    private void startGame() {
        ballX = WIDTH / 2;
        ballY = HEIGHT - 70;
        ballXDir = -3;
        ballYDir = -4;
        paddleX = WIDTH / 2 - PADDLE_WIDTH / 2;
        score = 0;
        lives = 3;
        running = true;
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Paddle
        g.setColor(Color.green);
        g.fillRect(paddleX, paddleY, PADDLE_WIDTH, PADDLE_HEIGHT);

        // Ball
        g.setColor(Color.yellow);
        g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);

        // Bricks
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (!bricks[r][c].destroyed) {
                    bricks[r][c].draw(g);
                }
            }
        }

        // Score and lives
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score, 10, 30);
        g.drawString("Lives: " + lives, WIDTH - 100, 30);

        // Game over
        if (!running) {
            g.setColor(Color.red);
            g.setFont(new Font("Arial", Font.BOLD, 48));
            g.drawString("Game Over", WIDTH / 2 - 140, HEIGHT / 2 - 20);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Press SPACE to restart", WIDTH / 2 - 110, HEIGHT / 2 + 20);
        }

        // Level cleared
        if (allBricksDestroyed()) {
            g.setColor(Color.green);
            g.setFont(new Font("Arial", Font.BOLD, 48));
            g.drawString("You Win!", WIDTH / 2 - 120, HEIGHT / 2 - 20);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Press SPACE to restart", WIDTH / 2 - 110, HEIGHT / 2 + 20);
            running = false;
            timer.stop();
        }
    }

    private boolean allBricksDestroyed() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (!bricks[r][c].destroyed)
                    return false;
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            moveBall();
            movePaddle();
            checkCollisions();
        }
        repaint();
    }

    private void moveBall() {
        ballX += ballXDir;
        ballY += ballYDir;

        if (ballX < 0)
            ballXDir = -ballXDir;
        if (ballX > WIDTH - BALL_SIZE)
            ballXDir = -ballXDir;
        if (ballY < 0)
            ballYDir = -ballYDir;

        if (ballY > HEIGHT) {
            lives--;
            if (lives <= 0) {
                running = false;
                timer.stop();
            } else {
                resetBallAndPaddle();
            }
        }
    }

    private void resetBallAndPaddle() {
        ballX = WIDTH / 2;
        ballY = HEIGHT - 70;
        ballXDir = -3;
        ballYDir = -4;
        paddleX = WIDTH / 2 - PADDLE_WIDTH / 2;
    }

    private void checkCollisions() {
        Rectangle paddleRect = new Rectangle(paddleX, paddleY, PADDLE_WIDTH, PADDLE_HEIGHT);
        Rectangle ballRect = new Rectangle(ballX, ballY, BALL_SIZE, BALL_SIZE);
        if (ballRect.intersects(paddleRect)) {
            ballYDir = -ballYDir;
            ballY = paddleY - BALL_SIZE;
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                Brick brick = bricks[r][c];
                if (!brick.destroyed) {
                    Rectangle brickRect = new Rectangle(brick.x, brick.y, brick.width, brick.height);
                    if (ballRect.intersects(brickRect)) {
                        bricks[r][c].destroyed = true;
                        score += 10;
                        ballYDir = -ballYDir;
                        return;
                    }
                }
            }
        }
    }

    private void movePaddle() {
        if (leftPressed && paddleX > 0) {
            paddleX -= 7;
        }
        if (rightPressed && paddleX < WIDTH - PADDLE_WIDTH) {
            paddleX += 7;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (!running && code == KeyEvent.VK_SPACE) {
            initBricks();
            startGame();
        }

        switch (code) {
            case KeyEvent.VK_LEFT:
                leftPressed = true;
                break;
            case KeyEvent.VK_RIGHT:
                rightPressed = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        switch (code) {
            case KeyEvent.VK_LEFT:
                leftPressed = false;
                break;
            case KeyEvent.VK_RIGHT:
                rightPressed = false;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public static void main(String[] args) {
        new BreakoutGame();
    }

    // Inner class for bricks
    class Brick {
        int x, y, width, height;
        boolean destroyed = false;

        Brick(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        void draw(Graphics g) {
            g.setColor(Color.orange);
            g.fillRect(x, y, width, height);
            g.setColor(Color.black);
            g.drawRect(x, y, width, height);
        }
    }
}
