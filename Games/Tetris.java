import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Tetris extends JPanel implements ActionListener, KeyListener {

    private final int ROWS = 20;
    private final int COLS = 10;
    private final int BLOCK_SIZE = 30;

    private Timer timer;
    private Color[][] grid = new Color[ROWS][COLS];

    private Tetromino currentPiece;
    private int currentRow, currentCol;

    private boolean gameOver = false;

    private static final Color[] COLORS = {
            Color.cyan, Color.blue, Color.orange, Color.yellow,
            Color.green, Color.magenta, Color.red
    };

    public Tetris() {
        JFrame frame = new JFrame("Tetris - Java Classic");
        frame.setSize(COLS * BLOCK_SIZE + 16, ROWS * BLOCK_SIZE + 39);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        setBackground(Color.black);
        setFocusable(true);
        addKeyListener(this);

        timer = new Timer(400, this);
        timer.start();

        spawnNewPiece();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw grid blocks
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] != null) {
                    drawBlock(g, c * BLOCK_SIZE, r * BLOCK_SIZE, grid[r][c]);
                }
            }
        }

        // Draw current falling piece
        if (currentPiece != null) {
            for (Point p : currentPiece.getPoints()) {
                int x = (currentCol + p.x) * BLOCK_SIZE;
                int y = (currentRow + p.y) * BLOCK_SIZE;
                drawBlock(g, x, y, currentPiece.color);
            }
        }

        if (gameOver) {
            g.setColor(Color.white);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("Game Over", 40, getHeight() / 2);
        }
    }

    private void drawBlock(Graphics g, int x, int y, Color color) {
        g.setColor(color);
        g.fillRect(x, y, BLOCK_SIZE, BLOCK_SIZE);
        g.setColor(color.brighter());
        g.drawLine(x, y + BLOCK_SIZE - 1, x, y);
        g.drawLine(x, y, x + BLOCK_SIZE - 1, y);
        g.setColor(color.darker());
        g.drawLine(x + 1, y + BLOCK_SIZE - 1, x + BLOCK_SIZE - 1, y + BLOCK_SIZE - 1);
        g.drawLine(x + BLOCK_SIZE - 1, y + BLOCK_SIZE - 1, x + BLOCK_SIZE - 1, y + 1);
    }

    private void spawnNewPiece() {
        currentPiece = Tetromino.randomTetromino();
        currentRow = 0;
        currentCol = COLS / 2 - 2;

        if (!canMove(currentPiece, currentRow, currentCol)) {
            gameOver = true;
            timer.stop();
        }
    }

    private boolean canMove(Tetromino piece, int row, int col) {
        for (Point p : piece.getPoints()) {
            int x = col + p.x;
            int y = row + p.y;

            if (x < 0 || x >= COLS || y < 0 || y >= ROWS)
                return false;
            if (grid[y][x] != null)
                return false;
        }
        return true;
    }

    private void fixToGrid() {
        for (Point p : currentPiece.getPoints()) {
            int x = currentCol + p.x;
            int y = currentRow + p.y;
            grid[y][x] = currentPiece.color;
        }
    }

    private void clearLines() {
        for (int r = ROWS - 1; r >= 0; r--) {
            boolean full = true;
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == null) {
                    full = false;
                    break;
                }
            }
            if (full) {
                for (int row = r; row > 0; row--) {
                    System.arraycopy(grid[row - 1], 0, grid[row], 0, COLS);
                }
                for (int c = 0; c < COLS; c++) {
                    grid[0][c] = null;
                }
                r++; // Check this row again after shifting down
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOver)
            return;

        if (canMove(currentPiece, currentRow + 1, currentCol)) {
            currentRow++;
        } else {
            fixToGrid();
            clearLines();
            spawnNewPiece();
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (gameOver)
            return;

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_LEFT) {
            if (canMove(currentPiece, currentRow, currentCol - 1)) {
                currentCol--;
            }
        } else if (code == KeyEvent.VK_RIGHT) {
            if (canMove(currentPiece, currentRow, currentCol + 1)) {
                currentCol++;
            }
        } else if (code == KeyEvent.VK_DOWN) {
            if (canMove(currentPiece, currentRow + 1, currentCol)) {
                currentRow++;
            }
        } else if (code == KeyEvent.VK_UP) {
            Tetromino rotated = currentPiece.rotate();
            if (canMove(rotated, currentRow, currentCol)) {
                currentPiece = rotated;
            }
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not needed
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not needed
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Tetris::new);
    }

    private static class Tetromino {
        private Point[] points;
        private Color color;

        private Tetromino(Point[] points, Color color) {
            this.points = points;
            this.color = color;
        }

        public Point[] getPoints() {
            return points;
        }

        public Tetromino rotate() {
            Point[] rotated = new Point[points.length];
            for (int i = 0; i < points.length; i++) {
                rotated[i] = new Point(-points[i].y, points[i].x);
            }
            return new Tetromino(rotated, color);
        }

        public static Tetromino randomTetromino() {
            Random rand = new Random();
            int shape = rand.nextInt(7);
            switch (shape) {
                case 0: // I
                    return new Tetromino(
                            new Point[] { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1) },
                            Color.cyan);
                case 1: // J
                    return new Tetromino(
                            new Point[] { new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1) },
                            Color.blue);
                case 2: // L
                    return new Tetromino(
                            new Point[] { new Point(2, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1) },
                            Color.orange);
                case 3: // O
                    return new Tetromino(
                            new Point[] { new Point(0, 0), new Point(1, 0), new Point(0, 1), new Point(1, 1) },
                            Color.yellow);
                case 4: // S
                    return new Tetromino(
                            new Point[] { new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
                            Color.green);
                case 5: // T
                    return new Tetromino(
                            new Point[] { new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1) },
                            Color.magenta);
                case 6: // Z
                    return new Tetromino(
                            new Point[] { new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
                            Color.red);
                default:
                    throw new IllegalStateException("Unexpected shape: " + shape);
            }
        }
    }
}
