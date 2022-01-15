package game;

import java.util.Random;

public class ComputerPlayer extends Player {
	
	private Random rand;
	
	/**
	 * Initializes computer player using supercalsses constructor
	 * Also initializes random object
	 * @param id
	 * 		string userid of the computer player
	 */
	public ComputerPlayer(String id) {
		super(id);
		this.rand = new Random();
	}
	
	/**
	 * Remove a random number of pins (1 or 2)
	 * @param b
	 * 		The board to remove the pins from
	 */
	public int takePins(Board b) {
		int x = this.rand.nextInt(2) + 1;
		b.takePins(x);
		return b.getNoPins();
	}

}
