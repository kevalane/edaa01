package game;

public class Board {
	private int noPins;
	
	/**
	 * Sets the number of pins to be used in the board game
	 * @param noPins
	 * 		int number of pins to be used
	 */
	public void setUp(int noPins) {
		this.noPins = noPins;
	}
	
	/**
	 * Removes a number of pins from the board
	 * @param p
	 * 		int number of pins to remove
	 */
	public void takePins(int p) {
		this.noPins -= p;
	}
	
	/**
	 * Getter for noPins attribute, number of pins left on board
	 * @return 
	 * 		number of pins, int
	 */
	public int getNoPins() {
		return this.noPins;
	}
	
}
