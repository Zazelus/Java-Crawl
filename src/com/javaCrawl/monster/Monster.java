package com.javaCrawl.monster;

import com.javaCrawl.player.Player;

/**
 * Class representing various monsters that will be faced in combat.
 *
 * Will eventually be an interface or abstract class as there will be
 * 'types' of monsters.
 *
 * @author Zaezul
 *
 */
public class Monster {

	private String name;

    private int health;
    private int damage;

    private boolean dead = false;

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public Monster(boolean dead) {
        this.dead = dead;
    }

    public Monster(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
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

    public void attack(int damageAmount, Player player) {
    	int playerHealth = player.getHealth();
    	String playerName = player.getName();

        if (damageAmount >= playerHealth || playerHealth <= 0) {
            System.out.println(playerName + " is dead!");

            player.setDead(true);
        }

        else {
            playerHealth -= damageAmount;
            player.setHealth(playerHealth);

            System.out.println("The remaining life of " + playerName + " is: " + playerHealth);
        }
    }

}
