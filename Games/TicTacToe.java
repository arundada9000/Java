import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JFrame implements ActionListener {

    private JButton[] buttons = new JButton[9];
    private char currentPlayer = 'X';
    private boolean gameActive = true;
    private JLabel statusLabel;

    public TicTacToe() {
        setTitle("Tic-Tac-Toe");
        setSize(400, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        Font font = new Font("Arial", Font.BOLD, 60);

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(font);
            buttons[i].addActionListener(this);
            boardPanel.add(buttons[i]);
        }

        statusLabel = new JLabel("Player X's turn");
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(e -> resetGame());

        add(statusLabel, BorderLayout.NORTH);
        add(boardPanel, BorderLayout.CENTER);
        add(restartButton, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameActive)
            return;

        JButton clicked = (JButton) e.getSource();

        if (!clicked.getText().equals(""))
            return; // Ignore if already marked

        clicked.setText(String.valueOf(currentPlayer));
        if (checkWin()) {
            statusLabel.setText("Player " + currentPlayer + " wins!");
            gameActive = false;
        } else if (isBoardFull()) {
            statusLabel.setText("Draw!");
            gameActive = false;
        } else {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            statusLabel.setText("Player " + currentPlayer + "'s turn");
        }
    }

    private boolean checkWin() {
        int[][] combos = {
                { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, // rows
                { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 }, // cols
                { 0, 4, 8 }, { 2, 4, 6 } // diagonals
        };

        for (int[] c : combos) {
            if (buttons[c[0]].getText().equals(String.valueOf(currentPlayer)) &&
                    buttons[c[1]].getText().equals(String.valueOf(currentPlayer)) &&
                    buttons[c[2]].getText().equals(String.valueOf(currentPlayer))) {
                return true;
            }
        }
        return false;
    }

    private boolean isBoardFull() {
        for (JButton b : buttons) {
            if (b.getText().equals(""))
                return false;
        }
        return true;
    }

    private void resetGame() {
        for (JButton b : buttons) {
            b.setText("");
        }
        currentPlayer = 'X';
        gameActive = true;
        statusLabel.setText("Player X's turn");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TicTacToe game = new TicTacToe();
            game.setVisible(true);
        });
    }
}
