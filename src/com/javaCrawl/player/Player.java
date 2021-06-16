package com.javaCrawl.player;

import java.util.Scanner;

import com.javaCrawl.dungeons.FloorParser;
import com.javaCrawl.items.Item;
import com.javaCrawl.items.Weapon;
import com.javaCrawl.monster.Monster;
import com.javaCrawl.rooms.Room;

/**
 * Class representing the player. Used in combat etc.
 *
 * @author Zaezul
 *
 */
public class Player {


	/**
	 * Player Attributes
	 */
    private String name;

    /**
	 * Player stat variables, certain statistics are important for specific classes.
	 */
	private int str;
	private int dex;
	private int con;
	private int intl;
	private int wis;
	private int hitPoints;
	private int maxHitPoints;

	//public static PlayerClass playerClass = null;

	public static int statPoints = 25;
	public static int playerExp;

    private int floorLevel = 1;

    /**
     * Player Inventory
     */
    private Item[] equippedItems;
    private Item[] playerInventory;

    private int freeInvSlot = 0;

    // Using this weapon for testing.
    private static Weapon sword = new Weapon("Sword", null, 50, 0, 0, false);

    /**
     * Player Prompt
     */
    private static Scanner scan = new Scanner(System.in);

    /**
     * Player Movement
     */
	private static String[][] dungeonFloor;
	public static String[][] playerMap;

	private static int[] playerLocation = {0, 0};
	private static int x = playerLocation[0];
	private static int y = playerLocation[1];

	static int heightIdx;
	static int widthIdx;

	private static Room[][] populatedFloor;

	/**
	 * Booleans to track player states.
	 */
    private boolean dead = false;
    private boolean bossKey = false;

/*    public Player(boolean dead) {
        this.dead = dead;
    }*/

    /**
     * Creates a new player without the need for a dungeon floor or map.
     *
     * @param name The player's name.
     * @param health The player's health.
     * @param damage The amount of damage the player deals.
     */
    public Player(String name, int health) {
        this.name = name;
        this.hitPoints = health;
        this.maxHitPoints = health;
    }

    /**
     * Creates a new player.
     *
     * @param name The player's name.
     * @param health The player's health.
     * @param damage The amount of damage the player deals.
     * @param dungeonFloor The current dungeon floor.
     * @param playerMap The player's map of the dungeon floor.
     */
    public Player(String name, int health, int str, int dex, int con, int intl, int wis, String[][] dungeonFloor, String[][] playerMap) {
        this.name = name;
        this.hitPoints = health;
        this.maxHitPoints = health;
        this.str = str;
        this.dex = dex;
        this.con = con;
        this.intl = intl;
        this.wis = wis;

        equippedItems = new Item[6];
        equippedItems[0] = sword;
        playerInventory = new Item[30];

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

    /**
     * Returns the player's name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the player's name to a new one.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the player's current health.
     *
     * @return health
     */
    public int getHealth() {
        return hitPoints;
    }

    /**
     * Sets the player's health to a new value.
     *
     * @param health is the new health of player.
     */
    public void setHealth(int health) {
        this.hitPoints = health;
    }

/*    *//**
     * Returns the player's damage value.
     *
     * @return damage
     *//*
    public int getDamage() {
        return damage;
    }

    *//**
     * Sets the player's damage to a new value.
     *
     * @param damage is the new damage of the player.
     *//*
    public void setDamage(int damage) {
        this.damage = damage;
    }*/

    /**
     * Returns the player's maximum health.
     *
     * @return maxHealth
     */
    public int getMaxHealth() {
    	return maxHitPoints;
    }

    /**
     * Sets the player's maximum health to a new value.
     *
     * @param newHealth is the new maximum health.
     */
    public void setMaxHealth(int newHealth) {
    	maxHitPoints = newHealth;
    }

    /**
	 * Returns the player's current strength score.
	 *
	 * @return player's strength score.
	 */
	public int getStrength() {
		return str;
	}

	/**
	 * Modifies the strength score by a specific number.
	 *
	 * @param mod is how much the score will be modified by.
	 */
	public void modifyStrength(int mod) {
		str += mod;
	}

	/**
	 * Returns the player's current dexterity score.
	 *
	 * @return player's dexterity score.
	 */
	public int getDexterity() {
		return dex;
	}

	/**
	 * Modifies the dexterity score by a specific number.
	 *
	 * @param mod is how much the score will be modified by.
	 */
	public void modifyDexterity(int mod) {
		dex += mod;
	}

	/**
	 * Returns the player's current constitution score.
	 *
	 * @return player's constitution score.
	 */
	public int getConstitution() {
		return con;
	}

	/**
	 * Modifies the constitution score by a specific number.
	 *
	 * @param mod is how much the score will be modified by.
	 */
	public void modifyConstitution(int mod) {
		con += mod;
	}

	/**
	 * Returns the player's current intelligence score.
	 *
	 * @return player's intelligence score.
	 */
	public int getIntelligence() {
		return intl;
	}

	/**
	 * Modifies the intelligence score by a specific number.
	 *
	 * @param mod is how much the score will be modified by.
	 */
	public void modifyIntelligence(int mod) {
		intl += mod;
	}

	/**
	 * Returns the player's current wisdom score.
	 *
	 * @return player's wisdom score.
	 */
	public int getWisdom() {
		return wis;
	}

	/**
	 * Modifies the wisdom score by a specific number.
	 *
	 * @param mod is how much the score will be modified by.
	 */
	public void modifyWisdom(int mod) {
		wis += mod;
	}

	/**
	 * Resets player skills to standard array.
	 */
	public void skillReset() {
		str = 10;
		dex = 10;
		con = 10;
		wis = 10;
		intl = 10;
	}

	/**
	 * Gives the modifier for the current ability score.
	 *
	 * @param abilityScore is the ability score to calculate the modifier for.
	 * @return the modifier for the ability score.
	 */
	public static int abilityModifer(int abilityScore) {
		return (int) Math.floor((float) (abilityScore - 10) / 2);
	}

    /**
     * Returns the items that player has equipped.
     *
     * @return equippedItems
     */
    public Item[] getPlayerEquipment() {
    	return equippedItems;
    }

    /**
     * Returns the items in player inventory.
     *
     * @return playerInventory
     */
    public Item[] getPlayerInventory() {
    	return playerInventory;
    }

    /**
     * Picks up the current argument as an item and puts it into
     * the player's inventory.
     *
     * @param item is the item to be picked up.
     */
    public void pickUpItem(Item item) {
    	if (freeInvSlot < playerInventory.length) {
    		playerInventory[freeInvSlot] = item;
    	}

    	else {
    		System.out.println("\nPlayer inventory is full!");
    	}
    }

    /**
     * Checks to see if the player is dead.
     *
     * @return dead
     */
    public boolean isDead() {
        return dead;
    }

    /**
     * Sets the player to a dead state.
     *
     * @param dead
     */
    public void setDead(boolean dead) {
        this.dead = dead;
    }

    /**
     * Checks to see if the player has a key to the boss room.
     * Used to traverse to the next floor.
     *
     * @return bossKey
     */
    public boolean hasBossKey() {
    	return bossKey;
    }

    /**
     * If the player enters the key room and grabs the key, they
     * will be able to access the boss room.
     */
    public void gainsBossKey() {
    	bossKey = true;
    }

    /**
     * Calculates the player's attack roll against the enemy monster.
     *
     * @param monster is the monster to be attacked.
     */
    public void attack(Monster monster) {
    	Weapon playerWeapon = (Weapon) equippedItems[0];
    	int damageAmount = playerWeapon.getWeaponDamage();

    	String monsterName = monster.getName();
    	int monsterHealth = monster.getHealth();

        if (damageAmount >= monsterHealth || monsterHealth <= 0) {
            System.out.println(monsterName + " is dead!");

            monster.setDead(true);
        }
        else {
            monsterHealth -= damageAmount;
            monster.setHealth(monsterHealth);

            System.out.println("The remaining life of " + monsterName + " is: " + monsterHealth);

            //System.out.println("Your remaining HP: "+ myHealth);
        }
    }

    //Player Movement Control

    public void move() {
    	movePlayer();
    }

    /**
     * Goes up as the player descends the dungeon.
     */
    public void updateFloor() {
    	floorLevel++;
    }

    /**
     * Returns the current floor the player is on.
     *
     * @return floorLevel
     */
    public int getFloor() {
    	return floorLevel;
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
