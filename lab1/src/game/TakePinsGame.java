package game;

public class TakePinsGame {

	public static void main(String[] args) {
		Board b = new Board();
		b.setUp(10);
		
		Player p1 = new HumanPlayer("Kevin");
		System.out.println(p1.takePins(b));
	}

}
