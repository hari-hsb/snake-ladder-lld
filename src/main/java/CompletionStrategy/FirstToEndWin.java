package CompletionStrategy;

import Model.Board;
import Model.Player;

import java.util.List;

public class FirstToEndWin implements WinningStrategy{
    private Board board;
    private List<Player> playerList;

    public FirstToEndWin(Board board, List<Player> playerList) {
        this.board = board;
        this.playerList = playerList;
    }

    @Override
    public GameCompletionResponse gameComplete(Player currentPlayer) {
        if(currentPlayer.getCurrentPosition()>=board.getEnd()){
            return new GameCompletionResponse(true,currentPlayer.getId()+" wins!!!!!!!!!!!");
        }
        return new GameCompletionResponse(false,null);
    }
}
