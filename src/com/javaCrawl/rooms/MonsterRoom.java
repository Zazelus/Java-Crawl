package com.javaCrawl.rooms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.javaCrawl.monster.Monster;
import com.javaCrawl.player.Player;
import com.javaCrawl.player.Weapon;

public class MonsterRoom implements Room {

	private static Player player;

	public static int size = 0;
	public static Scanner sc = new Scanner(System.in);

    public static Monster zombie = new Monster("Zombie", 500, 10);
    public static Monster wolf = new Monster("Wolf", 200, 30);
    public static Monster dragon = new Monster("Dragon", 1000, 200);
    public static Monster bigDragon = new Monster("Big Dragon", 2000, 400);
    public static Monster vampire = new Monster("Vampire", 1000, 250);

    public static ArrayList<Monster> monsterList = new ArrayList<>();

    public static Weapon fist = new Weapon("Fist", 5);
    public static Weapon sword = new Weapon("Sword", 50);
    public static Weapon bow = new Weapon("Bow", 40);
    public static Weapon crossBow = new Weapon("Crossbow", 35);
    public static Weapon revolver = new Weapon("Revolver", 100);

    public static ArrayList<Weapon> weaponList = new ArrayList<>();

	public MonsterRoom(Player player) {
		MonsterRoom.player = player;

		initializeMonsters();
		initializeWeapons();
		startCombat();
	}

	public static void startCombat() {
		size = monsterList.size();

        int whichCharacter = random();

        int myDamage = player.getDamage();
        int myHealth = player.getHealth();

        /*for (int i = 0; i < monsterList.size(); i++) {
            System.out.println((i + 1) + ". character: " + monsterList.get(random()).getName());
        }*/

        System.out.println("You were attacked by a(n):");
        System.out.println("Name: " + monsterList.get(whichCharacter).getName());
        System.out.println("HP: " + monsterList.get(whichCharacter).getHealth());
        System.out.println("Attack power: " + monsterList.get(whichCharacter).getDamage());
        System.out.println();
        System.out.println("You attack with...");
        System.out.println();
        System.out.println("1. fist");
        System.out.println("2. sword");
        System.out.println("3. bow");
        System.out.println("4. crossbow");
        System.out.println("5. revolver");

        int choice = sc.nextInt();

        while (!monsterList.get(whichCharacter).isDead() && !player.isDead()) {
            switch (choice) {
                case 1:
                    myDamage = 5;
                    break;
                case 2:
                    myDamage = sword.getWeaponDamage();
                    break;
                case 3:
                    myDamage = bow.getWeaponDamage();
                    break;
                case 4:
                    myDamage = crossBow.getWeaponDamage();
                    break;
                case 5:
                    myDamage = revolver.getWeaponDamage();
                    break;
                default:
                    myDamage = 5;
            }

            while (!monsterList.get(whichCharacter).isDead() && !player.isDead()) {
            	monsterList.get(whichCharacter).attack(myDamage, myHealth);
                player.attack(monsterList.get(whichCharacter).getDamage(), player.getHealth());
                //characterList.get(whichCharacter).attack(characterList.get(whichCharacter).getDamage(), player.getHealth());
            }

        }
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

	public static void initializeWeapons() {
	    weaponList.addAll(Arrays.asList(
	            fist,
	            sword,
	            bow,
	            crossBow,
	            revolver
	    ));
	}

	public static int random() {
        int szam = (int) (Math.random() * size);
        return szam;
    }

	public void interact() {
		// TODO Auto-generated method stub

	}

}
