// Imports!!! Yay!!!!
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Character whitheredjohn = new Character();
        whitheredjohn.createCharacter("john", "ranger");
        whitheredjohn.rollStats();
        System.out.println(whitheredjohn.isAlive());
        System.out.println(whitheredjohn);
        System.out.println(whitheredjohn.getArmorClass());
        System.out.println(whitheredjohn.getCharClass());
        System.out.println(whitheredjohn.getHitpoints());
    }
}
