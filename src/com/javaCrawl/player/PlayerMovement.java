package com.javaCrawl.player;

import java.util.Scanner;

import com.javaCrawl.dungeons.FloorParser;
import com.javaCrawl.rooms.Room;

public class PlayerMovement {

	private static Scanner scan = new Scanner(System.in);

	/**
	 * Static variables used to deal with player movement.
	 */
	private static String[][] dungeonFloor;
	public static String[][] playerMap;

	private static int[] playerLocation = {0, 0};
	private static int x = playerLocation[0];
	private static int y = playerLocation[1];

	static int heightIdx;
	static int widthIdx;

	private static Room[][] populatedFloor;

	public PlayerMovement(String[][] dungeonFloor, String[][] playerMap, Player player) {
		PlayerMovement.dungeonFloor = dungeonFloor;
		PlayerMovement.playerMap = playerMap;

		heightIdx = dungeonFloor.length - 1;
		widthIdx = dungeonFloor[0].length - 1;

		try {
			populatedFloor = FloorParser.parseFloorData(player, this, dungeonFloor, player.getFloor());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Prints out a char array, which will usually be used for the game map.
	 * This is mostly for the player's convenience.
	 * @param map is a char array that represents a dungeon or particular area.
	 */
	public static void printMap(String[][] map) {
		for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
	}

	/**
	 * Moves the player a tile up on the map unless they are on an edge.
	 */
	public static void moveNorth() {
		if (y > 0) {
			playerLocation[1]--;
			y--;

			revealSurroundings();
			printMap(playerMap);
			parseRoom();
		}

		else {
			wallAhead();
		}
	}

	/**
	 * Moves the player a tile right on the map unless they are on an edge.
	 */
	public static void moveEast() {
		if (x < widthIdx) {
			playerLocation[0]++;
			x++;

			revealSurroundings();
			printMap(playerMap);
			parseRoom();
		}

		else {
			wallAhead();
		}
	}

	/**
	 * Moves the player a tile down on the map unless they are on an edge.
	 */
	public static void moveSouth() {
		if (y < heightIdx) {
			playerLocation[1]++;
			y++;

			revealSurroundings();
			printMap(playerMap);
			parseRoom();
		}

		else {
			wallAhead();
		}
	}

	/**
	 * Moves the player a tile left on the map unless they are on an edge.
	 */
	public static void moveWest() {
		if (x > 0) {
			playerLocation[0]--;
			x--;

			revealSurroundings();
			printMap(playerMap);
			parseRoom();
		}

		else {
			wallAhead();
		}
	}

	/**
	 * Makes the player choose a different direction if they encounter a map edge.
	 */
	public static void wallAhead() {
		System.out.println("There is a wall ahead, you must choose a different path.");
		movePlayer();
	}

	/**
	 * Control for player's direction.
	 */
	public static void movePlayer() {
		printMap(playerMap);

		System.out.println("\nWhich direction will you go?\n");

		System.out.println("\n1. North");
		System.out.println("2. East");
		System.out.println("3. South");
		System.out.println("4. West");

		String input = scan.nextLine();

		switch(input) {
			case "1":
				moveNorth();
				break;
			case "2":
				moveEast();
				break;
			case "3":
				moveSouth();
				break;
			case "4":
				moveWest();
				break;
			default:
				moveSouth();
		}
	}

	/**
	 * Reveals tiles/rooms immediately around the player as they move into a new spot.
	 */
	public static void revealSurroundings() {
		// Update NW
		if ((x > 0 && y > 0))
			playerMap[y-1][x-1] = dungeonFloor[y-1][x-1];
		// Update N
		if (y > 0)
			playerMap[y-1][x] = dungeonFloor[y-1][x];
		// Update NE
		if (y < heightIdx && x > 0)
			playerMap[y-1][x+1] = dungeonFloor[y-1][x+1];
		// Update W
		if (x > 0)
			playerMap[y][x-1] = dungeonFloor[y][x-1];
		// Update E
		if (x < widthIdx)
			playerMap[y][x+1] = dungeonFloor[y][x+1];
		// Update SW
		if (x > 0 && y < heightIdx)
			playerMap[y+1][x-1] = dungeonFloor[y+1][x-1];
		// Update S
		if (y < heightIdx)
			playerMap[y+1][x] = dungeonFloor[y+1][x];
		// Update SE
		if (y < dungeonFloor.length && x < widthIdx)
			playerMap[y+1][x+1] = dungeonFloor[y+1][x+1];

		playerMap[y][x] = "P";
	}

	/**
	 * Calls the appropriate event based on what type of room the player has moved into.
	 */
	private static void parseRoom() {
		populatedFloor[y][x].interact();
	}

}
