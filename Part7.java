package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Part7 {
	
	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */
	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
		// Your code goes here - see Part0 for an example
		List<String> s = new ArrayList<>();
		List<ArrayList<String>> lists = new ArrayList<>();
        for (String line = r.readLine(); line != null; line = r.readLine()) {
            s.add(line);
        }

        int k = 1, i = 0;
		boolean reset = false;
		while (i < s.size()) {
			ArrayList<String> mini = new ArrayList<>();
			if (k == 1) {
				if (s.get(i).equals("***reset***")) {
					reset = true;
				} 
				mini.add(s.get(i));
				lists.add(mini);
			} else {
				int last = i + k;
				for (int x = i; x < last; x++) {
					if (x >= s.size()) {
						break;
					} else if (s.get(x).equals("***reset***")) {
						reset = true;
						mini.add(s.get(x));
						break;
					} else {
						mini.add(s.get(x));
					}
				}
				lists.add(mini);
			}
			mini = new ArrayList<>();
			if (reset) {
				k = 1;
				i += lists.get(lists.size()-1).size();
				reset = false;
			} else {
				i+=k;
				k++;
			}
		}
		
		for (int y = lists.size()-1; y >= 0; y--) {
			for (int index = 0; index < lists.get(y).size(); index++) {
				w.println(lists.get(y).get(index));
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
