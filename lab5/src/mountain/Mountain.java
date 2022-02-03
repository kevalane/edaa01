package mountain;
import fractal.*;

public class Mountain extends Fractal {
	
	private String title;
	private Point x;
	private Point y;
	private Point z;
	
	public Mountain(Point x, Point y, Point z) {
		super();
		this.title = "Mountain";
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public String getTitle() {
		return this.title;
	}

	@Override
	public void draw(TurtleGraphics g) {
		// TODO Auto-generated method stub
//		g.moveTo(x.getX(), x.getY());
		fractalLine(g, order, this.x, this.y, this.z);
		
	}
	
	private void fractalLine(TurtleGraphics g, int order, Point x, Point y, Point z) {
		g.moveTo(x.getX(), x.getY());
		g.penDown();
		g.forwardTo(y.getX(), y.getY());
		g.forwardTo(z.getX(), z.getY());
		g.forwardTo(x.getX(), x.getY());
		g.penUp();

		Point midXY = new Point((x.getX() - y.getX())/2 + y.getX(), (y.getY() - x.getY())/2 + x.getY());
		Point midYZ = new Point((z.getX() - y.getX())/2 + y.getX(), (z.getY() - y.getY())/2 + y.getY());
		Point midXZ = new Point((z.getX() - x.getX())/2+x.getX(), (z.getY() - x.getY())/2 + x.getY());
		if (order > 0) {
			fractalLine(g, order-1, midXY, midYZ, midXZ);
			fractalLine(g, order-1, midXY, y, midYZ);
			fractalLine(g, order-1, midXZ, midYZ, z);
			fractalLine(g, order-1, x, midXY, midXZ);
			
		}
	}
}
