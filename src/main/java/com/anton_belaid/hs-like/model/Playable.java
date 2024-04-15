package com.anton_belaid.hs_like.model;

public abstract class Playable {
    protected String id;
    protected String name;
    protected int healthPoints;
    protected boolean isProtected = false;
    protected Monster protector = null;
    protected Champion master;
    protected int attackPower;
    protected boolean hasHealed;
    protected int healValue;
    protected boolean hasAttackBoost;
    protected int attackBoostValue;


    public Playable(String id, String name, int healthPoints, int attackPower, boolean hasHealed, int healValue, boolean hasAttackBoost, int attackBoostValue, boolean isProtected) {
        this.id = id;
        this.name = name;
        this.healthPoints = healthPoints;
        this.attackPower = attackPower;
        this.hasHealed = hasHealed;
        this.healValue = healValue;
        this.hasAttackBoost = hasAttackBoost;
        this.attackBoostValue = attackBoostValue;
        this.isProtected = isProtected;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
    
    public void reduceHealth(int amount) {
        // Reduce the Playable's health points by the specified amount
        this.healthPoints -= amount;
    
        // Make sure health points never go below 0
        if (this.healthPoints < 0) {
            this.healthPoints = 0;
        }
    }

    public void increaseHealthPoints(int amount) {
        // Increase the health points by the specified amount
        this.healthPoints += amount;
    }

    public void increaseAttackPower(int boostPower) {
        this.attackPower += boostPower;
    }

    public String getType() {
        //get the object type
        return this.getClass().getSimpleName();
    
    }
    
    public void setProtected(boolean isProtected) {
        this.isProtected = isProtected;
    }

    public boolean isProtected() {
        return this.isProtected;
    }

    public void setProtector(Monster protector) {
        this.protector = protector;
    }

    public Monster getProtector() {
        return this.protector;
    }

    public Champion getMaster() {
        return this.master;
    }

    public void setMaster(Champion master) {
        this.master = master;
    }

    public boolean hasHealed() {
        return this.hasHealed;
    }

    public void setHealed(boolean hasHealed) {
        this.hasHealed = true;
    }

    public int getHealValue() {
        return this.healValue;
    }

    public void setHealValue(int healValue) {
        this.healValue += healValue;
    }

    public boolean hasAttackBoost() {
        return this.hasAttackBoost;
    }

    public void setAttackBoost(boolean hasAttackBoost) {
        this.hasAttackBoost = true;
    }

    public int getAttackBoostValue() {
        return this.attackBoostValue;
    }

    public void setAttackBoostValue(int attackBoostValue) {
        this.attackBoostValue += attackBoostValue;
    }
}   
