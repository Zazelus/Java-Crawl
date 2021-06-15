package com.javaCrawl.dice;

import java.util.Random;

/**
 * This dice class handles any events that require dice.
 * This includes combat, skill checks, dialogue, etc.
 *
 * @author Zaezul
 *
 */
public class Dice {

	public static Random rand = new Random();

	/**
	 * For the near foreseeable future, will be invoked statically.
	 * No need to keep/store values yet.
	 */
	public Dice() {

	}

	/**
	 * Generates a value from 1 to 4.
	 *
	 * @return integer in range 1..4
	 */
	public static int rollD4() {
		return rand.nextInt(4) + 1;
	}

	/**
	 * Generates a value from 1 to 6.
	 *
	 * @return integer in range 1..6
	 */
	public static int rollD6() {
		return rand.nextInt(6) + 1;
	}

	/**
	 * Generates a value from 1 to 8.
	 *
	 * @return integer in range 1..8
	 */
	public static int rollD8() {
		return rand.nextInt(8) + 1;
	}

	/**
	 * Generates a value from 1 to 10.
	 *
	 * @return integer in range 1..10
	 */
	public static int rollD10() {
		return rand.nextInt(10) + 1;
	}

	/**
	 * Generates a value from 1 to 12.
	 *
	 * @return integer in range 1..12
	 */
	public static int rollD12() {
		return rand.nextInt(12) + 1;
	}

	/**
	 * Generates a value from 1 to 20.
	 *
	 * @return integer in range 1..20
	 */
	public static int rollD20() {
		return rand.nextInt(20) + 1;
	}

}
