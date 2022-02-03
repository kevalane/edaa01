package mountain;

public class Side {
	
	private Point p1;
	private Point p2;
	
	/**
	 * Constructor, sets attrbutes for each parameter
	 * @param p1, point 1 of this side
	 * @param p2, point 2 of this side
	 * @param mid, midpoint of this side
	 */
	public Side(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	/**
	 * Getter for p1
	 * @return Point object of p1
	 */
	public Point getP1() {
		return this.p1;
	}
	
	/**
	 * Getter for point 2
	 * @return Point object p2
	 */
	public Point getP2() {
		return this.p2;
	}
	
	
}
