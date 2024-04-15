package com.anton_belaid.hs_like.model;

import com.anton_belaid.hs_like.utils.LoggerUtils;

public class HealerMonster extends Monster {
    private int healingPower;

    public HealerMonster(String id, String name, int healthPoints, int attackPower) {
        super(id, name, healthPoints, attackPower, false, 0, false, 0, false);
        this.healingPower = attackPower;
    }


    @Override
    public void attack(Playable target) {
        // The HealerMonster heals the target only if the target is in its Champion team
        if (this.getMaster().equals(target.getMaster())) {
            target.increaseHealthPoints(healingPower);
            if (target instanceof Monster) {
                ((Monster) target).setHealed(true);
                ((Monster) target).setHealValue(healingPower);
            } else if (target instanceof Champion) {
                ((Champion) target).setHealed(true);
                ((Champion) target).setHealValue(healingPower);
            }
        } else {
            LoggerUtils.log("A HealerMonster can only heal its own Champion.");
            System.out.println("A HealerMonster can only heal its own Champion.");
        }
    }

    public int getHealBoost() {
        return healingPower;
    }
}