import java.util.HashMap;

public class Character {

    // arrays for our hashmap
    private final String[] magicList = {"Wizard", "Sorcerer", "Warlock", "Druid", "Paladin", "Cleric", "Bard", "Magic"};
    private final String[] rangedList = {"Ranger", "Archer", "Gunslinger", "Rouge", "Thief", "Ranged"};
    private final String[] meleeList = {"Barbarian", "Monk", "Fighter", "Monster Hunter", "Melee"};

    // initilizing variables and such
    public HashMap<String, String> characterMatcher;

    // the indexes of all of these correspond.
    public int[] statBonus = {0, 0, 0, 0, 0, 0};
    public int[] statLine = {8, 10, 12, 14, 16, 18};
    public String[] statLabel = {"STR", "DEX", "INT", "CON", "WIS", "CHA"};

    public int hitpoints;
    public int armorClass;
    public int characterLevel = 1;
    public String charClass;
    public String name;

    Dice dice = new Dice();

    // Creates a new "character", needs an inputted name and class. Class is cross-referenced from the hashmap
    // to determine its core attribute and general style.
    public void createCharacter(String cName, String cClass){
        name = cName;
        characterMatcher = new HashMap<>();

        for (int i=0; i<8; i++) {
            characterMatcher.put(magicList[i].toLowerCase(), "Magic");
        }
        for (int i=0; i<6; i++) {
            characterMatcher.put(rangedList[i].toLowerCase(), "Ranged");
        }
        for (int i=0; i<5; i++) {
            characterMatcher.put(meleeList[i].toLowerCase(), "Melee");
        }

        charClass = characterMatcher.get(cClass.toLowerCase());
    }

    // calls the rollStat function six times, indexing in stat rolls into the statLine array.
    // calculates getAbilityModifier six times, indexing the stat bonuses into the statBonus array.
    // also calculates base health and armor class using their respective functions.
    public void rollStats() {
        for (int i = 0; i <= 5; i++) {
            statLine[i] = rollStat();
        }

        for (int i = 0; i <=5; i++){
            statBonus[i] = getAbilityModifier(statLine[i]);
        }
        calculateBaseHealth();
        calculateArmorClass();
    }

    // rolls 4 dice and drops the lowest value, then returns the sum.
    private int rollStat() {
        dice.clear();
        dice.addDie(4, 6);
        dice.rollAll();
        dice.sortDice();
        dice.removeDie(0);
        return dice.getAllValues();
    }

    // calculates ability modifier based off the number passed in
    private int getAbilityModifier(int abilityScore) {
        return (abilityScore - 10)/2;
    }

    // finds the primary ability modifier depending on which class style you are
    private int getPrimaryAbilityModifier(){
        return switch (charClass) {
            case "Melee" -> getAbilityModifier(statLine[0]);
            case "Ranged" -> getAbilityModifier(statLine[1]);
            case "Magic" -> getAbilityModifier(statLine[2]);
            default -> 0;
        };
    }

    // calculates base health using the modifier of the 4th stat, Con.
    private int calculateBaseHealth() {
        hitpoints = 20 + getAbilityModifier(statLine[3]);
        return hitpoints;
    }

    // Finds armor class using the primary ability modifier bonus.
    private int calculateArmorClass() {
        armorClass = 10 + getPrimaryAbilityModifier();
        return armorClass;
    }

    // prints your stat values in a string
    public void getStats() {
        String result = "";
        for(int i = 0; i <= 5; i++){
            result += statLabel[i] + ": " + statLine[i] + " +" + statBonus[i] + "\n";
        }
        System.out.println(result);
    }

    // returns the character class
    public String getCharClass() {
        return charClass;
    }

    // returns character level
    public int getCharacterLevel() {
        return characterLevel;
    }

    // returns armor class
    public int getArmorClass() {
        return armorClass;
    }

    // returns current hitpoints
    public int getHitpoints() {
        return hitpoints;
    }

    // return true if character hp is more than zero, otherwise false.
    public boolean isAlive() {
        return hitpoints > 0;
    }

    // returns all the character info in string format
    public String toString() {
        String result = "Character: ";
        result += name + " (Level " + characterLevel + " " + charClass + ")\n"
                + "HP: " + calculateBaseHealth() + " | AC: " + calculateArmorClass() + "\n";

        for (int i = 0; i <=2; i++ ){
            result += statLabel[i] + ": " + statLine[i] + " + " + statBonus[i];
            if (i!=2) result += " | ";
        }

        result += "\n";

        for (int i = 3; i <=5; i++ ){
            result += statLabel[i] + ": " + statLine[i] + " + " + statBonus[i];
            if (i!=5) result += " | ";
        }

        return result;
    }
}
