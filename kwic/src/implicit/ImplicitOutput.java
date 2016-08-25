package implicit;

import java.util.ArrayList;

public class ImplicitOutput {

	public ImplicitOutput() {

	}

	public static void process(ArrayList<String> output, WordStore wordList) {
		output.clear();
		for (int i = 0; i < wordList.getSize(); i++) {
			output.add(wordList.getLine(i));
		}
	}
}
