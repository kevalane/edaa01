package textproc;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import java.awt.Container;


public class BookReaderController {
	
	/**
	 * Constructor, creates the JFrame using private helper method and lambda expression
	 * @param counter
	 * 		the generalwordcounter to be used
	 */
	public BookReaderController(GeneralWordCounter counter) {
		SwingUtilities.invokeLater(() -> createWindow(counter, "BookReader", 100, 300));
	}
	
	/**
	 * Creates JFrame (helper function for constructor
	 * @param counter
	 * 		same counter as in constructor
	 * @param title
	 * 		title of Jframe window (string)
	 * @param width
	 * 		width of window (int)
	 * @param height
	 * 		height of window (int)
	 */
	private void createWindow(GeneralWordCounter counter, String title, int width, int height) {
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = frame.getContentPane();
		frame.pack();
		frame.setVisible(true);
	}
}
