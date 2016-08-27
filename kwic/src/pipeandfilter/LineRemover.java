package pipeandfilter;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class LineRemover extends Filter {

	private static final int FIRST_CHAR_POS = 0;
	private static final int SECOND_CHAR_POS = 1;

	public LineRemover(Pipe in_pipe, Pipe out_pipe) {
		super(in_pipe, out_pipe);
	}

	protected void transform() {
		ArrayList<String> lines = in_pipe_.read();
		ArrayList<String> wordsToIgnore = in_pipe_.read();

		ArrayList<String> formatted_wordsToIgnore = new ArrayList<String>();
		// format all words in wordsToIgnore
		for (int i = 0; i < wordsToIgnore.size(); i++) {
			formatted_wordsToIgnore.add(formatWord(wordsToIgnore.get(i)));
		}

		out_pipe_.write(filterLines(lines, formatted_wordsToIgnore));
	}

	private ArrayList<String> filterLines(ArrayList<String> lines, ArrayList<String> wordsToIgnore) {

		int i = 0;
		while (i < lines.size()) {
			if (isWordToIgnore(lines.get(i), wordsToIgnore)) {
				lines.remove(i);
			} else {
				i++;
			}
		}

		return lines;
	}

	private boolean isWordToIgnore(String line, ArrayList<String> wordsToIgnore) {
		StringTokenizer st = new StringTokenizer(line);
		String first_word = st.nextToken();
		
		return wordsToIgnore.contains(first_word);
	}

	// format 1st character of the String to upper case and the rest to lower
	// case
	private String formatWord(String word) {
		String formatted_word = word.substring(FIRST_CHAR_POS, SECOND_CHAR_POS).toUpperCase()
				+ word.substring(SECOND_CHAR_POS).toLowerCase();

		return formatted_word;
	}

}
