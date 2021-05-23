package com.javaCrawl.rooms;

import java.util.Random;

public class EmptyRoom extends Room {

	public static Random rand = new Random();

	public EmptyRoom() {

	}

	public void interact() {
		int random = rand.nextInt(5) + 1;

		printDelay();

		switch(random) {
		case 1:
			System.out.println("Entering a dusty and unkempt chamber with rusted equipment, you find nothing of note.");
			break;
		case 2:
			System.out.println("As you walk inside the next chamber, you are greeted by the stench of a roaming monster. "
					+ "You are safe for now, as you find yourself alone.");
			break;
		case 3:
			System.out.println("An unremarkable store room lies before you. Anything that you may find useful has long"
					+ " been looted.");
			break;
		case 4:
			System.out.println("Stepping into the next room, you find yourself at an abandoned rest area. Nothing was left"
					+ " behind, all that's left is to keep moving forward.");
			break;
		case 5:
			System.out.println("What looks to be an abandoned study or library lays ahead. Rotting bookshelves and old tomes"
					+ "are scattered across the floor. It's best to move on.");
			break;
/*		case 6:
			System.out.println();
			break;
		case 7:
			System.out.println();
			break;
		case 8:
			System.out.println();
			break;
		case 9:
			System.out.println();
			break;
		case 10:
			System.out.println();
			break;*/


		}

		printDelay();

	}

}
