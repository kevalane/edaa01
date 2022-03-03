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
import javax.swing.JOptionPane;

public class SudokuView {
	private static final Color BACKGROUND_COLOR = new Color(255,0,0,50);
	SudokuSolver s;
	JFrame frame;
	Container pane;
	JTextField[][] textField;
	
	public SudokuView() {
		this.s = new Sudoku();
		this.frame = new JFrame("Sudoku Solver");
		this.pane = frame.getContentPane();
		this.textField = new JTextField[Sudoku.SIZE][Sudoku.SIZE];
		this.initGui();
	}
	
	private void initGui() {
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addButtons();
		this.addBoard();
		this.frame.pack();
		this.frame.setResizable(false);
		this.frame.setVisible(true);
	}
	
	private void addBoard() {
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(Sudoku.SIZE,Sudoku.SIZE));
		
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
		
		this.pane.add(panel2, BorderLayout.PAGE_START);
	}
	
	private void addButtons() {
		JPanel panel1 = new JPanel();
		JButton clearButton = new JButton("Clear");
		JButton solveButton = new JButton("Solve");
		panel1.add(clearButton);
		panel1.add(solveButton);
		
		this.pane.add(panel1, BorderLayout.PAGE_END);
		this.frame.getRootPane().setDefaultButton(solveButton);
		
		// action listener for btn 1
		clearButton.addActionListener(e -> {
			s.clear();
			for (int i = 0; i < Sudoku.SIZE; i++) {
				for (int k = 0; k < Sudoku.SIZE; k++) {
					textField[i][k].setText("");
				}
			}
		});
		
		// action listener for btn 2
		solveButton.addActionListener(e -> {
			try {
				s.addUserInput(textField);
				boolean solveable = s.solve();
				if (!solveable) JOptionPane.showMessageDialog(null,"Sudoku gick ej att lösa.");  
				for (int i = 0; i < Sudoku.SIZE; i++) {
					for (int k = 0; k < Sudoku.SIZE; k++) {
						if (s.get(i,k) == 0) return;
						textField[i][k].setText(String.valueOf(s.get(i,k)));
					}
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}
		});
	}
}
