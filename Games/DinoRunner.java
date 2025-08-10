import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class DinoRunner extends JPanel implements ActionListener, KeyListener {

    private final int WIDTH = 800, HEIGHT = 400;
    private final int GROUND_LEVEL = 300;
    private final int DINO_SIZE = 40;

    private int dinoY = GROUND_LEVEL;
    private int dinoVelocityY = 0;
    private final int GRAVITY = 1;
    private boolean jumping = false;

    private ArrayList<Rectangle> cacti;
    private Timer timer;
    private int score = 0;
    private boolean running = false;

    private Random rand;

    public DinoRunner() {
        JFrame frame = new JFrame("Chrome Dino Runner");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        this.setBackground(Color.white);
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(this);

        rand = new Random();
        cacti = new ArrayList<>();
        startGame();
    }

    private void startGame() {
        cacti.clear();
        score = 0;
        dinoY = GROUND_LEVEL;
        dinoVelocityY = 0;
        jumping = false;
        running = true;

        // Add initial cactus
        addCactus();

        timer = new Timer(20, this);
        timer.start();
    }

    private void addCactus() {
        int width = 20 + rand.nextInt(15);
        int height = 40 + rand.nextInt(20);
        Rectangle cactus = new Rectangle(WIDTH, GROUND_LEVEL + (DINO_SIZE - height), width, height);
        cacti.add(cactus);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw ground
        g.setColor(Color.gray);
        g.fillRect(0, GROUND_LEVEL + DINO_SIZE, WIDTH, HEIGHT - GROUND_LEVEL - DINO_SIZE);

        // Draw Dino (simple rectangle)
        g.setColor(Color.black);
        g.fillRect(50, dinoY, DINO_SIZE, DINO_SIZE);

        // Draw cacti
        g.setColor(Color.green.darker());
        for (Rectangle cactus : cacti) {
            g.fillRect(cactus.x, cactus.y, cactus.width, cactus.height);
        }

        // Draw score
        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("Score: " + score, WIDTH - 150, 50);

        // Game Over message
        if (!running) {
            g.setFont(new Font("Arial", Font.BOLD, 48));
            g.drawString("Game Over", WIDTH / 2 - 140, HEIGHT / 2 - 20);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Press SPACE to restart", WIDTH / 2 - 110, HEIGHT / 2 + 20);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            // Dino physics
            if (jumping) {
                dinoVelocityY += GRAVITY;
                dinoY += dinoVelocityY;
                if (dinoY >= GROUND_LEVEL) {
                    dinoY = GROUND_LEVEL;
                    dinoVelocityY = 0;
                    jumping = false;
                }
            }

            // Move cacti left
            for (int i = 0; i < cacti.size(); i++) {
                Rectangle c = cacti.get(i);
                c.x -= 8;
            }

            // Remove off-screen cacti
            if (!cacti.isEmpty() && cacti.get(0).x + cacti.get(0).width < 0) {
                cacti.remove(0);
                score++;
            }

            // Add new cactus randomly
            if (cacti.isEmpty() || cacti.get(cacti.size() - 1).x < WIDTH - 200 - rand.nextInt(200)) {
                addCactus();
            }

            // Collision detection
            Rectangle dinoRect = new Rectangle(50, dinoY, DINO_SIZE, DINO_SIZE);
            for (Rectangle cactus : cacti) {
                if (dinoRect.intersects(cactus)) {
                    running = false;
                    timer.stop();
                    break;
                }
            }
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_SPACE && !running) {
            startGame();
        } else if ((code == KeyEvent.VK_SPACE || code == KeyEvent.VK_UP) && !jumping && running) {
            jumping = true;
            dinoVelocityY = -15;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public static void main(String[] args) {
        new DinoRunner();
    }
}
