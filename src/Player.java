import java.util.HashMap;

public class Player {
    HashMap<String, Integer> map = new HashMap<String, Integer>();   //Map to hold all 13 of our categories
    int diceRolls = 0;
    int totalScore = 0;

    public Player(){
        initializeMap();
    }

    public void initializeMap(){
        map.put("Ones", null);
        map.put("Twos", null);
        map.put("Threes", null);
        map.put("Fours", null);
        map.put("Fives", null);
        map.put("Sixes", null);
        map.put("Bonus", null);
        map.put("Three of a kind", null);
        map.put("Four of a kind", null);
        map.put("Full house", null);
        map.put("Small straight", null);
        map.put("Large straight", null);
        map.put("Chance", null);
        map.put("Yahtzee", null);
    }

//    public String toString(){
//        String str = "";
//        for(String key : map.keySet()){
//            str += key + ": " + map.get(key) + "\n";
//        }
//
//        return str;
//    }

    public String toString(){

        return "Ones: " + map.get("Ones") + "\n" +
                "Twos: " + map.get("Twos") + "\n" +
                "Threes: " + map.get("Threes") + "\n" +
                "Fours: " + map.get("Fours") + "\n" +
                "Fives: " + map.get("Fives") + "\n" +
                "Sixes: " + map.get("Sixes") + "\n" +
                "Bonus: " + map.get("Bonus") + "\n" +
                "\n" +
                "Three of a kind: " + map.get("Three of a kind") + "\n" +
                "Four of a kind: " + map.get("Four of a kind") + "\n" +
                "Full house: " + map.get("Full house") + "\n" +
                "Small straight: " + map.get("Small straight") + "\n" +
                "Large straight: " + map.get("Large straight") + "\n" +
                "Chance: " + map.get("Chance") + "\n" +
                "Yahtzee: " + map.get("Yahtzee");


    }

    public int Score(){
        for(String key : map.keySet()){
            totalScore += map.get(key);
        }

        return totalScore;
    }

    public boolean setCategory(String category, int score){
        if(!map.containsKey(category)){
            System.out.println("Spelled category incorrectly");
            return false;
        } else if(map.get(category) != null){
            System.out.println("You have already chosen this category");
            return false;
        } else {
            totalScore += score;
            map.put(category, score);
            return true;
        }
    }

    public int getDiceRolls(){
        return diceRolls;
    }

    public boolean incrementDiceRolls(){
        if(diceRolls == 3){
            System.out.println("You have already rolled 3 times. No more rolls allowed");
            return false;
        } else {
            diceRolls++;
            return true;
        }
    }

    public boolean isSet(String choice){
        if(map.get(choice) == null){
            return false;
        } else {
            return true;
        }
    }

    public boolean bonus(){
        int score = map.get("Ones") + map.get("Twos") + map.get("Threes") + map.get("Fours") + map.get("Fives") + map.get("Sixes");
        return score >= 63;
    }

    public void clearDiceRolls(){
        diceRolls = 0;
    }

}
