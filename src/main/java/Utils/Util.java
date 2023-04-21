package Utils;

import org.graalvm.collections.Pair;

public  class Util {
    public static final Pair<Integer,Integer> getRowColumnFromNumber(int number,int boardSize){
        int rowNo=Math.min(number/boardSize,boardSize-1);
        int columnNo=(number-1)%boardSize;
        return Pair.create(rowNo,columnNo);
    }
}
