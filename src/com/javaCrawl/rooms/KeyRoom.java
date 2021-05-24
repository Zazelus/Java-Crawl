package com.javaCrawl.rooms;

import com.javaCrawl.art.FlavorText;
import com.javaCrawl.player.Player;
import com.javaCrawl.player.PlayerMovement;

public class KeyRoom extends Room {

	private static Player player;
	private static PlayerMovement movement;

	public KeyRoom(Player player, PlayerMovement movement) {
		KeyRoom.player = player;
		KeyRoom.movement = movement;
	}

	public void interact() {

		printDelay();

		System.out.println("You make your way into the next room. In front of you lays an ancient stone pedestal with a mysteriously engraved key,"
				+ " beset with an eerie gem glowing red.");
		System.out.println("\nPocketing the key, you move onwards.");

		try {
			FlavorText.printWithDelays("...", 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("\nItem Acquired: Skeleton Key");

		player.gainsBossKey();

		printDelay();

		movement.movePlayer();
	}

	@Override
	public boolean explored() {
		// TODO Auto-generated method stub
		return false;
	}

}
