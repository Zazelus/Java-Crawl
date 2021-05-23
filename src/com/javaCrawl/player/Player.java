package com.javaCrawl.player;

/**
 * Class representing the player. Used in combat etc.
 *
 * @author Zaezul
 *
 */
public class Player {

    private String name;

    private int maxHealth;
    private int health;
    private int damage;
    private int floorLevel = 1;

    private boolean dead = false;
    private boolean bossKey = false;

    public Player(boolean dead) {
        this.dead = dead;
    }

    public Player(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.maxHealth = health;
    }

    public int getMaxHealth() {
    	return maxHealth;
    }

    public void setMaxHealth(int newHealth) {
    	maxHealth = newHealth;
    }

    public void updateFloor() {
    	floorLevel++;
    }

    public int getFloor() {
    	return floorLevel;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean hasBossKey() {
    	return bossKey;
    }

    public void gainsBossKey() {
    	bossKey = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void attack(int damageAmount, int myHealth) {
        if (damageAmount >= this.health || myHealth <= 0) {
            System.out.println(this.name + " is dead!");

            this.dead = true;
        } else {
            this.health -= damageAmount;

            System.out.println("The remaining life of " + this.name + " is: " + this.health);

            //System.out.println("Your remaining HP: "+ myHealth);
        }
    }

}
