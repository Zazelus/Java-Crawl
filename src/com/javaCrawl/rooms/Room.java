package com.javaCrawl.rooms;

import com.javaCrawl.art.FlavorText;

public abstract class Room {

	public abstract void interact();
	public abstract boolean explored();
	public void printDelay() {
		try {
			FlavorText.printWithDelays("...", 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};

}
