package game;

public class TakePinsGame {

	public static void main(String[] args) {
		
		UserInterface.printMessage("hello");
		UserInterface.askForInt("gimme an int");
		
		
		
		Board b = new Board();
		b.setUp(10);
		boolean playerTurn = true;
		Player p1 = new HumanPlayer("Kevin");
		Player p2 = new ComputerPlayer("comp");
		
		while(b.getNoPins() > 0) {
			System.out.println("Det finns " + b.getNoPins() + " pinnar kvar");
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
			System.out.println("Datorn vann!");
		} else {
			System.out.println("Grattis! Du vann.");
		}
	}

}
