import java.util.Scanner;

/**
 * Runs the game and handles a lot of the program's overall functionality.
 * As the project is updated, more tasks will be offloaded to other helper classes
 * in order to streamline ProtoMain and the rest of the project.
 *
 * TODO: Move all functionality outside of main to other classes.
 * TODO: Make a save/load game system inside of main.
 *
 * @author Zaezul
 * @version 05.17.2021
 *
 */
public class GameRunner {

	private static Scanner scan = new Scanner(System.in);

	/**
	 * Static variables used to deal with player movement.
	 */
	private static char[][] dungeonFloor;
	public static char[][] playerMap;
	private static int[] playerLocation = {2, 2};
	private static int x = playerLocation[0];
	private static int y = playerLocation[1];

	/*public static String playerName;
	public static int playerHp;
	public static int playerDamage;
	public static int playerGold = 0;
	public static int playerPotions = 0;
	public static Object[] playerInventory;*/

	public static void main(String[] args) {
		dungeonFloor = new char[][] {
				{'T', 'E', 'M', 'M', 'E'},
				{'!', 'M', '!', 'T', 'M'},
				{'E', 'R', 'S', 'E', 'T'},
				{'R', 'K', 'E', '!', 'M'},
				{'M', 'T', 'B', 'E', 'T'}
		};

		playerMap = new char[][] {
				{'?', '?', '?', '?', '?'},
				{'?', '?', '?', '?', '?'},
				{'?', '?', 'P', '?', '?'},
				{'?', '?', '?', '?', '?'},
				{'?', '?', '?', '?', '?'}
		};


		System.out.println("You enter the dungeon...\n");
		System.out.println("You are represented as P on the map below. \n");
		printMap(playerMap);

		System.out.println("\nWhich direction will you go?\n");

		movePlayer();
	}

	/**
	 * Prints out a char array, which will usually be used for the game map.
	 * This is mostly for the player's convenience.
	 * @param map is a char array that represents a dungeon or particular area.
	 */
	public static void printMap(char[][] map) {
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
		if (playerLocation[0] > 0) {
			playerLocation[0]--;
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
		if (playerLocation[1] < dungeonFloor.length) {
			playerLocation[1]++;
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
		if (playerLocation[0] < dungeonFloor[0].length) {
			playerLocation[0]++;
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
		if (playerLocation[1] > 0) {
			playerLocation[1]--;
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
		System.out.println("1. North");
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
		if (x > 0 )
			playerMap[y][x-1] = dungeonFloor[y][x-1];
		// Update NE
		if (y < dungeonFloor.length && x > 0)
			playerMap[y+1][x-1] = dungeonFloor[y+1][x-1];
		// Update W
		if (y > 0)
			playerMap[y-1][x] = dungeonFloor[y-1][x];
		// Update E
		if (y < dungeonFloor.length)
			playerMap[y+1][x] = dungeonFloor[y+1][x];
		// Update SW
		if (y > 0 && x < dungeonFloor[0].length)
			playerMap[y-1][x+1] = dungeonFloor[y-1][x+1];
		// Update S
		if (x < dungeonFloor[0].length)
			playerMap[y][x+1] = dungeonFloor[y][x+1];
		// Update SE
		if (y < dungeonFloor.length && x < dungeonFloor[0].length)
			playerMap[y+1][x+1] = dungeonFloor[y+1][x+1];

		playerMap[y][x] = 'P';
	}

	/**
	 * Calls the appropriate event based on what type of room the player has moved into.
	 */
	private static void parseRoom() {
		switch (dungeonFloor[y][x]) {
			case 'S':
				System.out.println("This is the entrance to the current floor. No reason to go back up now, you're in for the long haul.");
				movePlayer();
				break;
			case 'E':
				// Create a new EmptyRoom object.
				movePlayer();
				break;
			case '!':
				// Create a new TrapRoom object.
				movePlayer();
				break;
			case 'T':
				// Create a new TreasureRoom object.
				movePlayer();
				break;
			case 'M':
				// Create a new MonsterRoom object.
				movePlayer();
				break;
			case 'R':
				// Create a new RestRoom object.
				movePlayer();
				break;
			case 'K':
				// Create a new KeyRoom object.
				movePlayer();
				break;
			case 'B':
				// Create a new BossRoom object.
				movePlayer();
				break;
		}
	}

}
