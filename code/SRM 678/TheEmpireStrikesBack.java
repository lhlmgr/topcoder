import java.io.*;
import java.util.*;

public class TheEmpireStrikesBack {
	public int find(int AX, int BX, int CX, int AY, int BY, int CY, int N, int M) {
		return 0;
	}

// CUT begin
	public static void main(String[] args){
		System.err.println("TheEmpireStrikesBack (500 Points)");
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

            int AX = Integer.parseInt(Reader.nextLine());
            int BX = Integer.parseInt(Reader.nextLine());
            int CX = Integer.parseInt(Reader.nextLine());
            int AY = Integer.parseInt(Reader.nextLine());
            int BY = Integer.parseInt(Reader.nextLine());
            int CY = Integer.parseInt(Reader.nextLine());
            int N = Integer.parseInt(Reader.nextLine());
            int M = Integer.parseInt(Reader.nextLine());
            Reader.nextLine();
            int __answer = Integer.parseInt(Reader.nextLine());

            cases++;
            if (caseSet.size() > 0 && !caseSet.contains(cases - 1))
                continue;
    		System.err.print(String.format("  Testcase #%d ... ", cases - 1));

            if (doTest(AX, BX, CX, AY, BY, CY, N, M, __answer))
                passed++;
	    }
	    if (caseSet.size() > 0) cases = caseSet.size();
        System.err.println(String.format("%nPassed : %d/%d cases", passed, cases));

        int T = (int)(System.currentTimeMillis() / 1000) - 1489952649;
        double PT = T / 60.0, TT = 75.0;
        System.err.println(String.format("Time   : %d minutes %d secs%nScore  : %.2f points", T / 60, T % 60, 500 * (0.3 + (0.7 * TT * TT) / (10.0 * PT * PT + TT * TT))));
	}

	static boolean doTest(int AX, int BX, int CX, int AY, int BY, int CY, int N, int M, int __expected) {
		long startTime = System.currentTimeMillis();
		Throwable exception = null;
		TheEmpireStrikesBack instance = new TheEmpireStrikesBack();
		int __result = 0;
		try {
			__result = instance.find(AX, BX, CX, AY, BY, CY, N, M);
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
        private static final String dataFileName = "TheEmpireStrikesBack.sample";
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
