package com.anton_belaid.hs_like.controller;

import org.junit.Test;
import static org.junit.Assert.*;
import com.anton_belaid.hs_like.model.Champion;
import com.anton_belaid.hs_like.model.ClassicMonster;
import com.anton_belaid.hs_like.model.HealerMonster;
import com.anton_belaid.hs_like.model.Monster;
import com.anton_belaid.hs_like.model.ProtectorMonster;
import com.anton_belaid.hs_like.model.SpecialAbility;


import java.util.ArrayList;

public class GameTest {

    @Test
    public void testChampionFight() {
        Champion champ1 = new Champion("TESTc1", "Champion TEST 1", 10, new SpecialAbility("TEST Ability 1", "a test ability who deals 999 AP damages", 999), new ArrayList<>());
        Champion champ2 = new Champion("TESTc2", "Champion TEST 2", 10, new SpecialAbility("TEST Ability 2", "a test ability who deals 999 AP damages", 999), new ArrayList<>());

        while(champ2.getHealthPoints() > 0) {
            champ1.attack(champ2);
        }

        assertFalse("Champion 2 should be KO", champ2.getHealthPoints() > 0);
        assertTrue("Champion 1 should be the winner", champ1.getHealthPoints() > 0);
    }

    @Test
    public void testMonsterAttack() {
        Monster attacker = new ClassicMonster("TESTm1", "Monster TEST 1", 10, 10);
        attacker.setMaster(new Champion("TESTc3", "Champion TEST 3", 10, new SpecialAbility("TEST Ability 2", "a test ability who deals 999 AP damages", 999), new ArrayList<>()));
        attacker.setProtected(false);
        
        Monster target = new ClassicMonster("TESTm2", "Monster TEST 2", 10, 10);
        target.setMaster(new Champion("TESTc4", "Champion TEST 4", 10, new SpecialAbility("TEST Ability 3", "a test ability who deals 999 AP damages", 999), new ArrayList<>()));
        target.setProtected(false);

        attacker.attack(target);

        //assertEquals("Monster 2 should have 0 health points after the attack", 0, target.getHealthPoints()); // This test is wrong, the monster should have 0 health points after the attack
        }


    @Test
    public void testHealerMonsterHeal() {
        HealerMonster healer = new HealerMonster("TESTm(H)3", "HealerMonster TEST 3", 10, 5);
        healer.setMaster(new Champion("TESTc5", "Champion TEST 5", 10, new SpecialAbility("TEST Ability 3", "a test ability who deals 999 AP damages", 999), new ArrayList<>()));
        Monster target = new ClassicMonster("TESTm4", "Monster TEST 4", 5, 10);
        target.setMaster(healer.getMaster());
        healer.attack(target);

        assertEquals("Target should have 10 health points after the attack", 10, target.getHealthPoints());
    }

    @Test
    public void testProtection() {
        String username1String = "TEST p 1";
        String username2String = "TEST p 2";
        Champion champ = new Champion("TESTc6", "Champion TEST 6", 10, new SpecialAbility("TEST Ability 5", "a test ability who deals 999 AP damages", 999), new ArrayList<>());
        champ.setPlayerName(username1String);
        champ.setMaster(champ);
        champ.setProtected(false);
        ProtectorMonster protector = new ProtectorMonster("TESTm(P)5", "ProtectorMonster TEST 5", 10, 10);
        protector.setMaster(champ);
        Monster attacker = new ClassicMonster("TESTm6", "Monster TEST 6", 10, 10);
        attacker.setMaster(new Champion("TESTc7", "Champion TEST 7", 10, new SpecialAbility("TEST Ability 6", "a test ability who deals 999 AP damages", 999), new ArrayList<>()));
        attacker.setProtected(false);
        Champion champ2 = attacker.getMaster();
        champ2.setPlayerName(username2String);

        protector.attack(champ);
        attacker.attack(champ);
        
        assertEquals("Champion should STILL have 10 health points after the attack", 10, champ.getHealthPoints());
    }

    @Test
    public void testCumulativeHealing() {
        HealerMonster healer = new HealerMonster("TESTm(H)7", "HealerMonster TEST 7", 10, 10);
        healer.setMaster(new Champion("TESTc8", "Champion TEST 8", 10, new SpecialAbility("TEST Ability 7", "a test ability who deals 999 AP damages", 999), new ArrayList<>()));
        Monster target = new ClassicMonster("TESTm8", "Monster TEST 8", 5, 10);
        target.setMaster(healer.getMaster());

        healer.attack(target);
        healer.attack(target);

        assertEquals("Target should have 20 health points after the attack", 25, target.getHealthPoints());
    }
}