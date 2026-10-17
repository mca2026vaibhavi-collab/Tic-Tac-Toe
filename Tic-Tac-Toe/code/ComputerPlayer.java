//Another player is computer, chooses random empty cell on the board.
import java.util.Random;

public class ComputerPlayer extends Player {
    private Random random = new Random();

    public ComputerPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public String getPlayerType() {
        return "Computer";
    }

    public int[] makeMove(Board board) {
        int[][] emptyCells = board.getEmptyCells();
        if (emptyCells.length == 0) {
            return null;
        }

        return emptyCells[random.nextInt(emptyCells.length)];
    }
}
