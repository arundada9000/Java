import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class FlappyBird extends JPanel implements ActionListener, KeyListener {
    private final int WIDTH = 400, HEIGHT = 600;
    private final int BIRD_SIZE = 20, PIPE_WIDTH = 60, GAP = 150;
    private int birdY = HEIGHT / 2, birdVelocity = 0, gravity = 1, score = 0;
    private boolean gameOver = false;

    private ArrayList<Rectangle> pipes;
    private Timer timer;

    public FlappyBird() {
        JFrame frame = new JFrame("Flappy Bird - Java Edition");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addKeyListener(this);

        pipes = new ArrayList<>();
        timer = new Timer(20, this);
        addPipe(true);
        addPipe(true);
        addPipe(true);
        addPipe(true);

        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Background
        g.setColor(Color.cyan);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // Ground
        g.setColor(Color.orange);
        g.fillRect(0, HEIGHT - 100, WIDTH, 100);

        // Bird
        g.setColor(Color.red);
        g.fillOval(WIDTH / 2 - BIRD_SIZE / 2, birdY, BIRD_SIZE, BIRD_SIZE);

        // Pipes
        g.setColor(Color.green.darker());
        for (Rectangle pipe : pipes) {
            g.fillRect(pipe.x, pipe.y, pipe.width, pipe.height);
        }

        // Score
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 32));
        g.drawString("Score: " + score, 20, 40);

        if (gameOver) {
            g.setFont(new Font("Arial", Font.BOLD, 48));
            g.drawString("Game Over", WIDTH / 2 - 130, HEIGHT / 2 - 20);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Press SPACE to restart", WIDTH / 2 - 110, HEIGHT / 2 + 20);
        }
    }

    private void addPipe(boolean start) {
        int height = 50 + new Random().nextInt(250);
        if (start) {
            pipes.add(new Rectangle(WIDTH + pipes.size() * 200, 0, PIPE_WIDTH, height));
            pipes.add(new Rectangle(WIDTH + pipes.size() * 200 - PIPE_WIDTH, height + GAP, PIPE_WIDTH, HEIGHT - height - GAP - 100));
        } else {
            Rectangle lastPipe = pipes.get(pipes.size() - 1);
            pipes.add(new Rectangle(lastPipe.x + 200, 0, PIPE_WIDTH, height));
            pipes.add(new Rectangle(lastPipe.x + 200, height + GAP, PIPE_WIDTH, HEIGHT - height - GAP - 100));
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            birdVelocity += gravity;
            birdY += birdVelocity;

            // Pipe movement
            for (int i = 0; i < pipes.size(); i++) {
                Rectangle pipe = pipes.get(i);
                pipe.x -= 4;
            }

            // Add new pipes
            if (pipes.get(pipes.size() - 1).x < WIDTH - 200) {
                addPipe(false);
            }

            // Remove off-screen pipes
            if (pipes.get(0).x + PIPE_WIDTH < 0) {
                pipes.remove(0);
                pipes.remove(0);
                score++;
            }

            // Collision detection
            Rectangle bird = new Rectangle(WIDTH / 2 - BIRD_SIZE / 2, birdY, BIRD_SIZE, BIRD_SIZE);
            for (Rectangle pipe : pipes) {
                if (pipe.intersects(bird)) {
                    gameOver = true;
                    break;
                }
            }

            // Ground/ceiling collision
            if (birdY + BIRD_SIZE > HEIGHT - 100 || birdY < 0) {
                gameOver = true;
            }
        }

        repaint();
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (gameOver) {
                // Restart game
                birdY = HEIGHT / 2;
                birdVelocity = 0;
                score = 0;
                pipes.clear();
                addPipe(true); addPipe(true); addPipe(true); addPipe(true);
                gameOver = false;
            } else {
                birdVelocity = -10;
            }
        }
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        new FlappyBird();
    }
}
