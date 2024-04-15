# JAVSTONE
![Group 490 1JAVSTONPWP](https://github.com/aent0n/ECE_JAVA_B2_S2_Project-JAVSTONE/assets/116871473/053fc9f4-3b47-4288-98e3-93724d26b5b2)

A repository designated to the ECE B2 S2 Java "JAVSTONE" project, a Java project aiming to design a HearthStone-like game. With Belaid IOUDJAOUDENE.


## Ressources used
Here is a non-exhaustive list of the tools/ressources used in the conception

Technical part:
  - Java (.java)
  - Maven (software project management & comprehension tool)
  - Oracle libraries
  - JUnit 4 Framework (testing framework)

Visual part:
  - Figma (early design, mockup)
  - Adobe Photoshop (graphical assets like cards, board, game identity)
  - HuggingFace Community (graphical assets like cards, board, game identity)

## Project requirements
The key requirements are as follows:


``Champions``: The project should have two champions, each characterized by an ID, name, health points, and a special ability. Champions can only attack if their special ability allows it.


``Cards and Monsters``: Each champion will have a set of cards that can summon different types of monsters onto the game board. Monsters are characterized by an ID, name, health points, and attack power.


``Monster Types``: The project should implement the following types of monsters:
  - Classic monsters that can attack the enemy.
  - Protector monsters that prevent enemy monsters or the opponent's champion from attacking.
  - Healer monsters that can heal allies or enemies but cannot attack.
  - Mascot monsters that can buff an ally or enemy target.


``Game Turn Flow``: Each turn, the champion can:
  -  Play a card to summon a monster onto the game board.
  - Use their special ability.
  - Have the champion and their monsters attack targets.
  - The game continues until one of the champions is knocked out (their health points reach 0 or less), or all the card are played (champion with lower health points lose).


``Technical Requirements``:
  - Use at least one interface.
  - Implement a minimum of inheritance.
  - Log important information to a log file in a custom format (e.g., "Champion 1 summons Protector 1", "Monster 3 defeats the enemy champion, game over", etc.).
  - Implement a minimum of 5 unit tests, including:
    - A test that simulates a monster attack on another monster with equal attack and health points, verifying that the attacked monster's health is reduced to 0 and it is removed       from the board.
    - A test that instantiates a fight between two champions, where one knocks out the other, and verifies that the correct winner is declared.
    - 3 additional tests covering the main functionalities of the application or other important aspects.
    - Adhere to Java coding conventions (UpperCamelCase for class names, lowerCamelCase for variables and methods, proper indentation, etc.).
    - Provide comprehensive comments and/or Javadoc documentation.


``Bonuses``:
  - Use Java streams and anonymous functions.
  - Design a GUI and some visual assets for the cards


## Project structure
The project was built using Maven, with the following structure

```
|   game.log
|   pom.xml
|
+---src
    +---main
    |   \---java
    |       \---com
    |           \---anton_belaid
    |               \---hs_like
    |                   |   Main.java
    |                   |
    |                   +---controller
    |                   |       Game.class
    |                   |       Game.java
    |                   |
    |                   +---interfaces
    |                   |       Attacker.class
    |                   |       Attacker.java
    |                   |
    |                   +---model
    |                   |       Board.java
    |                   |       Card.class
    |                   |       Card.java
    |                   |       Champion.class
    |                   |       Champion.java
    |                   |       ClassicMonster.java
    |                   |       HealerMonster.java
    |                   |       MascottMonster.java
    |                   |       Monster.class
    |                   |       Monster.java
    |                   |       Playable.class
    |                   |       Playable.java
    |                   |       ProtectorMonster.java
    |                   |       SpecialAbility.class
    |                   |       SpecialAbility.java
    |                   |
    |                   \---utils
    |                           ChampionSelector.java
    |                           LogFileEraser.java
    |                           LoggerUtils.class
    |                           LoggerUtils.java
    |
    \---test
       \---java
            \---com
                \---anton_belaid
                    \---hs_like
                        +---controller
                        |       GameTest.java

```
