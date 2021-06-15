package com.javaCrawl.rooms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.javaCrawl.items.Weapon;
import com.javaCrawl.monster.Monster;
import com.javaCrawl.player.Player;

public class MonsterRoom extends Room {

	private static Player player;
	//private static int floorLevel;

	private static int size = 0;
	private static Scanner sc = new Scanner(System.in);

	private static Monster zombie = new Monster("Zombie", 500, 10);
	private static Monster wolf = new Monster("Wolf", 200, 30);
	private static Monster dragon = new Monster("Dragon", 1000, 200);
	private static Monster bigDragon = new Monster("Big Dragon", 2000, 400);
	private static Monster vampire = new Monster("Vampire", 1000, 250);

	private static ArrayList<Monster> monsterList = new ArrayList<>();

	public MonsterRoom(Player player, int floorLevel) {
		MonsterRoom.player = player;
		//MonsterRoom.floorLevel = floorLevel;

		initializeMonsters();
	}

	public void startCombat() {
		size = monsterList.size();

        int whichCharacter = random();

        Monster enemy = monsterList.get(whichCharacter);

        String enemyName = enemy.getName();
        int enemyHealth = enemy.getHealth();
        int enemyPower = enemy.getDamage();

        printDelay();

        System.out.println("You were attacked by a(n):");
        System.out.println("Name: " + enemyName);
        System.out.println("HP: " + enemyHealth);
        System.out.println("Attack power: " + enemyPower);
        System.out.println();

        while (!enemy.isDead() && !player.isDead()) {

        	System.out.println("You attack with...");
            System.out.println();
            System.out.println("1. fist");
            System.out.println("2. sword");
            System.out.println("3. bow");
            System.out.println("4. crossbow");
            System.out.println("5. revolver");

        	int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
            }

        	enemy.attack(enemy.getDamage(), player);
            player.attack(monsterList.get(whichCharacter));
            //characterList.get(whichCharacter).attack(characterList.get(whichCharacter).getDamage(), player.getHealth());
        }

        printDelay();

        player.move();
	}

	public static void initializeMonsters() {
	    monsterList.addAll(Arrays.asList(
	            zombie,
	            wolf,
	            dragon,
	            bigDragon,
	            vampire
	    ));
	}

	public static int random() {
        int szam = (int) (Math.random() * size);
        return szam;
    }

	public void interact() {
		startCombat();
	}

	public boolean explored() {
		// TODO Auto-generated method stub
		return false;
	}

}
