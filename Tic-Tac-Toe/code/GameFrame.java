//This class creates the graphical user interface using Java swing.
import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private Game game;
    private JButton[][] buttons;
    private JLabel statuslabel;

    public GameFrame() {
        game = new Game();
        buttons = new JButton[3][3];

        setTitle("Tic-Tac-Toe");
        setSize(400, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        statuslabel = new JLabel("Your turn (X)", SwingConstants.CENTER);
        statuslabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(statuslabel, BorderLayout.NORTH);
        JPanel boardPane1 = new JPanel(new GridLayout(3, 3, 5, 5));
        boardPane1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final int row = i;
                final int col = j;
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 40));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(e -> {
                    playMove(row, col);
                });
                boardPane1.add(buttons[i][j]);
            }
        }
        add(boardPane1, BorderLayout.CENTER);
        JButton resetButton = new JButton("New game");
        resetButton.setFont(new Font("Arial", Font.BOLD, 16));
        resetButton.addActionListener(e -> resetGame());

        JPanel bottomPane1 = new JPanel();
        bottomPane1.add(resetButton);
        add(bottomPane1, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void playMove(int row, int col) {
        if (game.isGameOver() || game.getBoard().getCell(row, col) != ' ') {
            return;
        }
        String result = game.playHumanMove(row, col);
        updateBoard();
        statuslabel.setText(result);

        if (game.isGameOver()) {
            JOptionPane.showMessageDialog(this, result);
        }
    }

    private void updateBoard() {
        Board board = game.getBoard();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char symbol = board.getCell(i, j);
                buttons[i][j].setText(symbol == ' ' ? "" : String.valueOf(symbol));
                buttons[i][j].setEnabled(symbol == ' ' && !game.isGameOver());
            }
        }
    }

    private void resetGame() {
        game.newGame();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
            }
        }
        statuslabel.setText("Your turn (X)");
    }
}
