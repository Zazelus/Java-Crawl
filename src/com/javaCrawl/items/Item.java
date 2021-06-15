package com.javaCrawl.items;

public abstract class Item {

	String name;
	String description;

	int quantity;
	int value;

	public Item(String name, String description, int quantity, int value) {
	}

	public abstract void use();

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public int getValue() {
		return this.value;
	}

}
