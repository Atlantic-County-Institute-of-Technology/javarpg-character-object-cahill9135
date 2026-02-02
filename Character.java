import java.util.HashMap;

public class Character {

    private final String[] magicList = {"Wizard", "Sorcerer", "Warlock", "Druid", "Paladin", "Cleric", "Bard", "Magic"};
    private final String[] rangedList = {"Ranger", "Archer", "Gunslinger", "Rouge", "Thief", "Ranged"};
    private final String[] meleeList = {"Barbarian", "Monk", "Fighter", "Monster Hunter", "Melee"};

    public HashMap<String, String> characterMatcher;

    public int[] statBonus = {-1, 0, 1, 2, 3, 4};
    public int[] statLine = {8, 10, 12, 14, 16, 18};
    public String[] statLabel = {"STR", "DEX", "INT", "CON", "WIS", "CHA"};

    public int hitpoints;
    public int armorClass;
    public int characterLevel;
    public String charClass;
    public String name;

    Dice dice = new Dice();

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
        System.out.println(charClass);


    }



    public int getPrimaryAbilityModifier(){
        return switch (charClass) {
            case "Melee" -> getAbilityModifier(statLine[0]);
            case "Ranged" -> getAbilityModifier(statLine[1]);
            case "Magic" -> getAbilityModifier(statLine[2]);
            default -> 0;
        };
    };

    public int rollStat() {
        dice.clear();
        dice.addDie(4, 6);
        dice.rollAll();
        dice.sortDice();
        dice.removeDie(0);
        return dice.getAllValues();
    }

    public void rollStats() {
        dice.clear();
        dice.addDie(4, 6);
        for (int i = 0; i <= 5; i++) {
            dice.rollAll();
            dice.sortDice();
            dice.removeDie(0);
            statLine[i] = dice.getAllValues();
            dice.addDie(6);
        }

        for (int i = 0; i <=5; i++){
            statBonus[i] = getAbilityModifier(statLine[i]);
        }
        calculateBaseHealth();

    getStats();
    }

    public int getAbilityModifier(int abilityScore) {
        return (abilityScore - 10)/2;
    };

    public int calculateBaseHealth() {
        hitpoints = 20 + getAbilityModifier(statLine[3]);
        return hitpoints;
    };

    public int calculateArmorClass() {
        armorClass = 10 + getPrimaryAbilityModifier();
        return armorClass;
    };

    public void getStats() {
        String result = "";
        for(int i = 0; i <= 5; i++){
            result += statLabel[i] + ": " + statLine[i] + " +" + statBonus[i] + "\n";
        }
        System.out.println(result);
    };

    public String getCharClass() {
        return charClass;
    }

    public int getCharacterLevel() {
        return characterLevel;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public boolean isAlive() {
        return hitpoints > 0;
    };

    public String toString() {
        String result = "Character: ";
        result += name + " (Level " + characterLevel + " " + charClass + ")\n"
        + "HP: " + calculateBaseHealth() + " | AC: " + calculateArmorClass() + "\n";

        for (int i = 0; i <=2; i++ ){
            result += statLabel[i] + ": " + statLine[i] + " + " + statBonus[i] + " | ";
        }

        result += "\n";

        for (int i = 3; i <=5; i++ ){
            result += statLabel[i] + ": " + statLine[i] + " + " + statBonus[i] + " | ";
        }

        return result;
    };

}
