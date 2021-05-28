package com.javaCrawl.rooms;

import com.javaCrawl.player.Player;

public class TreasureRoom extends Room {

	private static Player player;
	//private static int floorNumber;

	public TreasureRoom(Player player, int floorNumber) {
		TreasureRoom.player = player;
		//TreasureRoom.movement = movement;
		//TreasureRoom.floorNumber = floorNumber;
	}

	public void interact() {
		// TODO Auto-generated method stub
		player.move();
	}

	@Override
	public boolean explored() {
		// TODO Auto-generated method stub
		return false;
	}

}
