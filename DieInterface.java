// dice_interface.java
// @description: interface describing a die to be used for dice
// @author: pcostjr
// created: 1.7.2026
// last update: 1.8.2026
public interface DieInterface {

    // rolls the die and returns an integer result based on the number of sides
    int roll();

    // obtain the last rolled value of the die
    // default (before rolling = -1)
    int getValue();

    // get the sides of the die
    int getSides();
}