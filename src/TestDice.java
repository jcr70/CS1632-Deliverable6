/* 6/7 test coverage */

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class TestDice {
    Dice dice = new Dice();

    /*
    Amount of dice should always equal 5
     */
    @Test
    public void TestAmountOfDice(){
        ArrayList<Integer> userDice = dice.Roll();
        assertEquals(userDice.size(), 5);
    }

    /*
    A dice roll should be between 1-6
     */
    @Test
    public void TestBoundaries(){
        int roll = dice.rollOneDice();
        System.out.println(roll);
        assertTrue(roll >= 0 && roll < 7);
    }


    /*
    After rolling dice, toString should not be null
     */
    @Test
    public void TestNotNullToString(){
        dice.Roll();
        assertNotNull(dice.toString());
    }

    /*
    If a user elects to re roll their dice, the specified indices must be re-rolled. The two strings should be different here.
     */
    @Test
    public void TestReRoll() {
        dice.Roll();
        String before = dice.toString();
        String[] x = {"0", "1", "2", "3"};
        dice.reRoll(x);
        String after = dice.toString();
        assertNotEquals(before, after);
    }

    /*
    Populates the dice, then checks to see if the clearDice() method works by seeing if the ArrayList is empty
     */
    @Test
    public void TestClearDice(){
        dice.Roll();
        dice.clearDice();
        assertTrue(dice.getDice().isEmpty());
    }



}
