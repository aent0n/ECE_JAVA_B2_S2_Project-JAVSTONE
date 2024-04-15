package com.anton_belaid.hs_like.model;

public class SpecialAbility {
    private String name;
    private String description;
    private int attackPoints;

    public SpecialAbility(String name, String description, int attackPoints) {
        this.name = name;
        this.description = description;
        this.attackPoints = attackPoints;
    }

    // getters and setters for name and description

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAttackPoints() {
        return this.attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }
}