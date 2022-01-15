package game;

import javax.swing.JOptionPane;

public class UserInterface {
	
	/**
	 * Print a given message to screen using JOptionPane
	 * @param msg
	 * 		the msg (string) you want to print
	 */
	public static void printMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	
	/**
	 * Prompt for an int input by the user
	 * @param msg
	 * 		string of a message you want to show on the prompt
	 * @return
	 * 		int that the user enters
	 */
	public static int askForInt(String msg) {
		String input = JOptionPane.showInputDialog(msg);
		return Integer.parseInt(input);
	}
}
