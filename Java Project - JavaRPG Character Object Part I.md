#java #programming #project/outline #teaching
# Java RPG - Character Object

## Overview
___
**Objective:** In this project, we'll create a Character class for our JavaRPG project. The character is very similar to the one we've made before, but is now its own object class, able to be replicated for unique character values.

In addition, you'll be given an interface and a driver to work with. If your method calls and expected outputs match the interface, then you'll be able to use the driver to send your character son an adventure!

## 0: The Rules
___
In order to make this project more reasonable than the myriad of rules we need to know about, we'll assert the following things for our JavaRPG.
- A Character is defined by:
	- It's name, level, and one of three character types: "melee", "ranged", or "magic"
	- One of six stats representing the Character's physical and mental abilities
	- It's HP and AC, values for remaining 'alive' and defending against taking damage.
	- A character has a 'primary stat' represented by its character type:
		- "melee" == STR
		- "ranged" == DEX
		- "magic" == INT
- We roll stats using the Dice objects we created last class. In this case, we'll roll 4 six-sided dice and drop the lowest. The sum of those dice will become the assigned stat value.
- We can derive attacks, defenses, modifiers, and other abilities from these stats.
## I: Instance Variables
___
For this first part, you'll have to create variables with the correct data type to store information in our program. Include the following for this character sheet:

|   Attribute   |               Value               |                Input Method                |
| :-----------: | :-------------------------------: | :----------------------------------------: |
|     name      |    The name of the character.     |        Read in from the constructor        |
| characterType |   "melee", "ranged", or "magic"   |    Read and validated from constructor     |
|     level     |   The current experience level    | Read in from the constructor (Starts at 1) |
|   hitPoints   |        The current health         |    assigned by calculateBaseHitPoints()    |
|  armorClass   | The number to beat to deal damage |     assigned by calculateArmorClass()      |
|      STR      |      An integer from 1 - 20       |          assigned by rollStats()           |
|      DEX      |      An integer from 1 - 20       |          assigned by rollStats()           |
|      INT      |      An integer from 1 - 20       |          assigned by rollStats()           |
|      CON      |      An integer from 1 - 20       |          assigned by rollStats()           |
|      WIS      |      An integer from 1 - 20       |          assigned by rollStats()           |
|      CHA      |      An integer from 1 - 20       |          assigned by rollStats()           |
|     Dice      |  Dice object for rolling values   |                   Dice()                   |
## II: Object Methods
___
For this part, you'll use the interface to add the following functions to your Character object.

- **Accessors and Mutators**
	- For the sake of simplicity, generate accessors and mutators for all instance variables. We might not ever use some of them, but this is easier than picking and choosing what we'll need.
- **getAbilityModifier(int abilityScore)**
	- This method returns the result of the following equation, rounded down:
		 (abilityScore - 10) / 2
- **getPrimaryAbilityModifier()**
	- This method extends getAbilityModifier, but returns the following:
		- The STR modifier if the class type is "melee"
		- The DEX modifier if the class type is "ranged"
		- The INT modifier if the class type is "magic"
- **calculateBaseHitPoints()**
	- This method assigns the HP value to 20 + the CON ability modifier
- **calculateArmorClass()**
	- This method assigns the AC value to 10 + the primary ability modifier
- **rollStat()**
	- This method rolls four six-sided dice and drops the lowest value, returning the sum of the dice.
- **rollStats()**
	- This method uses the above method and assigns STR, DEX, CON, INT, WIS, and CHA
	- In addition, this method calls calculateBaseHitPoints() and calculateArmorClass() with the new values
- **isAlive()**
	- Returns the true/false value of whether or not the player has more than 0 HP.
- **toString()**
	- The string representation of the character, formatted to look like the following:
	```
		Character: NAME (Level 1 melee)
		HP: 22 | AC: 10
		STR: 11 (+0) | DEX: 16 (+3) | CON: 15 (+2)
		INT: 12 (+1) | WIS: 17 (+3) | CHA: 15 (+2)
	```

## Grading Specifications
___
This project is graded on X specifications
- [ ] **Instance Variables** - All instance variables are declared correctly
- [ ] **Constructors, Accessors, and Mutators** - The class constructor, accessors, and mutators are defined and assigned.
- [ ] **Stats and Status** - The following methods are intialized and defined correctly:
	- rollStat()
	- rollStats()
	- isAlive()
	- toString()
- [ ] **Internal Calculations** - The following methods are initialized and defined correctly:
	- [ ] getAbilityModifier()
	- [ ] getPrimaryAbilityModifier()
	- [ ] calculateBaseHitPoints()
	- [ ] calculateArmorClass()

## Submission Guidelines
Please submit your file by pushing all changes to your assigned git repository. 
### Point Allocation Table - Summative Assignment Features (General)

| Score | Problem Solving                                                                                                                                  |
| ----- | ------------------------------------------------------------------------------------------------------------------------------------------------ |
| 4     | Response gives evidence of a complete understanding of the problem; is fully developed; is clearly communicated.                                 |
| 3     | Response gives the evidence of a clear understanding of the problem but contains minor errors or is not fully communicated.                      |
| 2     | Response gives evidence of a reasonable approach but indicates gaps in conceptual understanding. Explanations are incomplete, vague, or muddled. |
| 1     | Response gives some evidence of problem understanding but contains major programming or reasoning errors.                                        |
| 0     | No response or response is completely incorrect or irrelevant.                                                                                   |

