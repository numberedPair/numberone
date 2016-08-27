package implicit;

import java.util.ArrayList;

import kwic.Output;

public class ImplicitOutput {

	private Output output;
	
	public ImplicitOutput(String outputPath) {
		output = new Output(outputPath);
	}

	public void print(WordStore wordList) {
		ArrayList<String> outputList = new ArrayList<String>();
		for (int i = 0; i < wordList.getSize(); i++) {
			outputList.add(wordList.getLine(i));
		}
		
		output.print(outputList);
	}
}
