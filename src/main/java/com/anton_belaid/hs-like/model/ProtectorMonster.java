package com.anton_belaid.hs_like.model;

import com.anton_belaid.hs_like.utils.LoggerUtils;

public class ProtectorMonster extends Monster {

    public ProtectorMonster(String id, String name, int healthPoints, int attackPoints) {
        super(id, name, healthPoints, attackPoints, false, 0, false, 0, false);
    }

    @Override
    public void attack(Playable target) {
        // The ProtectorMonster protects the target only if the target is its Champion
        if (this.getMaster().equals(target) && this.getMaster().isProtected() == false){
            target.setProtected(true);
            target.setProtector(this);
        } else {
            LoggerUtils.log("A ProtectorMonster can only protect unprotected targets");
            System.out.println("A ProtectorMonster can only protect unprotected targets.");
        }
    }

}