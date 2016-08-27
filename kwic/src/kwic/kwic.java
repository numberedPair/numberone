package kwic;

import implicit.ImplicitController;
import pipeandfilter.Console;

import java.util.ArrayList;
import java.util.Scanner;

public class kwic {

	private static Input input;
	private static Output output;
	private static ArrayList<String> wordList;
	private static ArrayList<String> ignoreList;

	static String SELECT_DESIGN = "Select Architecure:\n1: Pipe & Filter\n2: Implicit Invocation\nSelection : ";
	static String INVALID_SELECTION = "Invalid selection. Please choose 1 or 2:";
	static String INVALID_USAGE = "Usage Error \nProper Usage: kwic.jar <input file> <filter file> <output file>";

	private static final int PIPE_AND_FILTER = 1;
	private static final int IMPLICIT_INVOCATION = 2;

	public static void main(String[] args) {
		checkUsage(args);

		input = new Input();

		String inputPath = args[0];
		String ignorePath = args[1];
		String outputPath = args[2];

		switch (selectArchitecture()) {
		case PIPE_AND_FILTER:
			Console console = new Console(inputPath, ignorePath, outputPath);
			console.start();
			break;
		case IMPLICIT_INVOCATION:
			System.out.println("to be written by barny");
			/*
			 * wordList = input.read(inputPath); ignoreList =
			 * input.read(ignorePath);
			 * 
			 * 
			 * if (readSuccess(wordList, ignoreList)) { // TODO Proper selector
			 * // ImplicitController implicit = new ImplicitController(wordList,
			 * // ignoreList); // wordList = implicit.run();
			 * 
			 * }
			 * 
			 * // output = new Output(); // output.print(outputPath, wordList);
			 */
			break;
		}

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

	private static boolean readSuccess(ArrayList<String> listA, ArrayList<String> listB) {
		return (listA != null) && (listB != null);
	}

}
