import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Game {
    Dice dice;
    Player player;
    int moves = 0;
    Scanner in;

    public Game(){
        dice = new Dice();
        player = new Player();
        in = new Scanner(System.in);
    }

    public void runGame(){
        String input;
        while(++moves < 13){
            dice.Roll();
            player.incrementDiceRolls();

            while(player.getDiceRolls() < 3) {
                System.out.println("Dice Rolls:" + player.getDiceRolls());
                System.out.println("Your dice roll: " + dice.toString());
                System.out.println("Enter the index of the dice you'd like to re-roll. Separate them by spaces. Enter -1 for none");
                input = in.nextLine();
                if (input.equals("-1")) {
                    break;
                } else {
                    String[] indexes = input.split(" ");
                    dice.reRoll(indexes);
                    player.incrementDiceRolls();
                }
            }

            System.out.println("Your dice roll: " + dice.toString());
            while(true) {
                System.out.println("Which category would you like to enter your points for? Type 'y' to see your current category points");
                input = in.nextLine();
                if (input.equalsIgnoreCase("y")) {
                    System.out.println(player.toString());
                } else {
                    if(!player.isSet(input)){
                        player.setCategory(input, calculateScore(input));
                        player.clearDiceRolls();
                        dice.clearDice();
                        System.out.println("---------------- NEW ROUND ----------------");
                        break;
                    } else {
                        System.out.println("You have already used that category");
                    }
                }
            }


        }

        if(player.bonus()){
            System.out.println("You have achieved 63 points or greater in the upper categories. A bonus of 35 points has been awarded.");
            player.setCategory("Bonus", 35);
        }
        System.out.println("---------------- END OF GAME ----------------");
        System.out.println(player.toString());
        System.out.println("Total Score: " + player.totalScore);
    }

    public int calculateScore(String category){
        int sum = 0;
        ArrayList<Integer> d = dice.getDice();

        if(category.equals("Ones")){
            for(int i : d){
                if(i == 1){
                    sum += 1;
                }
            }

        } else if(category.equals("Twos")){
            for(int i : d){
                if(i == 2){
                    sum += 2;
                }
            }

        } else if(category.equals("Threes")){
            for(int i : d){
                if(i == 3){
                    sum += 3;
                }
            }

        } else if(category.equals("Fours")){
            for(int i : d){
                if(i == 4){
                    sum += 4;
                }
            }

        } else if(category.equals("Fives")){
            for(int i : d){
                if(i == 5){
                    sum += 5;
                }
            }

        } else if(category.equals("Sixes")){
            for(int i : d){
                if(i == 6){
                    sum += 6;
                }
            }

        } else if(category.equals("Bonus")){

        } else if(category.equals("Three of a kind")){
            if(isThreeOfAKind(d)){
                for(int i: d){
                    sum += i;
                }
            }

        } else if(category.equals("Four of a kind")){
            if(isFourOfAKind(d)){
                for(int i: d){
                    sum += i;
                }
            }

        } else if(category.equals("Full house")){
            if(isFullHouse(d)){
                sum = 25;
            }

        } else if(category.equals("Small straight")){
            if(isSmallStraight(d)){
                sum = 30;
            }
        } else if(category.equals("Large straight")){
            if(isLargeStraight(d)){
                sum = 40;
            }
        } else if(category.equals("Chance")){
            for(int i : d){
                sum += i;
            }
        }
        return sum;
    }

    public boolean isThreeOfAKind(ArrayList<Integer> d){
        Collections.sort(d);

        for(int i = 0; i < dice.size() - 2; i++){
            if(d.get(i) == d.get(i+1) && d.get(i+1) == d.get(i+2)){
                return true;
            }
        }
        return false;
    }

    public boolean isFourOfAKind(ArrayList<Integer> d){
        Collections.sort(d);
        for(int i = 0; i < dice.size() - 3; i++){
            if(d.get(i) == d.get(i+1) && d.get(i+1) == d.get(i+2) && d.get(i+2) == d.get(i+3)){
                return true;
            }
        }
        return false;
    }

    public boolean isFullHouse(ArrayList<Integer> d){
        Collections.sort(d);
        if(d.get(0) == d.get(1)){
            if(d.get(2) == d.get(3) && d.get(3) == d.get(4)){
                if(d.get(1) != d.get(2)){
                    return true;
                }
            }
        }

        if(d.get(0) == d.get(1) && d.get(1) == d.get(2)){
            if(d.get(3) == d.get(4)){
                if(d.get(2) != d.get(3)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSmallStraight(ArrayList<Integer> d){
        Collections.sort(d);
        int counter = 0;


        for(int i  = 0; i < d.size()-1; i++){
            if(d.get(i+1) - d.get(i) == 0){
                continue;
            }
            if(d.get(i+1) - d.get(i) == 1){
                counter++;

                if(counter == 3){
                    return true;
                }
            } else {
                counter = 0;
            }
        }
        return false;
    }

    public boolean isLargeStraight(ArrayList<Integer> d){
        Collections.sort(d);
        int counter = 0;

        for(int i  = 0; i < d.size()-1; i++){
            if(d.get(i+1) - d.get(i) == 0){
                continue;
            }
            if(d.get(i+1) - d.get(i) == 1){
                counter++;

                if(counter == 4){
                    return true;
                }
            } else {
                counter = 0;
            }
        }
        return false;
    }

    public boolean isYahtzee(ArrayList<Integer> d){
        return d.get(0) == d.get(1) && d.get(1) == d.get(2) && d.get(2) == d.get(3) && d.get(3) == d.get(4);
    }


}
