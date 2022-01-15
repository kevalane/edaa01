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
	 * Let's the player choose how many pins to take (using JOptionPane!!)
	 * Validated input both from UserInterface and using while
	 * @param b
	 * 		The board object from which to remove the pins
	 * @return
	 * 		Number of pins left on board (int)
	 */
	public int takePins(Board b) {
		int pinsToRemove = UserInterface.askForInt("Hur många pinnar vill du ta bort? Det finns " + b.getNoPins() + " pinnar kvar");
		while (pinsToRemove < 1 || pinsToRemove > 2) {
			if (pinsToRemove == -2) System.exit(0);
			pinsToRemove = UserInterface.askForInt("Felaktig input. Välj en siffra mellan 1-2! (det finns fortfarande " + b.getNoPins() + " pinnar kvar)");
		}
		b.takePins(pinsToRemove);
		return b.getNoPins();
	}
	
	/**
	 * Implementation of abstract method from superclass Player.
	 * Let's the player choose how many pins to take (using the console!!)
	 * Validated input using while
	 * @param b
	 * 		The board object from which to remove the pins
	 * @return
	 * 		Number of pins left on board (int)
	 */
	public int takePinsConsole(Board b) {
		int pinsToRemove = 0;
		while (pinsToRemove < 1 || pinsToRemove > 2) {
			System.out.println("Välj hur många pinnar du ska ta bort (1/2):");
			while (!this.scan.hasNextInt()) {
				// if they enter a string
				System.out.println("Skriv en siffra (1 eller 2)!");
				this.scan.next();
			}
			pinsToRemove = this.scan.nextInt();
			// loops back if int != 1 or 2
		}
		b.takePins(pinsToRemove);
		return b.getNoPins();
	}
}
