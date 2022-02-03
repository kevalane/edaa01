package fractal;

import koch.Koch;
import mountain.*;

public class FractalApplication {
	public static void main(String[] args) {
		Fractal[] fractals = new Fractal[2];
		fractals[0] = new Koch(300);
		fractals[1] = new Mountain(new Point(300,100), new Point(100, 500), new Point(500,350), 10);
	    new FractalView(fractals, "Fraktaler", 600, 600);
	}

}
