package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Part6 {
	
	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */
	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
		// Your code goes here - see Part0 for an example
		Queue<String> s = new PriorityQueue<>();
		//List<String> s = new ArrayList<>();

		int count = 0;
		boolean more = false;
        for (String line = r.readLine(); line != null; line = r.readLine()) {
			//s.add(line);
			count++;
			if (count < 901) {
				s.add(line);
				//w.println(count);
			} else {
				//w.println("here");
				more = true;
				s.add(line);
				if (count == 902) {
				//w.println("remove");
					s.remove();
				//s.add(line);
					count--;
				}
			}
		} 

		
		if (more) {
			//w.println(s.size());
			//w.println(output.indexOf("0020a5f0369e6f342cbf1d709408b4c3257e4e6c79593089a18a8e0f23e23325"));
			//w.println(output.subList(0, 5));
			//w.println(s);
			w.println(s.remove());
		}

		//w.println(output.indexOf("e951dc1e107df8295870c5b570ed43e0cd5387e728b519d0d2e10a192ae3c6e1"));
		//w.println(output.size());
		/* 
		if (s.size() >= 901) {
			Collections.sort(s);
			w.println(s.subList(s.size()-901, s.size()).get(0));
		}*/
		// 0020a5f0369e6f342cbf1d709408b4c3257e4e6c79593089a18a8e0f23e23325
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
