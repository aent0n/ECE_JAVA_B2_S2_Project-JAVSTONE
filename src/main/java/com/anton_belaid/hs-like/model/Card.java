package com.anton_belaid.hs_like.model;

public class Card {
    private String id;
    private String name;
    private Monster monster;

    public Card(String id, String name, Monster monster) {
        this.id = id;
        this.name = name;
        this.monster = monster;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Monster getMonster() {
        return monster;
    }

    public int getHealthPoints() {
        return monster.getHealthPoints();
    }

    public void setHealthPoints(int healthPoints) {
        monster.setHealthPoints(healthPoints);
    }

    public int getAttackPower() {
        return monster.getAttackPower();
    }

    public void setAttackPower(int attackPower) {
        monster.setAttackPower(attackPower);
    }
}