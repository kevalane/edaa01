package game;

public abstract class Player {
	protected String userId;
	
	/**
	 * Constructor that sets private attribute userId according to parameter
	 * @param userId
	 * 		string value of userid
	 */
	public Player(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Getter for private attribute userid
	 * @return
	 * 		attribute userid, type string
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Removes a number of pins from a board
	 * @param b
	 * 		the Board object to remove the pins from
	 * @return
	 * 		number of pins left after removal
	 */
	public abstract int takePins(Board b);
}
