package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BookReaderApplication {

	public static void main(String[] args) throws FileNotFoundException {
		// General word counter
		Scanner scan = new Scanner(new File("undantagsord.txt"));
		
		Set<String> stopwords = new HashSet<String>();
		
		while (scan.hasNext()) {
			String word = scan.next().toLowerCase();
			stopwords.add(word);
		}
		
		GeneralWordCounter r = new GeneralWordCounter(stopwords);
		
		Scanner s = new Scanner(new File("nilsholg.txt"));
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			r.process(word);
		}

		s.close();
		
		r.report();
		
		BookReaderController brc = new BookReaderController(r);

		
	}

}
