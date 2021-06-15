package com.javaCrawl.dungeons;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Generates levels using a file with a legend corresponding to specific
 * characters.
 *
 * @author Zaezul
 * @version 04.20.2020
 */
public class FloorGenerator {

	private String[][] dungeonFloor;


	/**
	 * Creates a new FloorGenerator object.
	 *
	 * @param dungeonFile is the name of the file to import the dungeon.
	 * @throws FileNotFoundException is thrown if the file is not found.
	 */
	public FloorGenerator(String dungeonFile, int height, int width) throws FileNotFoundException {
		dungeonFloor = readDungeonFile(dungeonFile, height, width);
	}

	/**
	 * Returns the array representing the dungeon floor.
	 *
	 * @return dungeonFloor array.
	 */
	public String[][] getDungeon() {
		return dungeonFloor;
	}
	/**
	 * Returns the dungeon read from the file in array form.
	 *
	 * @param dungeonFile is the file to be read.
	 * @param height      is the height of the dungeon.
	 * @param width       is the width of the dungeon
	 * @return the current floor in the form of an array.
	 * @throws FileNotFoundException is thrown if the file is not found.
	 */
	private String[][] readDungeonFile(String dungeonFile, int height, int width) throws FileNotFoundException {
		String[][] floorArray = new String[height][width];

		Scanner file = new Scanner(new File(dungeonFile));

		int rowIndex = 0;
		int colIndex = 0;

		/**
		 * Will read each line and split every space or symbol in between characters.
		 */
		while (file.hasNextLine()) {
			String line = file.nextLine();
			String[] lineSplit = line.split(" *");

			while (colIndex < width) {
				floorArray[rowIndex][colIndex] = lineSplit[colIndex];

				colIndex++;
			}

			colIndex = 0;
			rowIndex++;
		}

		file.close();
		return floorArray;
	}

}
