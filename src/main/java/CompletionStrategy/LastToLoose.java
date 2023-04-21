package CompletionStrategy;

import Model.Board;
import Model.Player;

import java.util.List;

public class LastToLoose implements WinningStrategy{
    private Board board;
    private List<Player> playerList;

    public LastToLoose(Board board, List<Player> playerList) {
        this.board = board;
        this.playerList = playerList;
    }
    @Override
    public GameCompletionResponse gameComplete(Player currentPlayer) {
        int playerNotCompleted = 0;
        int loosingPlayer = 0;
        if(currentPlayer.getCurrentPosition()>= board.getEnd()) currentPlayer.setCompleted(true);
        for(Player player:playerList){
            if(!(player.getCurrentPosition()>=board.getEnd())){
                playerNotCompleted++;
                loosingPlayer=player.getId();
            }
        }
        if(playerNotCompleted==1){
            return new GameCompletionResponse(true,loosingPlayer+" player loose");
        }
        return new GameCompletionResponse(false,null);

    }
}
