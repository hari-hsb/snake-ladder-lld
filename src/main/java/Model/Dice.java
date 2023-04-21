package Model;

import java.util.Random;

public class Dice {
    int diceCount;
    Random random;
    int maxNumber=6;
    int minNumber=1;

    public Dice(int diceCount) {
        this.diceCount = diceCount;
        this.random=new Random();
    }
    public int rollDice(){
        int sum=0;
        int diceUsed=0;
        while(diceUsed<diceCount){
            sum+=random.nextInt(maxNumber-minNumber)+minNumber;
            diceUsed++;
        }
        return sum;

    }
}
