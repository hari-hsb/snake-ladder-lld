import CompletionStrategy.WINNING_TYPE;
import Model.Board;
import Model.Game;

public class SnakeLadder {
    public static void main(String[] args) throws InterruptedException {
        Board board=new Board(10,10,5);
        board.printBoard();
        Game game=new Game(board,2,1, WINNING_TYPE.LAST_REMAINING_LOOSE);
        game.startGame();
    }
}
