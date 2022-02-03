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
	
	@Override
	public int hashCode() {
		return p1.hashCode() + p2.hashCode();
	}
	
	@Override
	public boolean equals(Object s) {
		if (s == this) return true;
		if (!(s instanceof Side)) return false;
		Side s2 = (Side) s;
		if (this.p1 == s2.p1 && this.p2 == s2.p2) return true;
		return false;
	}
	
}
