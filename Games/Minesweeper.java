import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Minesweeper extends JFrame {

    private final int ROWS = 10;
    private final int COLS = 10;
    private final int MINES = 10;

    private Cell[][] cells = new Cell[ROWS][COLS];
    private boolean gameOver = false;
    private int cellsRevealed = 0;

    public Minesweeper() {
        setTitle("Minesweeper");
        setSize(500, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel board = new JPanel(new GridLayout(ROWS, COLS));
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                cells[r][c] = new Cell(r, c);
                board.add(cells[r][c]);
            }
        }

        add(board, BorderLayout.CENTER);

        placeMines();
        calculateNumbers();

        JButton reset = new JButton("Restart");
        reset.addActionListener(e -> resetGame());
        add(reset, BorderLayout.SOUTH);
    }

    private void placeMines() {
        Random rand = new Random();
        int placed = 0;
        while (placed < MINES) {
            int r = rand.nextInt(ROWS);
            int c = rand.nextInt(COLS);
            if (!cells[r][c].hasMine) {
                cells[r][c].hasMine = true;
                placed++;
            }
        }
    }

    private void calculateNumbers() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (!cells[r][c].hasMine) {
                    int count = 0;
                    for (int dr = -1; dr <= 1; dr++) {
                        for (int dc = -1; dc <= 1; dc++) {
                            int nr = r + dr, nc = c + dc;
                            if (nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS) {
                                if (cells[nr][nc].hasMine)
                                    count++;
                            }
                        }
                    }
                    cells[r][c].adjacentMines = count;
                }
            }
        }
    }

    private void revealCell(int r, int c) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS)
            return;
        Cell cell = cells[r][c];
        if (cell.isRevealed || cell.isFlagged)
            return;

        cell.reveal();
        cellsRevealed++;

        if (cell.hasMine) {
            gameOver();
            return;
        }

        if (cell.adjacentMines == 0) {
            // Reveal neighbors recursively
            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {
                    if (dr != 0 || dc != 0) {
                        revealCell(r + dr, c + dc);
                    }
                }
            }
        }

        if (cellsRevealed == ROWS * COLS - MINES) {
            winGame();
        }
    }

    private void gameOver() {
        gameOver = true;
        // Reveal all mines
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (cells[r][c].hasMine) {
                    cells[r][c].setText("💣");
                    cells[r][c].setBackground(Color.red);
                }
                cells[r][c].removeMouseListener(cells[r][c].mouseAdapter);
            }
        }
        JOptionPane.showMessageDialog(this, "Game Over! You hit a mine.", "Game Over", JOptionPane.ERROR_MESSAGE);
    }

    private void winGame() {
        gameOver = true;
        JOptionPane.showMessageDialog(this, "Congratulations! You cleared all mines.", "You Win",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void resetGame() {
        gameOver = false;
        cellsRevealed = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                cells[r][c].reset();
            }
        }
        placeMines();
        calculateNumbers();
    }

    private class Cell extends JButton {
        int row, col;
        boolean hasMine = false;
        int adjacentMines = 0;
        boolean isRevealed = false;
        boolean isFlagged = false;

        MouseAdapter mouseAdapter;

        public Cell(int r, int c) {
            row = r;
            col = c;
            setFont(new Font("Arial", Font.BOLD, 20));
            setMargin(new Insets(0, 0, 0, 0));
            mouseAdapter = new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (gameOver)
                        return;
                    if (SwingUtilities.isRightMouseButton(e)) {
                        toggleFlag();
                    } else if (SwingUtilities.isLeftMouseButton(e)) {
                        if (!isFlagged) {
                            revealCell(row, col);
                        }
                    }
                }
            };
            addMouseListener(mouseAdapter);
        }

        void reveal() {
            if (isRevealed)
                return;
            isRevealed = true;
            setEnabled(false);
            setBackground(Color.lightGray);
            if (hasMine) {
                setText("💣");
            } else if (adjacentMines > 0) {
                setText(String.valueOf(adjacentMines));
                setForeground(getColorForNumber(adjacentMines));
            }
        }

        void toggleFlag() {
            if (isRevealed)
                return;
            isFlagged = !isFlagged;
            setText(isFlagged ? "🚩" : "");
        }

        void reset() {
            hasMine = false;
            adjacentMines = 0;
            isRevealed = false;
            isFlagged = false;
            setText("");
            setEnabled(true);
            setBackground(null);
            addMouseListener(mouseAdapter);
        }

        private Color getColorForNumber(int number) {
            switch (number) {
                case 1:
                    return Color.blue;
                case 2:
                    return new Color(0, 128, 0); // dark green
                case 3:
                    return Color.red;
                case 4:
                    return new Color(0, 0, 128); // dark blue
                case 5:
                    return new Color(128, 0, 0); // dark red
                case 6:
                    return new Color(64, 224, 208); // turquoise
                case 7:
                    return Color.black;
                case 8:
                    return Color.gray;
                default:
                    return Color.black;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Minesweeper game = new Minesweeper();
            game.setVisible(true);
        });
    }
}
