package kwic;

import implicit.ImplicitController;

import java.util.ArrayList;

public class kwic {

	private static Input input;
	private static Output output;
	private static ArrayList<String> wordList;
	private static ArrayList<String> ignoreList;

	static String SELECT_DESIGN = "Select Architecure:\n1: Pipe & Filter\n2: Implicit Invocation\nSelection :";
	static String INVALID_USAGE = "Usage Error \nProper Usage: kwic.jar <input file> <filter file> <output file>";

	public static void main(String[] args) {
		checkUsage(args);
		input = new Input();

		String inputPath = args[0];
		String ignorePath = args[1];
		String outputPath = args[2];

		wordList = input.read(inputPath);
		ignoreList = input.read(ignorePath);

		if (readSuccess(wordList, ignoreList)) {
			//TODO Proper selector
			ImplicitController implicit = new ImplicitController(wordList, ignoreList);
			wordList = implicit.run();
			
		}

		output = new Output();
		output.print(outputPath, wordList);
	}

	public static void checkUsage(String[] args) {
		if (args.length != 3) {
			System.out.println(INVALID_USAGE);
			System.exit(0);
		}
	}

	private static boolean readSuccess(ArrayList<String> listA,
			ArrayList<String> listB) {
		return (listA != null) && (listB != null);
	}

}
