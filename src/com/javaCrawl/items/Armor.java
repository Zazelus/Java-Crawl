package com.javaCrawl.items;

/**
 * Represents armor that the player can equip. Players may have certain restrictions for certain
 * armors and the armorClass value is used for combat.
 *
 * @author Zaezul
 *
 */
public class Armor extends Equipment {

	private int armorClass;

	/**
	 * Creates a new Armor object.
	 *
	 * @param name Name of the armor.
	 * @param description A corresponding description.
	 * @param quantity How many the player is given.
	 * @param value The gold piece value of the armor.
	 * @param equipped Is this armor equipped to the player.
	 * @param armorClass The armor class of the specific piece.
	 */
	public Armor(String name, String description, int quantity, int value, boolean equipped, int armorClass) {
		super(name, description, quantity, value, equipped);

		this.armorClass = armorClass;
	}

	/**
	 * Gets the value of player AC.
	 *
	 * @return integer value of player's armor class
	 */
	public int getArmorClass() {
		return armorClass;
	}

}
