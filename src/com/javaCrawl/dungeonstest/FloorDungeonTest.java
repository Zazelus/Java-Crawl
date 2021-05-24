package com.javaCrawl.dungeonstest;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Test;

import com.javaCrawl.dungeons.FloorGenerator;

public class FloorDungeonTest {

	@Test
	public void testFivebyFiveCreation() throws FileNotFoundException {
		String[][] dungeon = {{"E", "E", "M", "T", "M"},
							  {"E", "M", "T", "M", "E"},
						      {"E", "V", "M", "T", "E"},
						      {"M",	"E", "E", "T", "E"},
						      {"T",	"E", "E", "E", "M"}};

		FloorGenerator floorGenerator = new FloorGenerator("Dungeons/testdungeon5x5", 5, 5);

		for (int i = 0; i < 5; i++) {
			for (int k = 0; k < 5; k++) {
				assertEquals(dungeon[i][k], floorGenerator.getDungeon()[i][k]);
			}
		}
	}

}
