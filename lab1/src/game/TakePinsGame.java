package game;

public class TakePinsGame {

	public static void main(String[] args) {
		Board b = new Board();
		b.setUp(10);
		System.out.println(b.getNoPins());
		b.takePins(1);
		System.out.println(b.getNoPins());
		b.takePins(2);
		System.out.println(b.getNoPins());
	}

}
