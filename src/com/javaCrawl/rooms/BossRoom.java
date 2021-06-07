package com.javaCrawl.rooms;

import com.javaCrawl.monster.Monster;
import com.javaCrawl.player.Player;

public class BossRoom extends Room {

	//private static Player player;
	//private static PlayerMovement movement;
	//private static int floorNumber;

	public static Monster goblinChief = new Monster("Goblin Chieftan", 500, 100);

	public BossRoom(Player player, int floorNumber) {
		//BossRoom.player = player;
		//BossRoom.floorNumber = floorNumber;
	}

	public void interact() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean explored() {
		// TODO Auto-generated method stub
		return false;
	}

}
