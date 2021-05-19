package com.javaCrawl.art;

import java.util.concurrent.TimeUnit;

public class FlavorText {

	/**
	 * Default Constructor.
	 */
	public FlavorText() {

	}

	/**
	 * Separates flavor text and some other things.
	 *
	 * @param data the characters used to separate messages.
	 * @param delay how many milliseconds each character waits after printing.
	 * @throws InterruptedException handles exceptions related to printWithDelays.
	 */
	public static void printWithDelays(String data, long delay)
	        throws InterruptedException {
	    for (char ch:data.toCharArray()) {
	        System.out.print("\n" + ch + "\n");

	        TimeUnit.MILLISECONDS.sleep(delay);
	    }
	}

}
