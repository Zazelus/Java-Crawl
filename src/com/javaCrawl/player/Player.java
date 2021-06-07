package com.javaCrawl.player;

import java.util.Scanner;

import com.javaCrawl.dungeons.FloorParser;
import com.javaCrawl.rooms.Room;

/**
 * Class representing the player. Used in combat etc.
 *
 * @author Zaezul
 *
 */
public class Player {

    private String name;


    // Player Attributes
    private int maxHealth;
    private int health;
    private int damage;
    private int floorLevel = 1;

    // Player Movement
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

    private boolean dead = false;
    private boolean bossKey = false;

    public Player(boolean dead) {
        this.dead = dead;
    }

    public Player(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.maxHealth = health;
    }

    public Player(String name, int health, int damage, String[][] dungeonFloor, String[][] playerMap) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.maxHealth = health;

        Player.dungeonFloor = dungeonFloor;
        Player.playerMap = playerMap;

        heightIdx = dungeonFloor.length - 1;
		widthIdx = dungeonFloor[0].length - 1;

		try {
			populatedFloor = FloorParser.parseFloorData(this, dungeonFloor, this.getFloor());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


    public void move() {
    	movePlayer();
    }

    public int getMaxHealth() {
    	return maxHealth;
    }

    public void setMaxHealth(int newHealth) {
    	maxHealth = newHealth;
    }

    public void updateFloor() {
    	floorLevel++;
    }

    public int getFloor() {
    	return floorLevel;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean hasBossKey() {
    	return bossKey;
    }

    public void gainsBossKey() {
    	bossKey = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void attack(int damageAmount, int myHealth) {
        if (damageAmount >= this.health || myHealth <= 0) {
            System.out.println(this.name + " is dead!");

            this.dead = true;
        } else {
            this.health -= damageAmount;

            System.out.println("The remaining life of " + this.name + " is: " + this.health);

            //System.out.println("Your remaining HP: "+ myHealth);
        }
    }

    //Player Movement Control

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
