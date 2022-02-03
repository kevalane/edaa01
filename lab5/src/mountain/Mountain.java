package mountain;
import java.util.HashMap;

import fractal.*;

public class Mountain extends Fractal {
	
	private String title;
	private Point x;
	private Point y;
	private Point z;
	private double dev;
	private HashMap<Side, Point> sides;
	
	/**
	 * Constructor for Mountain
	 * @param x, x coordinate (of type Point) to start from.
	 * @param y, y coordinate (of type Point) to start from.
	 * @param z, z coordinate (of type Point) to start from.
	 */
	public Mountain(Point x, Point y, Point z, double dev) {
		super();
		this.title = "Mountain";
		this.x = x;
		this.y = y;
		this.z = z;
		this.dev = dev;
		this.sides = new HashMap<Side, Point>();
	}

	/**
	 * Getter of title
	 */
	@Override
	public String getTitle() {
		return this.title;
	}

	/**
	 * Initiates drawing of fractalLines
	 * @param g TurtleGraphics obj to be used for drawing
	 */
	@Override
	public void draw(TurtleGraphics g) {
		fractalLine(g, order, this.x, this.y, this.z);
		
	}
	
	/**
	 * Draws triangles for a given order o
	 * @param g, turtlegraphics to be used for drawing
	 * @param order, the order of triangles to be drawn
	 * @param x Point object, x coordinate to start from
	 * @param y Point object, y coordinate to start from
	 * @param z Point object, z coordinate to start from
	 */
	private void fractalLine(TurtleGraphics g, int order, Point x, Point y, Point z) {
		if (order == 0) {
			g.moveTo(x.getX(), x.getY());
			g.penDown();
			g.forwardTo(y.getX(), y.getY());
			g.forwardTo(z.getX(), z.getY());
			g.forwardTo(x.getX(), x.getY());
			g.penUp();
		} else {
		Point midXY;
		Point midYZ;
		Point midXZ;
		if (!this.sides.containsKey(new Side(x,y))) {
			midXY = new Point((x.getX() - y.getX())/2 + y.getX(), (y.getY() - x.getY())/2 + x.getY() + (int)RandomUtilities.randFunc(dev/2));
			this.sides.put(new Side(x,y), midXY);
		} else {
			midXY = this.sides.get(new Side(x,y));
//			this.sides.remove(new Side(x,y));
		}
		if (!this.sides.containsKey(new Side(y,z))) {
			midYZ = new Point((z.getX() - y.getX())/2 + y.getX(), (z.getY() - y.getY())/2 + y.getY() + (int)RandomUtilities.randFunc(dev/2));
			this.sides.put(new Side(y,z), midYZ);
		} else {
			midYZ = this.sides.get(new Side(y,z));
//			this.sides.remove(new Side(y,z));
		}
		if (!this.sides.containsKey(new Side(x,z))) {
			midXZ = new Point((z.getX() - x.getX())/2+x.getX(), (z.getY() - x.getY())/2 + x.getY() + (int)RandomUtilities.randFunc(dev/2));
			this.sides.put(new Side(x,z), midXZ);
		} else {
			midXZ = this.sides.get(new Side(x,z));
//			this.sides.remove(new Side(x,z));
		}
		
		if (order > 0) {
			fractalLine(g, order-1, midXY, midYZ, midXZ);
			fractalLine(g, order-1, midXY, y, midYZ);
			fractalLine(g, order-1, midXZ, midYZ, z);
			fractalLine(g, order-1, x, midXY, midXZ);
			
		}
		}
	}
}
