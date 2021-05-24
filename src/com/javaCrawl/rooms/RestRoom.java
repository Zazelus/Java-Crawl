package com.javaCrawl.rooms;

import java.util.Scanner;

import com.javaCrawl.player.Player;
import com.javaCrawl.player.PlayerMovement;

public class RestRoom extends Room {

	private Scanner scan = new Scanner(System.in);

	private static Player player;
	private static PlayerMovement movement;
	//private static int floorNumber;

	public RestRoom(Player player, PlayerMovement movement, int floorNumber) {
		RestRoom.player = player;
		RestRoom.movement = movement;
		//RestRoom.floorNumber = floorNumber;
	}

	public void interact() {

		printDelay();

		System.out.println("\n The light and warmth of a recently lit campfire greets your weary eyes. Along with the supplies, it would make a great"
				+ " place to rest.");

		printDelay();

		System.out.println("\n Would you like to rest?");
		System.out.println("\n1. Yes");
		System.out.println("2. No");

		int choice = scan.nextInt();

		if (choice == 1) {
			player.setHealth(player.getMaxHealth());
			// room.setExplored();
		}
		else {
			// Room is not explored, player may come back and rest here.
		}


		printDelay();

		movement.movePlayer();
	}

	@Override
	public boolean explored() {
		// TODO Auto-generated method stub
		return false;
	}

}
