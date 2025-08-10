import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PongGame extends JPanel implements ActionListener, KeyListener {

    private final int WIDTH = 700, HEIGHT = 500;
    private final int PADDLE_WIDTH = 15, PADDLE_HEIGHT = 100;
    private final int BALL_SIZE = 20;

    private int leftPaddleY = HEIGHT / 2 - PADDLE_HEIGHT / 2;
    private int rightPaddleY = HEIGHT / 2 - PADDLE_HEIGHT / 2;

    private int ballX = WIDTH / 2 - BALL_SIZE / 2;
    private int ballY = HEIGHT / 2 - BALL_SIZE / 2;
    private int ballXVel = 5;
    private int ballYVel = 3;

    private int leftScore = 0;
    private int rightScore = 0;

    private boolean upPressedLeft = false;
    private boolean downPressedLeft = false;
    private boolean upPressedRight = false;
    private boolean downPressedRight = false;

    private Timer timer;
    private boolean running = true;

    public PongGame() {
        JFrame frame = new JFrame("Pong Game - Java Classic");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        this.setBackground(Color.black);
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(this);

        timer = new Timer(15, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Background
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // Middle line
        g.setColor(Color.white);
        for (int i = 0; i < HEIGHT; i += 30) {
            g.fillRect(WIDTH / 2 - 2, i, 4, 20);
        }

        // Paddles
        g.fillRect(10, leftPaddleY, PADDLE_WIDTH, PADDLE_HEIGHT);
        g.fillRect(WIDTH - 10 - PADDLE_WIDTH, rightPaddleY, PADDLE_WIDTH, PADDLE_HEIGHT);

        // Ball
        g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);

        // Scores
        g.setFont(new Font("Arial", Font.BOLD, 36));
        g.drawString(String.valueOf(leftScore), WIDTH / 4, 50);
        g.drawString(String.valueOf(rightScore), WIDTH * 3 / 4, 50);

        // Game over message
        if (!running) {
            g.setFont(new Font("Arial", Font.BOLD, 48));
            String winner = leftScore > rightScore ? "Left Player Wins!" : "Right Player Wins!";
            g.drawString("Game Over", WIDTH / 2 - 140, HEIGHT / 2 - 20);
            g.drawString(winner, WIDTH / 2 - 200, HEIGHT / 2 + 40);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Press SPACE to restart", WIDTH / 2 - 110, HEIGHT / 2 + 80);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            movePaddles();
            moveBall();
            checkCollisions();
        }
        repaint();
    }

    private void movePaddles() {
        if (upPressedLeft && leftPaddleY > 0)
            leftPaddleY -= 7;
        if (downPressedLeft && leftPaddleY + PADDLE_HEIGHT < HEIGHT)
            leftPaddleY += 7;
        if (upPressedRight && rightPaddleY > 0)
            rightPaddleY -= 7;
        if (downPressedRight && rightPaddleY + PADDLE_HEIGHT < HEIGHT)
            rightPaddleY += 7;
    }

    private void moveBall() {
        ballX += ballXVel;
        ballY += ballYVel;

        // Bounce top and bottom
        if (ballY <= 0 || ballY + BALL_SIZE >= HEIGHT) {
            ballYVel = -ballYVel;
        }
    }

    private void checkCollisions() {
        // Left paddle collision
        if (ballX <= 10 + PADDLE_WIDTH && ballY + BALL_SIZE >= leftPaddleY && ballY <= leftPaddleY + PADDLE_HEIGHT) {
            ballXVel = -ballXVel;
            ballX = 10 + PADDLE_WIDTH; // prevent sticking
        }

        // Right paddle collision
        if (ballX + BALL_SIZE >= WIDTH - 10 - PADDLE_WIDTH && ballY + BALL_SIZE >= rightPaddleY
                && ballY <= rightPaddleY + PADDLE_HEIGHT) {
            ballXVel = -ballXVel;
            ballX = WIDTH - 10 - PADDLE_WIDTH - BALL_SIZE; // prevent sticking
        }

        // Left side goal
        if (ballX < 0) {
            rightScore++;
            resetBall();
        }

        // Right side goal
        if (ballX > WIDTH - BALL_SIZE) {
            leftScore++;
            resetBall();
        }

        if (leftScore >= 10 || rightScore >= 10) {
            running = false;
            timer.stop();
        }
    }

    private void resetBall() {
        ballX = WIDTH / 2 - BALL_SIZE / 2;
        ballY = HEIGHT / 2 - BALL_SIZE / 2;
        ballXVel = (ballXVel > 0) ? -5 : 5; // change direction
        ballYVel = 3;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (!running && code == KeyEvent.VK_SPACE) {
            leftScore = 0;
            rightScore = 0;
            running = true;
            timer.start();
            resetBall();
        }

        switch (code) {
            case KeyEvent.VK_W:
                upPressedLeft = true;
                break;
            case KeyEvent.VK_S:
                downPressedLeft = true;
                break;
            case KeyEvent.VK_UP:
                upPressedRight = true;
                break;
            case KeyEvent.VK_DOWN:
                downPressedRight = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        switch (code) {
            case KeyEvent.VK_W:
                upPressedLeft = false;
                break;
            case KeyEvent.VK_S:
                downPressedLeft = false;
                break;
            case KeyEvent.VK_UP:
                upPressedRight = false;
                break;
            case KeyEvent.VK_DOWN:
                downPressedRight = false;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public static void main(String[] args) {
        new PongGame();
    }
}
