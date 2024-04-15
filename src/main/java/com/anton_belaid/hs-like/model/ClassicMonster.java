package com.anton_belaid.hs_like.model;

public class ClassicMonster extends Monster {

    public ClassicMonster(String id, String name, int healthPoints, int attackPower) {
        super(id, name, healthPoints, attackPower, false, 0, false, 0, false);
    }

    // Constructor that accepts a Card object
    public ClassicMonster(Card card) {
        super(card);
    }

    //ClassicMonster always want to attack, you can do:
    @Override
    public boolean wantsToAttack() {
        return true;
    }
}