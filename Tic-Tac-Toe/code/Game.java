//A class to control the game logic, player turns and results.
public class Game {
    private Board board;
    private Player human;
    private ComputerPlayer computer;
    private boolean gameOver;

    public Game() {
        board = new Board();
        human = new HumanPlayer("You", 'X');
        computer = new ComputerPlayer("Computer", 'O');
        gameOver = false;
    }

    public Board getBoard() {
        return board;
    }

    public Player getHuman() {
        return human;
    }

    public ComputerPlayer getComputer() {
        return computer;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public String playHumanMove(int row, int col) {
        if (gameOver) {
            return "The game is already over!";
        }

        if (!board.makeMove(row, col, human.getSymbol())) {
            return "Please perform a valid move.";
        }

        if (board.hasWinner(human.getSymbol())) {
            gameOver = true;
            return "Congratulations! You have won the game!";
        }

        if (board.isFull()) {
            gameOver = true;
            return "It's a draw!";
        }

        int[] move = computer.makeMove(board);

        if (move != null) {
            board.makeMove(
                    move[0],
                    move[1],
                    computer.getSymbol());
        }

        if (board.hasWinner(computer.getSymbol())) {
            gameOver = true;
            return "Computer wins! Better luck next time.";
        }

        if (board.isFull()) {
            gameOver = true;
            return "It's a draw!";
        }

        return "Your turn (X)";
    }

    public void newGame() {
        board.reset();
        gameOver = false;
    }
}
