package com.anton_belaid.hs_like.controller;

import com.anton_belaid.hs_like.model.Card;
import com.anton_belaid.hs_like.model.Champion;
import com.anton_belaid.hs_like.model.Monster;
import com.anton_belaid.hs_like.model.Playable;
import com.anton_belaid.hs_like.model.Board;
import com.anton_belaid.hs_like.utils.LoggerUtils;
import com.anton_belaid.hs_like.model.HealerMonster;
import com.anton_belaid.hs_like.model.ProtectorMonster;
import com.anton_belaid.hs_like.model.MascottMonster;

import java.util.List;
import java.util.ArrayList;

public class Game {
    private Champion champion1;
    private Champion champion2;
    private Champion currentTurn;
    private Board board;

    public Game(Champion champion1, Champion champion2) {
        this.champion1 = champion1;
        this.champion2 = champion2;
        this.currentTurn = champion1; // champion1 starts the game
        this.board = new Board(champion1, champion2, currentTurn);
    }

    public void start() {
        LoggerUtils.log("");
        LoggerUtils.log("[INFO] " + champion1.getPlayerName() + " (player 1) play as: " + champion1.getName());
        int turnCount = 0;
        LoggerUtils.log("[INFO] " + champion2.getPlayerName() + " (player 2) play as: " + champion2.getName());
        while (!isGameOver() && turnCount < 24) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            board.display(turnCount);
            LoggerUtils.log("");
            LoggerUtils.log("Turn starts for " + currentTurn.getName() + "(" + champion1.getPlayerName() + ")");
            System.out.println("Turn starts for " + currentTurn.getName() + " (" + currentTurn.getPlayerName() + ")" + "\n");
            playTurn(currentTurn, turnCount++);
            currentTurn = currentTurn == champion1 ? champion2 : champion1; // Switch turns
        }


        // Print the winner
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        Champion winner = champion1.getHealthPoints() > 0 ? champion1 : champion2;

        // Create a string with the winner's name
        String winnerName = winner.getName();

        // Create a string with a victory message
        String victoryMessage = "Congratulations, " + winnerName + "! You are the champion!";

        // Create a string with the separator
        String separator = "";
        for (int i = 0; i < victoryMessage.length(); i++) {
            separator += "=";
        }

        // Print the victory message with some additional formatting
        String formattedMessage = "\n\n" + separator + "\n" + victoryMessage + "\n" + separator;
        LoggerUtils.log(formattedMessage);
        System.out.println(formattedMessage);
    }

    private void playTurn(Champion champion, int turnCount) {
        // Champion decides to play a card
        if (champion.wantsToPlayCard()) {
            Card card = champion.chooseCard();
            Monster monster = champion.playCard(card);
            board.addMonster(monster, currentTurn); // Add the monster to the game board
            LoggerUtils.log("");
            LoggerUtils.log("==== SUMMONING PHASE ======");
            LoggerUtils.log(champion.getName() + " plays " + card.getName() + ", summoning " + monster.getName());
            System.out.println("");
        }

        

        System.out.print("\033[H\033[2J");
        System.out.flush();
        board.display(turnCount);
        List<Playable> targets = getPotentialCTargets(champion);
        LoggerUtils.log("");
        LoggerUtils.log("====== CHAMPION ATTACK PHASE ======");
        LoggerUtils.log(champion.getName() + " turn: Attack with your champion !");
        System.out.println("Champion turn: Attack with your champion !\n");
        Playable target = champion.chooseTarget(targets);
        champion.attack(target);
        LoggerUtils.log(champion.getName() + " attack " + target.getName());
        System.out.println(champion.getName() + " attack " + target.getName() + "\n");
        if (target.getHealthPoints() <= 0) {
            LoggerUtils.log(target.getName() + " is dead !");
            System.out.println(target.getName() + " is dead !");
        }
        else {
            LoggerUtils.log(target.getName() + " has " + target.getHealthPoints() + " HP left !");
            System.out.println(target.getName() + " has " + target.getHealthPoints() + " HP left !");
        }
        LoggerUtils.log("");


        LoggerUtils.log("====== MONSTER ATTACK PHASE ======");
        LoggerUtils.log(champion.getName() + " turn: Monsters attacking:");
        System.out.print("\033[H\033[2J");
        System.out.flush();
        board.display(turnCount);
        System.out.println("Monsters turn: Monsters attacking:\n");

        for (Monster monster : board.getMonsters(currentTurn)) {
            if (!monster.getMaster().equals(currentTurn)) {
                continue;
            }
            if (monster.wantsToAttack()) {
                List<Playable> potentialTargets = getPotentialTargets(champion, monster);
                Playable targetM = monster.chooseTarget(potentialTargets, currentTurn);

                String actionWord = "is attacking";
                String boostMessage = "";
                if (monster instanceof HealerMonster) {
                    actionWord = "is healing";
                    boostMessage = "(Healing Power: + " + ((HealerMonster) monster).getHealBoost() + " HP)";
                } else if (monster instanceof ProtectorMonster) {
                    actionWord = "is protecting";
                } else if (monster instanceof MascottMonster) {
                    actionWord = "is boosting";
                    boostMessage = " (Boost Power: + " + ((MascottMonster) monster).getBoostPower() + " Attack power)";
                }

                System.out.println("Monster " + monster.getName() + " " + actionWord + " " + targetM.getName() + boostMessage);
                LoggerUtils.log("Monster " + monster.getName() + " " + actionWord + " " + targetM.getName() + boostMessage);

                try {
                    Thread.sleep(3500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                monster.attack(targetM);

                if (targetM.getHealthPoints() <= 0) {
                    LoggerUtils.log(targetM.getName() + " is dead !");
                    System.out.println(targetM.getName() + " is dead !\n");
                    try {
                        Thread.sleep(3500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    LoggerUtils.log(targetM.getName() + " has " + targetM.getHealthPoints() + " HP left !");
                    System.out.println(targetM.getName() + " has " + targetM.getHealthPoints() + " HP left !\n");
                    try {
                        Thread.sleep(3500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                LoggerUtils.log("Monster " + monster.getName() + " is feeling lazy :( !");
                System.out.println("Monster " + monster.getName() + " is feeling lazy :( !\n");
                try {
                    Thread.sleep(3500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean isGameOver() {
        return champion1.getHealthPoints() <= 0 || champion2.getHealthPoints() <= 0;
    }

    private List<Playable> getPotentialCTargets(Champion champion) {
        // Get the opponent of the given champion
        Champion opponent = getOpponent(champion);
    
        // Create a list of all the opponent's monsters
        List<Playable> targets = new ArrayList<>(opponent.getMonsters());
    
        // Add the opponent champion to the list of targets
        targets.add(opponent);
    
        // Return the list of targets
        return targets;
    }

    private List<Playable> getPotentialTargets(Champion champion, Monster monster) {
        // If the monster is an instance of HealerMonster or MascottMonster, return friendlies
        if (monster instanceof HealerMonster || monster instanceof MascottMonster) {
            // Create a list of all the champion's monsters
            List<Playable> friendlies = new ArrayList<>(champion.getMonsters());

            // Add the champion to the list of friendlies
            friendlies.add(champion);

            // Return the list of friendlies
            return friendlies;
        } else {
            // Get the opponent of the given champion
            Champion opponent = getOpponent(champion);

            // Create a list of all the opponent's monsters
            List<Playable> targets = new ArrayList<>(opponent.getMonsters());

            // Add the opponent champion to the list of targets
            targets.add(opponent);

            // Return the list of targets
            return targets;
        }
    }

    private Champion getOpponent(Champion champion) {
        if (champion == champion1) {
            return champion2;
        } else if (champion == champion2) {
            return champion1;
        } else {
            throw new IllegalArgumentException("Invalid champion");
        }
    }
}