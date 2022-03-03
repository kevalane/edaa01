package sudoku;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

public class SudokuView {
	private static final Color BACKGROUND_COLOR = new Color(255,0,0,50);
	public static void main(String[] args) {
		JFrame frame = new JFrame("Sudoku");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = frame.getContentPane();
		
		JPanel panel1 = new JPanel();
		JButton clearButton = new JButton("Clear");
		JButton solveButton = new JButton("Solve");
		panel1.add(clearButton);
		panel1.add(solveButton);
		
		// action listener for btn 1
		clearButton.addActionListener(e -> {
//			slm.sort((e1, e2) -> e1.getKey().compareTo(e2.getKey()));
		});
		
		// action listener for btn 2
		solveButton.addActionListener(e -> {
//			slm.sort((e1, e2) -> ((Map.Entry<String, Integer>) e2).getValue() - ((Map.Entry<String, Integer>) e1).getValue());
		});
		
		pane.add(panel1, BorderLayout.PAGE_END);
		
		JPanel panel2 = new JPanel();
		JTextField textField[][] = new JTextField[9][9];
		panel2.setLayout(new GridLayout(9,9));
		
		for (int i = 0; i < 9; i++){
			for (int k = 0; k < 9; k++){
				textField[i][k] = new JTextField();
				textField[i][k].setColumns(2);
				if (i < 3 && k < 3) textField[i][k].setBackground(BACKGROUND_COLOR);
				if (i > 5 && k < 3) textField[i][k].setBackground(BACKGROUND_COLOR);
				if (i < 3 && k > 5) textField[i][k].setBackground(BACKGROUND_COLOR);
				if ((i > 2 && i < 6) && ((k > 2 && k < 6))) textField[i][k].setBackground(BACKGROUND_COLOR);
				if (i > 5 && k > 5) textField[i][k].setBackground(BACKGROUND_COLOR);
				panel2.add(textField[i][k], BorderLayout.CENTER);
			}
		}
		
		panel2.setBorder(new EmptyBorder(50,50,50,50));
		
		pane.add(panel2, BorderLayout.PAGE_START);
		frame.pack();
//		frame.setSize(300,300);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
