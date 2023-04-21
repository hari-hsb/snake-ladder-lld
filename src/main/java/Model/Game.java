package Model;

import CompletionStrategy.*;
import Utils.Util;
import org.graalvm.collections.Pair;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Game {
    Board board;
    List<Player> players;
    Dice dice;
    WINNING_TYPE winningType;
    WinningStrategy winningStrategy;

    public Game(Board board, int noOfPlayers, int  noOfDice, WINNING_TYPE winningType) {
        this.board = board;
        this.dice=new Dice(noOfDice);
        this.players = createPlayers(noOfPlayers);
        this.dice = dice;
        if(winningType.equals(WINNING_TYPE.FIRST_TO_END_WIN)) winningStrategy=new FirstToEndWin(board,players);
        else winningStrategy=new LastToLoose(board,players);
        if(players.size()<2) winningStrategy=new FirstToEndWin(board,players);

    }

    private List<Player> createPlayers(int noOfPlayers) {
        if(noOfPlayers<1) throw new RuntimeException("No of Player should be greater than 1");
        List<Player> playersList=new ArrayList<>();
        while(noOfPlayers>0){
            playersList.add(new Player(noOfPlayers));
            noOfPlayers--;
        }
        return playersList;
    }

    public void startGame(){
        Deque<Player> playerDeque=new LinkedList<>();
        for(Player player:players){
            playerDeque.addFirst(player);
        }
        while(true){
            Player currentPlayer=playerDeque.getFirst();
            playerDeque.removeFirst();
            System.out.println(currentPlayer.toString());
            if(!currentPlayer.isCompleted){
                System.out.println("Player "+currentPlayer.getId()+" playing with Current position:"+currentPlayer.getCurrentPosition());
                int points=dice.rollDice();
                System.out.println("rollDice=====>>>"+ points);
                int currentPosition=currentPlayer.getCurrentPosition()+points;
                Pair<Integer,Integer> rowColumnList= Util.getRowColumnFromNumber(currentPosition,board.boardSize);
                currentPosition=positionAfterSnakeOrLadder(board.cells[rowColumnList.getLeft()][rowColumnList.getRight()],currentPosition);
                currentPlayer.setCurrentPosition(currentPosition);
                System.out.println("Player "+currentPlayer.getId()+" final Position:"+currentPosition);
                GameCompletionResponse gameCompletionResponse=winningStrategy.gameComplete(currentPlayer);
                if(gameCompletionResponse.isGameComplete()){
                    System.out.println(gameCompletionResponse.getMessage());
                    return;
                }
                playerDeque.addLast(currentPlayer);
            }
            else System.out.println("Player "+currentPlayer.getId()+" completed!!!");
        }
    }

    private int positionAfterSnakeOrLadder(Cell cell, int currentPosition) {
        if(cell.getJump()==null) return currentPosition;
        else{
            System.out.println("getting a Jump");
            return cell.getJump().end;
        }
    }
}
