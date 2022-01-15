package game;

public class TakePinsGame {

	public static void main(String[] args) {
		
		// Game init
		Board b = new Board();
		b.setUp(10);
		boolean playerTurn = true;
		Player p1 = new HumanPlayer("Kevin");
		Player p2 = new ComputerPlayer("comp");
		
		// While loop for game
		while(b.getNoPins() > 0) {
			if (playerTurn) {
				p1.takePins(b);
				playerTurn = false;
			} else {
				p2.takePins(b);
				playerTurn = true;
			}
		}
		
		// out, if playerturn, computer won
		if (playerTurn) {
			UserInterface.printMessage("Datorn vann!");
		} else {
			UserInterface.printMessage("Grattis! Du vann.");
		}
	}

}
