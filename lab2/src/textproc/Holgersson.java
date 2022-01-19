package textproc;

import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		
		long t0 = System.nanoTime();
		
		// General word counter
		Scanner scan = new Scanner(new File("undantagsord.txt"));
		
		Set<String> stopwords = new HashSet<String>();
		
		while (scan.hasNext()) {
			String word = scan.next().toLowerCase();
			stopwords.add(word);
		}
		
		TextProcessor r = new GeneralWordCounter(stopwords);
		
		// Using multiwordcounter
		MultiWordCounter m = new MultiWordCounter(REGIONS);
		
		// Using SingleWordCounter
		ArrayList<TextProcessor> pList = new ArrayList<>();
//		TextProcessor p = new SingleWordCounter("nils");
		pList.add(new SingleWordCounter("nils"));
		pList.add(new SingleWordCounter("norge"));

		Scanner s = new Scanner(new File("nilsholg.txt"));
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			
			for (TextProcessor t : pList) {
				t.process(word);
			}
			r.process(word);
			m.process(word);
//			p.process(word);
		}

		s.close();
		
		r.report();
		m.report();
//		p.report();
		for (TextProcessor t : pList) {
			t.report();
		}
		
		long t1 = System.nanoTime();
		System.out.println("tid: " + (t1 - t0) / 1000000 + " ms");
	}
}