package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Set;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Part3 {
	
	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */
	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
		// Your code goes here - see Part0 for an example
		Deque<String> s = new ArrayDeque<>();

		int count = 0;
		boolean sort = false, less = false, more = false;
        for (String line = r.readLine(); line != null; line = r.readLine()) {
			count++;
            if (count < 1000) {
				s.add(line);
				//w.println("less");
			} else if (count <= 2402) {
				sort = true;
				s.add(line);
				less = true;
				//w.println("Less");
			} else if (count == 2403) {
				sort = true;
				s.add(line);
				less = false;
				more = true;
				//w.println("MOre");
			} else if (count == 2404) {
				sort = true;
				more = true;
				less = false;
				s.removeFirst();
				s.add(line);
				count--;
			}
        }

		if (sort) {
			List<String> output = new ArrayList<>(s);
			Collections.sort(output);
			//w.println(output.size()); 
			if (less) {
				w.println(output.get(999));
			} else if (more) {
				w.println(output.get(999));
			}
				
		}

	}

	/**
	 * The driver.  Open a BufferedReader and a PrintWriter, either from System.in
	 * and System.out or from filenames specified on the command line, then call doIt.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader r;
			PrintWriter w;
			if (args.length == 0) {
				r = new BufferedReader(new InputStreamReader(System.in));
				w = new PrintWriter(System.out);
			} else if (args.length == 1) {
				r = new BufferedReader(new FileReader(args[0]));
				w = new PrintWriter(System.out);				
			} else {
				r = new BufferedReader(new FileReader(args[0]));
				w = new PrintWriter(new FileWriter(args[1]));
			}
			long start = System.nanoTime();
			doIt(r, w);
			w.flush();
			long stop = System.nanoTime();
			System.out.println("Execution time: " + 1e-9 * (stop-start));
		} catch (IOException e) {
			System.err.println(e);
			System.exit(-1);
		}
	}
}
