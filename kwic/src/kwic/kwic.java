package kwic;

import implicit.ImplicitController;
import pipeandfilter.PipeAndFilterConsole;

import java.util.Scanner;

public class kwic {

	static String SELECT_DESIGN = "Select Architecure:\n1: Pipe & Filter"
			+ "\n2: Implicit Invocation\nSelection : ";
	static String INVALID_SELECTION = "Invalid selection. Please choose 1 or 2:";
	static String INVALID_USAGE = "Usage Error "
			+ "\nProper Usage: kwic.jar <input file> <filter file> <output file>";
	static String COMPLETED = "\nThe above output has also been saved to the output file %s\n";
	
	private static final int PIPE_AND_FILTER = 1;
	private static final int IMPLICIT_INVOCATION = 2;

	public static void main(String[] args) {
		checkUsage(args);

		String inputPath = args[0];
		String ignorePath = args[1];
		String outputPath = args[2];

		switch (selectArchitecture()) {
		case PIPE_AND_FILTER:
			PipeAndFilterConsole pf_console = new PipeAndFilterConsole(inputPath, ignorePath, outputPath);
			pf_console.start();
			break;
		case IMPLICIT_INVOCATION:
			ImplicitController implicit = new ImplicitController(inputPath,
					ignorePath, outputPath);
			implicit.start();
			break;
		}
		
		System.out.printf(COMPLETED, outputPath);

	}

	public static void checkUsage(String[] args) {
		if (args.length != 3) {
			System.out.println(INVALID_USAGE);
			System.exit(0);
		}
	}

	private static int selectArchitecture() {
		System.out.print(SELECT_DESIGN);

		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();

		while (choice != PIPE_AND_FILTER && choice != IMPLICIT_INVOCATION) {
			System.out.println(INVALID_SELECTION);
			choice = sc.nextInt();
		}

		sc.close();
		return choice;
	}
}
