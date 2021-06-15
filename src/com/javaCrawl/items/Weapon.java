package com.javaCrawl.items;

/**
 * The weapon class.
 *
 * Will be made abstract or into an interface as different weapon 'types' will
 * be needed.
 *
 * @author Zaezul
 *
 */
public class Weapon extends Equipment {

    private int weaponDamage;

    /**
	 * Creates a new Equipment object.
	 *
	 * @param name Name of the weapon.
	 * @param description A corresponding description.
	 * @param quantity How many the player is given.
	 * @param value The gold piece value of the weapon.
	 * @param weaponDamage The amount of damage this weapon can deal in combat.
	 * @param equipped Is this weapon equipped to the player.
	 */
    public Weapon(String name, String description, int quantity, int value, int weaponDamage, boolean equipped) {
        super(name, description, quantity, value, equipped);

        this.weaponDamage = weaponDamage;
    }

    /*public void setName(String name) {
        this.name = name;
    }*/

    /**
     * Returns the value of the current weapon's damaging ability.
     * @return weaponDamage
     */
    public int getWeaponDamage() {
        return weaponDamage;
    }

    /**
     * Sets the current weapon's damage to a new value.
     * @param weaponDamage
     */
    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

}
