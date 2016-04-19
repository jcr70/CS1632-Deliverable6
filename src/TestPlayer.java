import static org.junit.Assert.*;
import org.junit.Test;

public class TestPlayer {
    Player player = new Player();

    /*
    If map is initialized, toString won't return null
     */
    @Test
    public void TestMapInitialization(){
        assertNotNull(player.toString());
    }

    /*
    If category is spelled incorrectly by user, print message and return false
     */
    @Test
    public void TestMispellCategory(){
        assertFalse(player.setCategory("One's", 15));
    }

    /*
    If player tries to set the same category twice, this should print a message and return false
     */
    @Test
    public void TestScoreCategoryAgain(){
        player.setCategory("Ones", 5);
        assertFalse(player.setCategory("Ones", 5));
    }

    /*
    A player rolling the dice should only be able to increment each dice roll by 1
     */
    @Test
    public void TestGetDiceRolls(){
        assertEquals(0, player.getDiceRolls());
        player.incrementDiceRolls();
        assertEquals(1, player.getDiceRolls());
        player.incrementDiceRolls();
        assertEquals(2, player.getDiceRolls());
    }

    /*
    After 3 rolls, the player cannot roll anymore
     */
    @Test
    public void TestTooManyRolls(){
        player.incrementDiceRolls();
        player.incrementDiceRolls();
        player.incrementDiceRolls();
        assertFalse(player.incrementDiceRolls());
    }

    /*
    If dice has been rolled three times, the dice counter should be reset to 0. This tests ensures that it works
     */
    @Test
    public void TestClearDiceRolls(){
        player.incrementDiceRolls();
        player.incrementDiceRolls(); //2 dice rolls
        player.clearDiceRolls();
        assertEquals(0, player.getDiceRolls());
    }

    /*
    Tests that a category is already set. This ensures a category can't be changed once it has been set
     */
    @Test
    public void TestIsSet(){
        player.map.put("Full house", 25);
        assertTrue(player.isSet("Full house"));
        assertFalse(player.isSet("Fives"));
    }

    /*
    Tests to see if the bonus is registered when a user scores >= 63 points in the upper categories
     */
    @Test
    public void TestBonus(){

        //Adds up to 63 points exactly
        player.map.put("Ones", 3);
        player.map.put("Twos", 6);
        player.map.put("Threes", 9);
        player.map.put("Fours", 12);
        player.map.put("Fives", 15);
        player.map.put("Sixes", 18);
        assertTrue(player.bonus());

        //Less than 63 points, should return false
        Player p2 = new Player();
        p2.map.put("Ones", 0);
        p2.map.put("Twos", 6);
        p2.map.put("Threes", 9);
        p2.map.put("Fours", 12);
        p2.map.put("Fives", 15);
        p2.map.put("Sixes", 18);
        assertFalse(p2.bonus());
    }



}
