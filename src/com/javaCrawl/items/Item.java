package com.javaCrawl.items;

/**
 * Items that the player will carry in the inventory.
 * Found, looted or bought.
 *
 * @author Zaezul
 *
 */
public class Item {

	String name;
	String description;

	int quantity;
	int value;

	/**
	 * Creates a new Item object.
	 *
	 * @param name Name of the item.
	 * @param description A corresponding description.
	 * @param quantity How many the player is given.
	 * @param value The gold piece value of the item.
	 */
	public Item(String name, String description, int quantity, int value) {
		this.name = name;
		this.description = description;

		this.quantity = quantity;
		this.value = value;
	}

	/**
	 * The item's name.
	 *
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The item's description.
	 *
	 * @return description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * The amount of items in the stack.
	 *
	 * @return quantity
	 */
	public int getQuantity() {
		return this.quantity;
	}

	/**
	 * The value of this item.
	 *
	 * @return value
	 */
	public int getValue() {
		return this.value;
	}

}
