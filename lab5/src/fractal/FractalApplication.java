package fractal;

import koch.Koch;
import mountain.*;

public class FractalApplication {
	public static void main(String[] args) {
		Fractal[] fractals = new Fractal[2];
		fractals[0] = new Koch(300);
		fractals[1] = new Mountain(new Point(200,100), new Point(75, 500), new Point(500,350));
	    new FractalView(fractals, "Fraktaler", 600, 600);
	}

}
