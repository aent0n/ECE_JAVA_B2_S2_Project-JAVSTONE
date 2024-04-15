package com.anton_belaid.hs_like.model;

import com.anton_belaid.hs_like.utils.LoggerUtils;

public class MascottMonster extends Monster {
    private int boostPower;

    public MascottMonster(String id, String name, int healthPoints, int attackPower) {
        super(id, name, healthPoints, attackPower, false, 0, false, 0, false);
        this.boostPower = attackPower;
    }

    @Override
    public void attack(Playable target) {

        if (this.getMaster().equals(target.getMaster())) {
            // Increase the attackPower of the target
            target.setAttackPower(target.getAttackPower() + boostPower);
            if (target instanceof Monster) {
                ((Monster) target).setAttackBoost(true);
                ((Monster) target).setAttackBoostValue(boostPower);
            } else if (target instanceof Champion) {
                ((Champion) target).setAttackBoost(true);
                ((Champion) target).setAttackBoostValue(boostPower);
            }
            // Log the action
            LoggerUtils.log(getName() + " has increased " + target.getName() + "'s attack power by " + boostPower + "!");
            System.out.println(getName() + " has increased " + target.getName() + "'s attack power by " + boostPower + "!");
        } else {
            LoggerUtils.log("A MascottMonster can only boost a monster of its own team.");
            System.out.println("A MascottMonster can only boost a monster of its own team.");
        }
    }

    public int getBoostPower() {
        return boostPower;
    }
}