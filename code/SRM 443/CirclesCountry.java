import java.io.*;
import java.util.*;

public class CirclesCountry {
	public int leastBorders(int[] X, int[] Y, int[] R, int x1, int y1, int x2, int y2) {
		return 0;
	}

// CUT begin
	public static void main(String[] args){
		System.err.println("CirclesCountry (300 Points)");
		System.err.println();
		HashSet<Integer> cases = new HashSet<Integer>();
        for (int i = 0; i < args.length; ++i) cases.add(Integer.parseInt(args[i]));
        runTest(cases);
	}

	static void runTest(HashSet<Integer> caseSet) {
	    int cases = 0, passed = 0;
	    while (true) {
	    	String label = Reader.nextLine();
	    	if (label == null || !label.startsWith("--"))
	    		break;

            int[] X = new int[Integer.parseInt(Reader.nextLine())];
            for (int i = 0; i < X.length; ++i)
                X[i] = Integer.parseInt(Reader.nextLine());
            int[] Y = new int[Integer.parseInt(Reader.nextLine())];
            for (int i = 0; i < Y.length; ++i)
                Y[i] = Integer.parseInt(Reader.nextLine());
            int[] R = new int[Integer.parseInt(Reader.nextLine())];
            for (int i = 0; i < R.length; ++i)
                R[i] = Integer.parseInt(Reader.nextLine());
            int x1 = Integer.parseInt(Reader.nextLine());
            int y1 = Integer.parseInt(Reader.nextLine());
            int x2 = Integer.parseInt(Reader.nextLine());
            int y2 = Integer.parseInt(Reader.nextLine());
            Reader.nextLine();
            int __answer = Integer.parseInt(Reader.nextLine());

            cases++;
            if (caseSet.size() > 0 && !caseSet.contains(cases - 1))
                continue;
    		System.err.print(String.format("  Testcase #%d ... ", cases - 1));

            if (doTest(X, Y, R, x1, y1, x2, y2, __answer))
                passed++;
	    }
	    if (caseSet.size() > 0) cases = caseSet.size();
        System.err.println(String.format("%nPassed : %d/%d cases", passed, cases));

        int T = (int)(System.currentTimeMillis() / 1000) - 1489166972;
        double PT = T / 60.0, TT = 75.0;
        System.err.println(String.format("Time   : %d minutes %d secs%nScore  : %.2f points", T / 60, T % 60, 300 * (0.3 + (0.7 * TT * TT) / (10.0 * PT * PT + TT * TT))));
	}

	static boolean doTest(int[] X, int[] Y, int[] R, int x1, int y1, int x2, int y2, int __expected) {
		long startTime = System.currentTimeMillis();
		Throwable exception = null;
		CirclesCountry instance = new CirclesCountry();
		int __result = 0;
		try {
			__result = instance.leastBorders(X, Y, R, x1, y1, x2, y2);
		}
		catch (Throwable e) { exception = e; }
		double elapsed = (System.currentTimeMillis() - startTime) / 1000.0;

		if (exception != null) {
			System.err.println("RUNTIME ERROR!");
			exception.printStackTrace();
			return false;
		}
		else if (__result == __expected) {
			System.err.println("PASSED! " + String.format("(%.2f seconds)", elapsed));
			return true;
		}
		else {
			System.err.println("FAILED! " + String.format("(%.2f seconds)", elapsed));
			System.err.println("           Expected: " + __expected);
			System.err.println("           Received: " + __result);
			return false;
		}
	}

	static class Reader {
        private static final String dataFileName = "CirclesCountry.sample";
	    private static BufferedReader reader;

	    public static String nextLine() {
	        try {
                if (reader == null) {
                    reader = new BufferedReader(new InputStreamReader(new FileInputStream(dataFileName)));
                }
                return reader.readLine();
	        }
	        catch (IOException e) {
	            System.err.println("FATAL!! IOException");
	            e.printStackTrace();
	            System.exit(1);
	        }
	        return "";
	    }
	}
// CUT end
}
