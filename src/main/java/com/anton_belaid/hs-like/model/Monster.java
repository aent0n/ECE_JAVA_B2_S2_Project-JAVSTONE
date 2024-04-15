package com.anton_belaid.hs_like.model;

import com.anton_belaid.hs_like.interfaces.Attacker;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Monster extends Playable implements Attacker{
    private int attackPower;
    protected boolean hasHealed;
    protected int healValue;
    protected boolean hasAttackBoost;
    protected int attackBoostValue;

    public Monster(String id, String name, int healthPoints, int attackPower, boolean hasHealed, int healValue, boolean hasAttackBoost, int attackBoostValue, boolean isProtected) {
        super(id, name, healthPoints, attackPower, hasHealed, healValue, hasAttackBoost, attackBoostValue, isProtected);

    }

    // Constructor that accepts a Card object
    public Monster(Card card) {
        super(card.getId(), card.getName(), card.getHealthPoints(), card.getAttackPower(), false, 0, false, 0, false);
        this.hasHealed = false;
        this.healValue = 0;
        this.hasAttackBoost = false;
        this.attackBoostValue = 0;
        this.isProtected = false;
    }

    public void attack(Playable target) {
        System.out.println("Attacking target: " + target.getName() + ", initial health: " + target.getHealthPoints());
        if (target.isProtected()) {
            // If the target is protected, the damage is applied to the protector instead
            target.getProtector().reduceHealth(this.attackPower);
            System.out.println("Attacked protector: " + target.getProtector().getName() + ", remaining health: " + target.getProtector().getHealthPoints());
        } else {
            // Otherwise, the damage is applied to the target
            target.reduceHealth(this.attackPower);
            System.out.println("Attacked target: " + target.getName() + ", remaining health: " + target.getHealthPoints());
        }
    }

    private static final Random RANDOM = new Random();
    public boolean wantsToAttack() {
        // The monster has a 20% chance of not wanting to attack :>
        return RANDOM.nextInt(20) != 0;
    }

    private static final Random RANDOM_TARGET = new Random();

    public Playable chooseTarget(List<Playable> potentialTargets, Champion currentTurn) {
        // Remove any monsters with 0 HP from the list of potential targets
        potentialTargets.removeIf(monster -> monster.getHealthPoints() == 0);

        System.out.println(potentialTargets.size() + " potential targets: " + potentialTargets.stream().map(Playable::getName).collect(Collectors.joining(", ")));

        // If this is a ProtectorMonster, choose its master as the target
        if (this instanceof ProtectorMonster) {
            return this.getMaster();
        }else{
            int targetIndex = RANDOM_TARGET.nextInt(potentialTargets.size());
            return potentialTargets.get(targetIndex);
        }


    }
    
}