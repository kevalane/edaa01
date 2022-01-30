package textproc;

import javax.swing.SwingUtilities;
import javax.swing.JScrollPane;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;


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
	@SuppressWarnings("unchecked")
	private void createWindow(GeneralWordCounter counter, String title, int width, int height) {
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = frame.getContentPane();
		
		// creating JScrollPane
		SortedListModel slm = new SortedListModel(counter.getWordList());
		JList list = new JList(slm);
		JScrollPane scrollPane = new JScrollPane(list);
		pane.add(scrollPane, BorderLayout.CENTER);
		
		// creating JPanel
		JPanel panel1 = new JPanel();
		
		// fixed selection of radio buttons
		ButtonGroup bg = new ButtonGroup();
		JRadioButton btn1 = new JRadioButton("Alphabetic");
		JRadioButton btn2 = new JRadioButton("Frequency");
		bg.add(btn1);
		bg.add(btn2);
		panel1.add(btn1);
		panel1.add(btn2);
		
		// action listener for btn 1
		btn1.addActionListener(e -> {
			slm.sort((e1, e2) -> ((Map.Entry<String, Integer>) e1).getKey().compareTo(((Map.Entry<String, Integer>) e2).getKey()));
		});
		
		// action listener for btn 2
		btn2.addActionListener(e -> {
			slm.sort((e1, e2) -> ((Map.Entry<String, Integer>) e2).getValue() - ((Map.Entry<String, Integer>) e1).getValue());
		});
		
		pane.add(panel1, BorderLayout.PAGE_END);
		
		// add search field
		JPanel panel2 = new JPanel();
		JTextField tf = new JTextField();
		tf.setColumns(20);
		JButton btnSearch = new JButton("Search");
		panel2.add(tf);
		panel2.add(btnSearch);
		pane.add(panel2, BorderLayout.PAGE_START);
		
		// actionlistener btnSearch
		btnSearch.addActionListener(e -> {
			String word = tf.getText().replaceAll("\\s", "").toLowerCase();
			boolean found = false;
			for (int i = 0 ; i < slm.getSize(); i++) {
				if (((Map.Entry<String, Integer>)slm.getElementAt(i)).getKey().equals(word)) {
					list.setSelectedIndex(i);
					list.ensureIndexIsVisible(i);
					found = true;
				}
			}
			if (!found) {
				JOptionPane.showMessageDialog(frame, "Ordet hittades inte!");
			}
		});
		
		// fix submit on enter
		frame.getRootPane().setDefaultButton(btnSearch);
		
		frame.pack();
		frame.setVisible(true);
	}
}
