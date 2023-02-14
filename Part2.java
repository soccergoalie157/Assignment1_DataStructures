package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Part2 {
	
	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */
	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
		// Your code goes here - see Part0 for an example
		List<String> output = new ArrayList<>();

		int index = 0;
		String max = "";
        for (String line = r.readLine(); line != null; line = r.readLine()) {
            if (index == 0 && line.equals("")) {
				continue;
			} else {
				if (output.isEmpty()) {
					output.add(line);
				} else if (line.compareTo(output.get(output.size()-1)) < 0) {
					output.add(line);
				} else if (line.compareTo(max) > 0) {
					output.add(line);
				}
			}
			if (line.compareTo(max) > 0) {
				max = line;
			}
			index++;
        }
		
		/* 
		String max = "";
		for (int i = 0; i < s.size(); i++) {
			if (i == 0 && s.get(i).equals("")) {
				continue;
			} else {
				if (output.isEmpty()) {
					output.add(s.get(i));
				} else if (s.get(i).compareTo(output.get(output.size()-1)) < 0) {
					output.add(s.get(i));
				} else if (s.get(i).compareTo(Collections.max(s.subList(0, i))) > 0) {
					output.add(s.get(i));
				}
			}
		}*/
		
		for (int i = 0; i < output.size(); i++) {
			w.println(output.get(i));
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
