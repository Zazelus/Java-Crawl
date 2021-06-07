package com.javaCrawl.dice;

import java.util.Random;

public class Dice {

	public static Random rand = new Random();

	public Dice() {

	}

	public static int rollD4() {
		return rand.nextInt(4) + 1;
	}

	public static int rollD6() {
		return rand.nextInt(6) + 1;
	}

	public static int rollD8() {
		return rand.nextInt(8) + 1;
	}

	public static int rollD10() {
		return rand.nextInt(10) + 1;
	}

	public static int rollD12() {
		return rand.nextInt(12) + 1;
	}

	public static int rollD20() {
		return rand.nextInt(20) + 1;
	}

}
