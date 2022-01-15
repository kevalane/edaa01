package game;

public class ComputerPlayer2 extends Player {
	
	
	/**
	 * Initializes computer player using superclasses constructor
	 * @param id
	 * 		string userid of the computer player
	 */
	public ComputerPlayer2(String id) {
		super(id);
	}
	
	/**
	 * Makes a move depending on the number of pins available on the board
	 * If even, remove 1
	 * If odd, remove 2
	 * If 1 or 2, take the w
	 * @param b
	 * 		The board to remove the pins from
	 */
	public int takePins(Board b) {
		
		if (b.getNoPins() == 1 || b.getNoPins() == 2) {
			// win if possible
			b.takePins(b.getNoPins());
		} else if (b.getNoPins() % 2 == 0) {
			// remove one if even
			b.takePins(1);
		} else if (b.getNoPins() %2 != 0) {
			// remove 2 if odd
			b.takePins(2);
		}
		
		return b.getNoPins();
	}
}
