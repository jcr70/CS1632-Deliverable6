import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Dice {
    Random r;
    private static int NUM_DICE = 5;
    ArrayList<Integer> dice = new ArrayList<Integer>();

    public Dice(){
        r = new Random();
    }

    public int rollOneDice(){
        return r.nextInt(6) + 1;    //(0 - 7]
    }

    public void reRoll(String[] indexes){
        for(int i = 0; i < indexes.length; i++){
            int num = rollOneDice();
            int index = Integer.parseInt(indexes[i]);
            dice.remove(index);
            dice.add(index, num);
        }
    }

    public ArrayList<Integer> Roll() {
        for (int i = 0; i < NUM_DICE; i++) {
            dice.add(rollOneDice());
        }

        return dice;
    }

    public String toString(){
        String str = "";

        if(dice == null){
            return null;
        }
        for(int i : dice){
            str += i + " ";
        }

        return str;
    }

    public int size(){
        return NUM_DICE;
    }

    public void clearDice(){
        dice.clear();
    }

    public ArrayList<Integer> getDice(){
        return dice;
    }

}
