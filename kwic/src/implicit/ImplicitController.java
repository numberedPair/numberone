package implicit;

import java.util.ArrayList;

import kwic.Input;
import kwic.Output;

public class ImplicitController {

	private ArrayList<String> wordInput;
	private ArrayList<String> ignoreInput;
	
	private WordStore wordList;
	private WordStore outputList;
	
	public ImplicitController(ArrayList<String> wordInput, ArrayList<String> ignoreInput){
		this.wordInput = wordInput;
		this. ignoreInput = ignoreInput;
		wordList = new WordStore();
		outputList = new WordStore();
	}
	
	public ArrayList<String> run() {
		
		CircShifter circShift = new CircShifter(outputList);
	    Filter filter = new Filter(ignoreInput);
	    Alphabetizer alphabetize = new Alphabetizer();
	    
	    wordList.addObserver(circShift);
	    outputList.addObserver(filter);
	    outputList.addObserver(alphabetize);
	    
	    ImplicitInput.process(wordInput, wordList);
	    ImplicitOutput.process(wordInput, outputList);
	    
	    return wordInput;
		//Print and save Output

	}

}
