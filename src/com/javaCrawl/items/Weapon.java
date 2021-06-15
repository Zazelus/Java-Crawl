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
public class Weapon extends Item {

    private String name;
    private String description;

    private int quantity;
    private int value;
    private int weaponDamage;

    private boolean equipped;

    public Weapon(String name, String description, int quantity, int value, int weaponDamage, boolean equipped) {
        super(name, description, quantity, value);

        this.weaponDamage = weaponDamage;
        this.equipped = equipped;
    }

    /*public void setName(String name) {
        this.name = name;
    }*/

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

	public void use() {
		equipped = true;
	}

}
