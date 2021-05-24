package com.javaCrawl.rooms;

import com.javaCrawl.player.Player;
import com.javaCrawl.player.PlayerMovement;

public class TrapRoom extends Room {

	//private static Player player;
	private static PlayerMovement movement;
	//private static int floorNumber;

	public TrapRoom(Player player, PlayerMovement movement, int floorNumber) {
		//TrapRoom.player = player;
		TrapRoom.movement = movement;
		//TrapRoom.floorNumber = floorNumber;
	}

	public void interact() {
		// Print text describing trap room.
		// Print player choices i.e. walk, disarm, evade, flee.
		// Switch according to floorNumber and make it a random trap.
		movement.movePlayer();
	}

	@Override
	public boolean explored() {
		// TODO Auto-generated method stub
		return false;
	}

}
