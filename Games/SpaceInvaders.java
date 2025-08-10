import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

public class SpaceInvaders extends JPanel implements ActionListener, KeyListener {

    private final int WIDTH = 600, HEIGHT = 600;
    private final int PLAYER_WIDTH = 50, PLAYER_HEIGHT = 20;
    private final int ENEMY_WIDTH = 40, ENEMY_HEIGHT = 20;

    private int playerX = WIDTH / 2 - PLAYER_WIDTH / 2;
    private boolean leftPressed = false, rightPressed = false, spacePressed = false;

    private Timer timer;
    private ArrayList<Bullet> bullets = new ArrayList<>();
    private ArrayList<Enemy> enemies = new ArrayList<>();

    private boolean gameOver = false;
    private boolean gameWon = false;

    public SpaceInvaders() {
        JFrame frame = new JFrame("Space Invaders - Java Classic");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        setFocusable(true);
        addKeyListener(this);

        initEnemies();

        timer = new Timer(15, this);
        timer.start();
    }

    private void initEnemies() {
        enemies.clear();
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 8; col++) {
                int x = 60 + col * (ENEMY_WIDTH + 10);
                int y = 40 + row * (ENEMY_HEIGHT + 20);
                enemies.add(new Enemy(x, y));
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // Player
        g.setColor(Color.green);
        g.fillRect(playerX, HEIGHT - 60, PLAYER_WIDTH, PLAYER_HEIGHT);

        // Bullets
        g.setColor(Color.white);
        for (Bullet bullet : bullets) {
            g.fillRect(bullet.x, bullet.y, 4, 10);
        }

        // Enemies
        g.setColor(Color.red);
        for (Enemy enemy : enemies) {
            g.fillRect(enemy.x, enemy.y, ENEMY_WIDTH, ENEMY_HEIGHT);
        }

        // Game over / Win
        if (gameOver || gameWon) {
            g.setColor(Color.white);
            g.setFont(new Font("Arial", Font.BOLD, 28));
            String msg = gameOver ? "Game Over!" : "You Win!";
            g.drawString(msg + " Press R to Restart", 100, HEIGHT / 2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOver || gameWon)
            return;

        // Move player
        if (leftPressed && playerX > 0)
            playerX -= 5;
        if (rightPressed && playerX + PLAYER_WIDTH < WIDTH)
            playerX += 5;

        // Fire bullet
        if (spacePressed && bullets.size() < 3) {
            bullets.add(new Bullet(playerX + PLAYER_WIDTH / 2, HEIGHT - 60));
            spacePressed = false;
        }

        // Move bullets
        Iterator<Bullet> it = bullets.iterator();
        while (it.hasNext()) {
            Bullet bullet = it.next();
            bullet.y -= 8;
            if (bullet.y < 0)
                it.remove();
        }

        // Move enemies
        for (Enemy enemy : enemies) {
            enemy.x += enemy.dx;
        }

        // Change direction if enemy hits wall
        for (Enemy enemy : enemies) {
            if (enemy.x <= 0 || enemy.x + ENEMY_WIDTH >= WIDTH) {
                for (Enemy en : enemies) {
                    en.y += 20;
                    en.dx *= -1;
                }
                break;
            }
        }

        // Check bullet collision
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            for (int j = 0; j < enemies.size(); j++) {
                Enemy enemy = enemies.get(j);
                Rectangle r1 = new Rectangle(bullet.x, bullet.y, 4, 10);
                Rectangle r2 = new Rectangle(enemy.x, enemy.y, ENEMY_WIDTH, ENEMY_HEIGHT);
                if (r1.intersects(r2)) {
                    bullets.remove(i--);
                    enemies.remove(j--);
                    break;
                }
            }
        }

        // Check lose
        for (Enemy enemy : enemies) {
            if (enemy.y + ENEMY_HEIGHT >= HEIGHT - 60) {
                gameOver = true;
                timer.stop();
                break;
            }
        }

        // Check win
        if (enemies.isEmpty()) {
            gameWon = true;
            timer.stop();
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (gameOver || gameWon) {
            if (e.getKeyCode() == KeyEvent.VK_R) {
                resetGame();
                return;
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            leftPressed = true;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            rightPressed = true;
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
            spacePressed = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            leftPressed = false;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            rightPressed = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    private void resetGame() {
        playerX = WIDTH / 2 - PLAYER_WIDTH / 2;
        bullets.clear();
        initEnemies();
        gameOver = false;
        gameWon = false;
        timer.start();
    }

    private static class Bullet {
        int x, y;

        public Bullet(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Enemy {
        int x, y;
        int dx = 2;

        public Enemy(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SpaceInvaders::new);
    }
}
