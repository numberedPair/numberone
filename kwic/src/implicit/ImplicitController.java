package implicit;

import java.util.ArrayList;

import kwic.Input;
import kwic.Output;

public class ImplicitController {

	private ArrayList<String> wordInput;
	private ArrayList<String> ignoreInput;
	
	private WordStore wordList;
	private WordStore outputList;
	
	private Input mainInput;
	private Output mainOutput;
	
	private static String ERROR = "Check that Input file and Ignore file are valid!"
			+ "\nProgram Terminating";
	
	public ImplicitController(String inputPath, String ignorePath, String outputPath){
		mainInput = new Input();
		mainOutput = new Output(outputPath);
		
		wordInput = mainInput.read(inputPath);
		ignoreInput = mainInput.read(ignorePath);
		
		wordList = new WordStore();
		outputList = new WordStore();
		
		if(!readSuccess(wordInput, ignoreInput)){
			System.out.println(ERROR);
			System.exit(0);
		}
	}
	
	public void start() {
		
		CircShifter circShift = new CircShifter(outputList);
	    Filter filter = new Filter(ignoreInput);
	    Alphabetizer alphabetize = new Alphabetizer();
	    
	    wordList.addObserver(circShift);
	    outputList.addObserver(filter);
	    outputList.addObserver(alphabetize);
	    
	    ImplicitInput.process(wordInput, wordList);
	    ImplicitOutput.process(wordInput, outputList);
	    
	    mainOutput.print(wordInput);
	}
	
	private static boolean readSuccess(ArrayList<String> listA,
			ArrayList<String> listB) {
		return (listA != null) && (listB != null);
	}

}
