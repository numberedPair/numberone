package implicit;

public class ImplicitController {
	
	private WordStore wordList;
	private WordStore outputList;
	
	private ImplicitInput input;
	private ImplicitOutput output;
	
	public ImplicitController(String inputPath, String ignorePath, String outputPath){
		input = new ImplicitInput(inputPath, ignorePath);
		output = new ImplicitOutput(outputPath);
		
		wordList = new WordStore();
		outputList = new WordStore();
	}
	
	public void start() {
		
		CircularShifter circularShift = new CircularShifter(outputList);
	    Filter filter = new Filter(input.getIgnoreList());
	    Alphabetizer alphabetize = new Alphabetizer();
	    
	    wordList.addObserver(circularShift);
	    outputList.addObserver(filter);
	    outputList.addObserver(alphabetize);
	    
	    input.readWordList(wordList);    
	    output.print(outputList);
	}

}
