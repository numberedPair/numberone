package implicit;

import java.util.ArrayList;

import kwic.Input;

public class ImplicitInput {
	
	private ArrayList<String> wordInput;
	private ArrayList<String> ignoreInput;

	private static String ERROR = "Check that Input file and Ignore file are valid!"
			+ "\nProgram Terminating";
	
	public ImplicitInput(String inputPath, String ignorePath){
		Input input = new Input();
		wordInput = input.read(inputPath);
		ignoreInput = input.read(ignorePath);
		
		if(!this.readSuccess(wordInput, ignoreInput)){
			System.out.println(ERROR);
			System.exit(0);
		}
	}
	
	public void readWordList(WordStore wordList){
		for (int i = 0; i < wordInput.size(); i++) {
			wordList.addLine(wordInput.get(i));
			wordList.added();
		}
		
		//wordList.added();
	}
	
	public ArrayList<String> getIgnoreList(){
		return ignoreInput;
	}
	
	private boolean readSuccess(ArrayList<String> listA,
			ArrayList<String> listB) {
		return (listA != null) && (listB != null);
	}
}
