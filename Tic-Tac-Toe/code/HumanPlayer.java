//HumanPlayer class inherits from Parent class
public class HumanPlayer extends Player {
    public HumanPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public String getPlayerType() {
        return "Human";
    }
}
