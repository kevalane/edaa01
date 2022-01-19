package textproc;

import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class GeneralWordCounter implements TextProcessor {
	
	private Map<String, Integer> m;
	private Set<String> ex;
	
	/**
	 * Constructor, instantiates Map as HashMap and adds set as HashSet
	 * @param s
	 * 		Set of strings with words to be exempt
	 */
	public GeneralWordCounter(Set<String> s) {
		this.ex = new TreeSet<String>(s);
		this.m = new TreeMap<String, Integer>();
	}
	
	/**
	 * Increments value associated with key w iff Set of exemption words does not contain w
	 * If not in map, puts as a new key with 1 as value
	 * @param w
	 * 		word to check as a String
	 */
	public void process(String w) { 
		if (!this.ex.contains(w)) {
			if (this.m.containsKey(w)) {
				this.m.put(w, this.m.get(w) + 1);
			} else {
				this.m.put(w, 1);
			}
		}
	}
	
	/**
	 * Printing all key-value where value >= 200
	 */
	public void report() {
		Set<Map.Entry<String, Integer>> wordSet = this.m.entrySet();
		List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);
		wordList.sort((e1, e2) -> e2.getValue() - e1.getValue());
		wordList.stream().limit(5).forEach(System.out::println);
		
//		for (String k : this.m.keySet()) {
//			if (this.m.get(k) >= 200) System.out.println(k + ": " + this.m.get(k));
//		}
	}
}