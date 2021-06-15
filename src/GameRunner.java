import java.io.FileNotFoundException;
import java.util.Scanner;

import com.javaCrawl.dungeons.FloorGenerator;
import com.javaCrawl.player.Player;

/**
 * Runs the game, initializes the player and handles saving/loading
 * and creating new games.
 *
 * TODO: Make a save/load game system inside of main.
 *
 * @author Zaezul
 * @version 05.17.2021
 *
 */
public class GameRunner {

	private static Player player;

	private static Scanner scan = new Scanner(System.in);

	/**
	 * Static variables used to deal with player movement.
	 */
	private static FloorGenerator floorGen;

	public static String[][] playerMap;

	/*public static String playerName;
	public static int playerHp;
	public static int playerDamage;
	public static int playerGold = 0;
	public static int playerPotions = 0;
	public static Object[] playerInventory;*/

	public static int myHealth = 1000;
	public static int myDamage = 5;

	public static void main(String[] args) {

		/*dungeonFloor = new String[][] {
				{"T", "E", "M", "M", "E"},
				{"!", "M", "!", "T", "M"},
				{"E", "R", "S", "E", "T"},
				{"R", "K", "E", "!", "M"},
				{"M", "T", "B", "E", "T"}
		};*/

		try {
			floorGen = new FloorGenerator("Dungeons/Tutorial Floor", 9, 1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		playerMap = new String[][] {
				{"P"},
				{"?"},
				{"?"},
				{"?"},
				{"?"},
				{"?"},
				{"?"},
				{"?"},
				{"?"}
		};

		/**
		 * TODO: Add conditionals for a 'main menu'.
		 */

		/**
		 * TODO: Make a more substantial player introduction/creation process.
		 */
        System.out.println("Your name!");
        String myName = scan.nextLine();

        player = new Player(myName, 1000, myDamage, floorGen.getDungeon(), playerMap);

        System.out.println("Your name: " + myName);
        System.out.println("Your HP: " + myHealth);
        System.out.println("Your attack power: " + myDamage);
        System.out.println();
        System.out.println();

		System.out.println("You enter the dungeon...\n");
		System.out.println("You are represented as P on the map below. \n");

		player.move();
	}

}
