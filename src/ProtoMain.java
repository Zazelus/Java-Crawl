import java.util.Scanner;

public class ProtoMain {

	private static Scanner scan = new Scanner(System.in);

	private static char[][] dungeonFloor;
	public static char[][] playerMap;
	private static int[] playerLocation = {2, 2};
	private static int x = playerLocation[0];
	private static int y = playerLocation[1];

	public static String playerName;
	public static int playerHp;
	public static int playerDamage;
	public static int playerGold = 0;
	public static int playerPotions = 0;
	// public static Object[] playerInventory;

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

	public static void printMap(char[][] map) {
		for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
	}

	public static void moveNorth() {

		if (playerLocation[0] > 0) {
			playerLocation[0]--;
			y--;

			revealSurroundings();
			printMap(playerMap);
			parseRoom(playerLocation);
		}

		else {
			System.out.println("There is a wall ahead, you must choose a different path.");
			movePlayer();
		}
	}

	public static void moveEast() {
		if (playerLocation[1] < dungeonFloor.length) {
			playerLocation[1]++;
			x++;

			revealSurroundings();
			printMap(playerMap);
			parseRoom(playerLocation);
		}
	}

	public static void moveSouth() {
		if (playerLocation[0] < dungeonFloor[0].length)
			playerLocation[0]++;
			y++;

			revealSurroundings();
			printMap(playerMap);
			parseRoom(playerLocation);
	}

	public static void moveWest() {
		if (playerLocation[1] > 0) {
			playerLocation[1]--;
			x--;

			revealSurroundings();
			printMap(playerMap);
			parseRoom(playerLocation);
		}
	}

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

	private static void parseRoom(int[] playerLocation) {
		switch (dungeonFloor[y][x]) {
			case 'S':
				enterStartRoom();
				break;
			case 'E':
				enterEmptyRoom();
				break;
			case '!':
				enterTrapRoom();
				break;
			case 'T':
				enterTreasureRoom();
				break;
			case 'M':
				enterMonsterRoom();
				break;
			case 'R':
				enterRestRoom();
				break;
			case 'K':
				enterKeyRoom();
				break;
			case 'B':
				enterBossRoom();
				break;
		}
	}

	public static void enterStartRoom() {

	}

	public static void enterEmptyRoom() {

	}

	public static void enterTrapRoom() {

	}

	public static void enterTreasureRoom() {

	}

	public static void enterMonsterRoom() {

	}

	public static void enterRestRoom() {

	}

	public static void enterKeyRoom() {

	}

	public static void enterBossRoom() {

	}

}
