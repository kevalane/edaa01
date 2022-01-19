package textproc;

import java.util.Map;
import java.util.HashMap;

public class MultiWordCounter implements TextProcessor {
	
	private Map<String, Integer> m;
	
	/**
	 * constructor initiates map attribute and calls init function to store values
	 * @param words
	 * 		string vector of words we'll be looking for
	 */
	public MultiWordCounter(String[] words) {
		m = new HashMap<String, Integer>();
		this.init(words);
	}
	
	/**
	 * Adds all words as keys to map attribute, and sets their counter to 0
	 * @param words
	 * 		same as constructor, string vector of words we'll be looking for
	 */
	private void init(String[] words) {
		for (int i = 0; i < words.length; i++) {
			this.m.put(words[i], 0);
		}
	}
	
	/**
	 * Used to print all stored values in the hash map
	 * Using a forEach, loops over all elements and prints with format:
	 * 		Key (word): value (number of occurances)
	 */
	public void report() {
		for (String k : this.m.keySet()) {
			System.out.println(k + ": " + this.m.get(k));
		}
	}
	
	/**
	 * Increments value stored by 1 if a key same as String w is found
	 * @param w
	 * 		string word we want to check and increment
	 */
	public void process(String w) {
		if (this.m.containsKey(w)) {
			this.m.put(w, this.m.get(w) + 1);
		}
	}
}
