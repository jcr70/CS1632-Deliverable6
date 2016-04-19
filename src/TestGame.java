import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;

public class TestGame {
    Game g = new Game();
    Dice d = new Dice();


    /*
    Test if a user gets a three of a kind. Three of the same number
     */
    @Test
    public void TestThreeOfAKind(){
        ArrayList<Integer> d = new ArrayList<Integer>();
        d.add(3);
        d.add(6);
        d.add(3);
        d.add(6);
        d.add(6);
        assertTrue(g.isThreeOfAKind(d));

        d.clear();
        d.add(1);
        d.add(2);
        d.add(3);
        d.add(4);
        d.add(5);
        assertFalse(g.isThreeOfAKind(d));

        d.clear();
        d.add(2);
        d.add(3);
        d.add(2);
        d.add(2);
        d.add(1);

    }

    /*
    Tests if a user gets four of a kind. Four of the same number
     */
    @Test
    public void TestFourOfAKind(){
        ArrayList<Integer> d = new ArrayList<Integer>();
        d.add(3);
        d.add(1);
        d.add(1);
        d.add(1);
        d.add(1);
        assertTrue(g.isFourOfAKind(d));
    }

    @Test
    public void TestFullHouse(){
        ArrayList<Integer> d = new ArrayList<Integer>();
        d.add(1);
        d.add(6);
        d.add(1);
        d.add(6);
        d.add(6);
        assertTrue(g.isFullHouse(d));

        d.clear();
        d.add(2);
        d.add(2);
        d.add(3);
        d.add(3);
        d.add(5);
        assertFalse(g.isFullHouse(d));

    }

    /*
    Tests if the user correctly has a small straight. This is 4 numbers in a row. So either 1-2-3-4, 2-3-4-5, 3-4-5-6
     */
    @Test
    public void TestSmallStraight() {
        ArrayList<Integer> d = new ArrayList<Integer>();
        d.add(1);
        d.add(2);
        d.add(3);
        d.add(4);
        d.add(3);
        assertTrue(g.isSmallStraight(d));

        d.clear();
        d.add(2);
        d.add(2);
        d.add(3);
        d.add(4);
        d.add(5);
        assertTrue(g.isSmallStraight(d));

        d.clear();
        d.add(1);
        d.add(2);
        d.add(6);
        d.add(4);
        d.add(5);
        assertFalse(g.isSmallStraight(d));

    }

    /*
    Tests if a user has a large straight, which is 5 in a row. Either 1-2-3-4-5 or 2-3-4-5-6
     */
    @Test
    public void TestLargeStraight() {
        ArrayList<Integer> d = new ArrayList<Integer>();
        d.add(1);
        d.add(2);
        d.add(3);
        d.add(4);
        d.add(5);
        assertTrue(g.isLargeStraight(d));

        d.clear();
        d.add(2);
        d.add(4);
        d.add(3);
        d.add(6);
        d.add(5);
        assertTrue(g.isLargeStraight(d));

        d.clear();
        d.add(1);
        d.add(2);
        d.add(6);
        d.add(4);
        d.add(5);
        assertFalse(g.isLargeStraight(d));

    }

    /*
    Tests whether a user has yahtzee. This is 5 of the same number, basically 5 of a kind
     */
    @Test
    public void TestIsYahtzee(){
        ArrayList<Integer> d = new ArrayList<Integer>();
        d.add(3);
        d.add(3);
        d.add(3);
        d.add(3);
        d.add(3);
        assertTrue(g.isYahtzee(d));

        d.clear();
        d.add(3);
        d.add(4);
        d.add(3);
        d.add(3);
        d.add(3);
        assertFalse(g.isYahtzee(d));
    }

}
