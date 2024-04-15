package com.anton_belaid.hs_like.model;

import java.util.List;
import java.util.Arrays;

public class Board {
    private Champion champion1;
    private Champion champion2;
    private List<Monster> player1Monsters; // Declare player1Monsters
    private List<Monster> player2Monsters; // Declare player2Monsters
    private Champion currentTurn;

    public Board(Champion champion1, Champion champion2, Champion currentTurn) {
        this.champion1 = champion1;
        this.champion2 = champion2;
        this.player1Monsters = champion1.getMonsters(); // Initialize player1Monsters
        this.player2Monsters = champion2.getMonsters(); // Initialize player2Monsters
        this.currentTurn = currentTurn;
    }

    public void addMonster(Monster monster, Champion currentTurn) {
        if (currentTurn == champion1) {
            player1Monsters.add(monster);
            monster.setMaster(currentTurn);
        } else {
            player2Monsters.add(monster);
            monster.setMaster(currentTurn);
        }
    }

    public List<Monster> getMonsters(Champion currentTurn) {
        return (currentTurn == champion1) ? player1Monsters : player2Monsters;
    }

    public void display(int turnCount) {
        // Display the game mat with the champion of player 2 at the top right corner
        List<String> champion2Lines = Arrays.asList(
            "",
            "Player: " + champion2.getPlayerName(),
            "ID: " + champion2.getId(),
            champion2.getName(),
            "HP: " + champion2.getHealthPoints(),
            "Healed : " + (champion2.hasHealed() ? "Yes, Heal Value: " + champion2.getHealValue() : "No"),
            "Attack Boost : " + (champion2.hasAttackBoost() ? "Yes, Boost Value: " + champion2.getAttackBoostValue() : "No"),
            "Protection : " + (champion2.isProtected() ? "Yes, by " + champion2.getProtector().getName() : "No")
        );
        System.out.println("+--------------------------------------------------------------------------------+");
        for (String line : champion2Lines) {
            System.out.println("|" + String.format("%-78s", line) + "  |");
        }
        System.out.println("|" + String.format("%80s", "") + "|");

        // Empty space
        for (int i = 0; i < 7; i++) {
            System.out.println("|                                                                                |");
        }

        // Display the monsters of player 2
        for (Monster monster : player2Monsters) {
            if (monster.getHealthPoints() > 0) {
                List<String> monsterLines = Arrays.asList(
                    "-----------",
                    "ID : " + monster.getId(),
                    "Known as: " + monster.getName(),
                    "HP : " + monster.getHealthPoints(),
                    "Type : " + monster.getType(),
                    "Healed : " + (monster.hasHealed() ? "Yes, Heal Value: " + monster.getHealValue() : "No"),
                    "Attack Boost : " + (monster.hasAttackBoost() ? "Yes, Boost Value: " + monster.getAttackBoostValue() : "No"),
                    ""
                );
                for (String line : monsterLines) {
                    System.out.println("|" + String.format("%-78s", line) + "  |");
                }   
            }

        }
        System.out.println("|" + String.format("%80s", "") + "|");

        // Empty space + middle line
        for (int i = 0; i < 3; i++) {
            System.out.println("|                                                                                |");
        }
        System.out.println("| ============================================================================== |");
        for (int i = 0; i < 3; i++) {
            System.out.println("|                                                                                |");
        }

        // Display the monsters of player 1
        for (Monster monster : player1Monsters) {
            if (monster.getHealthPoints() > 0) {
                List<String> monsterLines = Arrays.asList(
                    "-----------",
                    "ID : " + monster.getId(),
                    "Known as: " + monster.getName(),
                    "HP : " + monster.getHealthPoints(),
                    "Type : " + monster.getType(),
                    "Healed : " + (monster.hasHealed() ? "Yes, Heal Value: " + monster.getHealValue() : "No"),
                    "Attack Boost : " + (monster.hasAttackBoost() ? "Yes, Boost Value: " + monster.getAttackBoostValue() : "No"),
                    ""
                );
                for (String line : monsterLines) {
                    System.out.println("|" + String.format("%-78s", line) + "  |");
                }
            }
        }
        System.out.println("|" + String.format("%80s", "") + "|");

        // Empty space
        for (int i = 0; i < 7; i++) {
            System.out.println("|                                                                                |");
        }

        // Display the game mat with the champion of player 1 at the bottom left corner
        List<String> champion1Lines = Arrays.asList(
            "",
            "Player: " + champion1.getPlayerName(),
            "ID: " + champion1.getId(),
            champion1.getName(),
            "HP: " + champion1.getHealthPoints(),
            "Healed : " + (champion1.hasHealed() ? "Yes, Heal Value: " + champion1.getHealValue() : "No"),
            "Attack Boost : " + (champion1.hasAttackBoost() ? "Yes, Boost Value: " + champion1.getAttackBoostValue() : "No"),
            "Protection : " + (champion1.isProtected() ? "Yes, by " + champion1.getProtector().getName() : "No")
        );
        for (String line : champion1Lines) {
            System.out.println("|" + String.format("%-78s", line) + "  |");
        }
        System.out.println("|" + String.format("%80s", "") + "|");
        System.out.println("+--------------------------------------------------------------------------------+");
    }

    public String generateBox(List<String> lines) {
        StringBuilder box = new StringBuilder();
        int maxLength = lines.stream().mapToInt(String::length).max().orElse(0);

        for (String line : lines) {
            box.append("| ").append(String.format("%-" + maxLength + "s", line)).append(" |\n");
        }

        return box.toString();
    }

}