package com.javaCrawl.items;

public class Item {

	String name;
	String description;

	int quantity;
	int value;

	public Item(String name, String description, int quantity, int value) {
		this.name = name;
		this.description = description;

		this.quantity = quantity;
		this.value = value;
	}

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
