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

/*    public Monster(boolean dead) {
        this.dead = dead;
    }*/

    /**
     * Creates a new monster to fight the player.
     *
     * @param name The monster's name.
     * @param health The monster's health.
     * @param damage How much damage the monster deals.
     */
    public Monster(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    /**
     * Checks to see if the monster is dead.
     *
     * @return dead
     */
    public boolean isDead() {
        return dead;
    }

    /**
     * Sets the monster to be dead.
     *
     * @param dead
     */
    public void setDead(boolean dead) {
        this.dead = dead;
    }

    /**
     * Returns the monster's name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the monster's name to a new one.
     *
     * @param name is the new name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the monster's current health.
     *
     * @return health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Sets the monster's health to a new value.
     *
     * @param health is the new health value.
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Returns the monster's damaging ability.
     *
     * @return damage is the amount of damage they deal.
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Sets the monster's damage potential to a new value.
     *
     * @param damage is the new amount of damage they will deal.
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * Calculates a monster's attack rolls against the player.
     *
     * @param player
     */
    public void attack(Player player) {
    	int playerHealth = player.getHealth();
    	String playerName = player.getName();

        if (damage >= playerHealth || playerHealth <= 0) {
            System.out.println(playerName + " is dead!");

            player.setDead(true);
        }

        else {
            playerHealth -= damage;
            player.setHealth(playerHealth);

            System.out.println("The remaining life of " + playerName + " is: " + playerHealth);
        }
    }

}
