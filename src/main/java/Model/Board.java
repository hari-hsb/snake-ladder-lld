package Model;

import Utils.Util;
import org.graalvm.collections.Pair;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] cells;
    int start=1;
    Random random=new Random();
    Set<Integer> jumpHeads=new HashSet<>();
    int end;
    int boardSize;

    public Board(int boardSize,int noOfSnakes,int noOfLadders) {
        this.end=boardSize*boardSize;
        this.boardSize=boardSize;
        addCells(boardSize);
        addSnakes(noOfSnakes);
        addLadders(noOfLadders);
    }

    private void addLadders(int noOfLadders) {
        int ladderAdded=0;
        while(ladderAdded<noOfLadders){
            int ladderStart=ThreadLocalRandom.current().nextInt(start,end);
            int ladderDown=ThreadLocalRandom.current().nextInt(start,end);
            if(!jumpHeads.contains(ladderStart) && ladderDown>ladderStart) {
                Jump jump = new Jump(ladderStart, ladderDown);
                jumpHeads.add(ladderStart);
                Pair<Integer,Integer> rowColumnIndex= Util.getRowColumnFromNumber(ladderStart,boardSize);
                this.cells[rowColumnIndex.getLeft()][rowColumnIndex.getRight()].setJump(jump);
                ladderAdded++;
            }
        }
    }

    private void addSnakes(int noOfSnakes) {
        int snakeAdded=0;
        while(snakeAdded<noOfSnakes){
            int snakeHead= ThreadLocalRandom.current().nextInt(start,end);
            int snakeEnd= ThreadLocalRandom.current().nextInt(start,end);
            if(!jumpHeads.contains(snakeHead) && snakeHead>snakeEnd) {
                Jump jump = new Jump(snakeHead, snakeEnd);
                jumpHeads.add(snakeHead);
                Pair<Integer,Integer> rowColumnIndex= Util.getRowColumnFromNumber(snakeHead,boardSize);
                this.cells[rowColumnIndex.getLeft()][rowColumnIndex.getRight()].setJump(jump);
                snakeAdded++;
            }
        }
    }

    private void addCells(int boardSize) {
        Cell[][] cells1=new Cell[boardSize][boardSize];
        for(int i=0;i<boardSize;i++){
            for(int j=0;j<boardSize;j++) {
                cells1[i][j]=new Cell();
            }
        }
        this.cells=cells1;
    }

    public void printBoard(){
        for(int i=0;i<this.boardSize;i++){
            for(int j=0;j<this.boardSize;j++){
                if(this.cells[i][j].getJump()==null) System.out.print("* ");
                else if(this.cells[i][j].getJump().start>this.cells[i][j].getJump().end) System.out.print("s ");
                else System.out.print("l ");
            }
            System.out.println(" ");
            System.out.println(" ");
        }

    }

    public Cell[][] getCells() {
        return cells;
    }

    public Board setCells(Cell[][] cells) {
        this.cells = cells;
        return this;
    }

    public int getStart() {
        return start;
    }

    public Board setStart(int start) {
        this.start = start;
        return this;
    }

    public Random getRandom() {
        return random;
    }

    public Board setRandom(Random random) {
        this.random = random;
        return this;
    }

    public Set<Integer> getJumpHeads() {
        return jumpHeads;
    }

    public Board setJumpHeads(Set<Integer> jumpHeads) {
        this.jumpHeads = jumpHeads;
        return this;
    }

    public int getEnd() {
        return end;
    }

    public Board setEnd(int end) {
        this.end = end;
        return this;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public Board setBoardSize(int boardSize) {
        this.boardSize = boardSize;
        return this;
    }
}
