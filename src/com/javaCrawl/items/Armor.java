package com.javaCrawl.items;

public class Armor extends Equipment {

	private int armorClass;

	public Armor(String name, String description, int quantity, int value, boolean equipped, int armorClass) {
		super(name, description, quantity, value, equipped);

		this.armorClass = armorClass;
	}

	public int getArmorClass() {
		return armorClass;
	}

}
