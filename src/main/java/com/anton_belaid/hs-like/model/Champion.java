package com.anton_belaid.hs_like.model;

import com.anton_belaid.hs_like.interfaces.Attacker;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Champion extends Playable implements Attacker{
    private SpecialAbility specialAbility;
    private List<Card> cards;
    private List<Monster> monsters;
    private String playerName;


    public Champion(String id, String name, int healthPoints, SpecialAbility specialAbility, List<Card> cards) {
        super(id, name, healthPoints, 0, false, 0, false, 0, false);
        this.specialAbility = specialAbility;
        this.cards = new ArrayList<>(cards); // Create a new ArrayList from the passed list
        this.monsters = new ArrayList<>();
    }

    // getters and setters for specialAbility and cards

    public SpecialAbility getSpecialAbility() {
        return specialAbility;
    }

    public void setSpecialAbility(SpecialAbility specialAbility) {
        this.specialAbility = specialAbility;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public boolean wantsToPlayCard() {
        // Implement the logic for deciding whether to play a card.
        // This could be based on the current game state, the champion's strategy, etc.
        // For now, let's assume the champion always wants to play a card.
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public Card chooseCard() {
        // Display the cards in the player's hand
        System.out.println("Your cards (HP/AP/Type):");
        for (int i = 0; i < cards.size(); i++) {
            System.out.println((i + 1) + ". " + cards.get(i).getName() + " - " + cards.get(i).getMonster().getHealthPoints() + " / " + cards.get(i).getMonster().getAttackPower() + " / " + cards.get(i).getMonster().getType());
        }
    
        // Prompt the player to choose a card
        System.out.println("Choose a card to play (enter the number):");
        int cardIndex = scanner.nextInt() - 1;
    
        return cards.get(cardIndex);
    }

    public Monster playCard(Card card) {
        // Remove the card from the champion's hand
        cards.remove(card);

        // Return the monster associated with the card
        return card.getMonster();
    }

    public boolean wantsToAttack() {
        // return true if the champion has any monsters on the board.
        return !this.monsters.isEmpty();
    }

    public Playable chooseTarget(List<Playable> targets) {
        // Print out the list of targets for the player to choose from
        System.out.println("\nChoose a target:\n");
        for (Playable target : targets) {
            if (target.getHealthPoints() > 0) {
                System.out.println("ID: " + target.getId() + ", Name: " + target.getName() + ", Type: " + target.getType() + ", HP: " + target.getHealthPoints());
            }
        }
        
        // Get the player's choice
        System.out.println("Enter the ID of the target:");
        String chosenId = scanner.next();
        
        // Find the target with the matching ID
        for (Playable target : targets) {
            if (target.getId().equals(chosenId)) {
                return target;
            }
        }
        
        // If no target with the matching ID was found, prompt the user to enter a valid ID
        System.out.println("No target with the ID " + chosenId + " was found. Please enter a valid ID.");
        return chooseTarget(targets);
    }

    public List<Monster> getMonsters() {
        return this.monsters;
    }

    @Override
    public void attack(Playable target) {
        // Check if the champion has a special ability
        if (this.specialAbility != null) {
            // Reduce the target's health points by the attack points of the champion's special ability
            target.reduceHealth(this.specialAbility.getAttackPoints());
        } else {
            System.out.println(this.getName() + " has no special ability to attack with.");
        }
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return this.playerName;
    }

}