package implicit;

import java.util.Observable;
import java.util.Observer;
import java.util.StringTokenizer;

public class CircularShifter implements Observer {

	WordStore inputList;
	WordStore outputList;
	NotifyFlag flag;

	public CircularShifter(WordStore outputList) {
		this.outputList = outputList;
	}

	@Override
	public void update(Observable observe, Object arg) {
		inputList = (WordStore) observe;
		flag = (NotifyFlag) arg;

		if (flag == NotifyFlag.ADD_WORD) {
			shiftWords();
		}
	}

	private void shiftWords() {
		rotate(inputList.getLast());
		outputList.shifted();
	}

	private void rotate(String line) {
		int numOfWords = wordCount(line);
		for (int i = 0; i < numOfWords; i++) {
			line = shiftFirstToLast(line);
			outputList.add(line);
		}
	}

	private int wordCount(String line) {
		StringTokenizer tokenizer = new StringTokenizer(line);
		return tokenizer.countTokens();
	}

	private String shiftFirstToLast(String line) {
		String[] splitted = line.split(" ", 2);
		if (splitted.length > 1) {
			return splitted[1] + " " + splitted[0];
		} else {
			return splitted[0];
		}
	}
}