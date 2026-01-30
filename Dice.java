import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

class Dice {

    // instance variables
    private ArrayList<Die> dice;

    // creates an empty collection for the dice
    public Dice() {
        this.dice = new ArrayList<>();
    }

    public void addDie(int sides) {
        if(sides > 0)
            dice.add(new Die(sides));
    }

    //adds a number of dice equal to count (>0) dice to any of the sides (>0) to the list
    public void addDie(int count, int sides) {
        for(int i=0; i <= count; i++)
            addDie(sides);
    }

    //rolls a die at a specific index, returns -1 if no dice to be rolled
    public int rollDie(int index) {
        if (!dice.isEmpty()) {
            return dice.get(index).roll();
        }
        else{
            return -1;
        }
    };

    //rolls a set of dice between two indexes
    public int rollDice(int start, int end){
        if (!dice.isEmpty()) {
            int result = 0;
            for(int i = start; i < end; i++){
                result += dice.get(i).roll();
            }
            return result;
        }
        else {
            return -1;
        }
    };

    //rolls all dice in the list
    public int rollAll(){
        if (!dice.isEmpty()) {
            int result = 0;
            for(int i = 0; i < dice.size(); i++){
                result += dice.get(i).roll();
            }
            return result;
        }
        else {
            return -1;
        }
    };

    //Returns the last rolled value of a given index
    public int getDieValue(int index){
        if (!dice.isEmpty()) {
            return dice.get(index).getValue();
        }
        else{
            return -1;
        }
    };

    //Returns all the values of the last rolled dice, added together
    public int getAllValues(){
        if (!dice.isEmpty()) {
            int result = 0;
            for(int i = 0; i < dice.size(); i++){
                result += dice.get(i).getValue();
            }
            return result;
        }
        else {
            return -1;
        }
    };

    public void removeDie(int index) {
        if (index < 0 || index >= dice.size()){
            throw new IndexOutOfBoundsException("Invalid die index: " + index);
        }
        dice.remove(index);
    }

    public void sortDice() {
        Collections.sort(dice, new Comparator<Die>() {
            public int compare(Die d1, Die d2) {
                return Integer.compare(d1.getValue(), d2.getValue());
            }
        });

    }

    //Return the size of the list
    public int size(){
        return dice.size();
    };

    //Clears the dice list
    public void clear(){
        dice.clear();

    };

    // The die object class used by our dice
    public static class Die implements DieInterface {

        private int sides;
        private int currentValue;
        private Random random;

        public Die(int sides) {
            this.sides = sides;
            this.random = new Random();
            this.currentValue = 1; // Initial Value
        }

        public int roll() {
            currentValue = random.nextInt(sides) + 1;
            return currentValue;
        }

        public int getValue(){ return currentValue;};

        public int getSides() {return sides;}

    }
}
