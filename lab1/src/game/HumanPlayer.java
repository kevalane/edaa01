package game;

import java.util.Scanner;

public class HumanPlayer extends Player {
	
	private Scanner scan;
	
	/**
	 * Constructor that only calls superclasses constructor
	 * initiates scanner object as well
	 * @param userId
	 * 		string of chosen userid
	 */
	public HumanPlayer(String userId) {
		super(userId);
		this.scan = new Scanner(System.in);
	}
	
	/**
	 * Implementation of abstract method from superclass Player.
	 * Let's the player choose how many pins to take.
	 * Validated input
	 * @param b
	 * 		The board object from which to remove the pins
	 * @return
	 * 		Number of pins left on board (int)
	 */
	public int takePins(Board b) {
		int pinsToRemove = 0;
		while (pinsToRemove < 1 || pinsToRemove > 2) {
			System.out.println("Välj hur många pinnar du ska ta bort (1/2):");
			while (!this.scan.hasNextInt()) {
				System.out.println("Skriv en siffra (1 eller 2)!");
				this.scan.next();
			}
			pinsToRemove = this.scan.nextInt();
		}
		b.takePins(pinsToRemove);
		return b.getNoPins();
	}
}
