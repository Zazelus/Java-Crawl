package com.javaCrawl.items;

/**
 * Items that the player may equip on their person.
 * Extends the Item class.
 *
 * @author Zaezul
 *
 */
public class Equipment extends Item {

	private boolean equipped;

	/**
	 * Creates a new Equipment object.
	 *
	 * @param name Name of the equipment.
	 * @param description A corresponding description.
	 * @param quantity How many the player is given.
	 * @param value The gold piece value of the equipment.
	 * @param equipped Is this equipment equipped to the player.
	 */
	public Equipment(String name, String description, int quantity, int value, boolean equipped) {
		super(name, description, quantity, value);
	}

	/**
	 * Equips the player with this item.
	 */
	public void equip() {
		equipped = true;
	}

	/**
	 * Checks to see if the player has an item equipped.
	 *
	 * @return equipped to check
	 */
	public boolean isEquipped() {
		return equipped;
	}

}
