package com.javaCrawl.items;

public class Equipment extends Item {

	private boolean equipped;

	public Equipment(String name, String description, int quantity, int value, boolean equipped) {
		super(name, description, quantity, value);
	}

	public void equip() {
		equipped = true;
	}

	public boolean isEquipped() {
		return equipped;
	}

}
