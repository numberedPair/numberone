package pipeandfilter;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class CircularShifter extends Filter {
	
	private static final int FIRST_CHAR_POS = 0;
	private static final int SECOND_CHAR_POS = 1;

	public CircularShifter(Pipe in_pipe, Pipe out_pipe) {
		super(in_pipe, out_pipe);
	}

	protected void transform() {
		ArrayList<String> wordsToIgnore = in_pipe_.read();
		ArrayList<String> lines = in_pipe_.read();
		
		out_pipe_.write(circularShift(lines, wordsToIgnore));
	}
	
	private ArrayList<String> circularShift(ArrayList<String> data, ArrayList<String> wordsToIgnore) {
		ArrayList<String> new_data = new ArrayList<String>();

		for (int i = 0; i < data.size(); i++) {
			new_data.addAll(permuteLine(data.get(i), wordsToIgnore));
		}
		
		return new_data;
	}

	private ArrayList<String> permuteLine(String line, ArrayList<String> wordsToIgnore) {
		ArrayList<String> words = retrieveWords(line);
		ArrayList<String> permuted_lines = new ArrayList<String>();
		
		//Iterate all words
		for (int i = 0; i < words.size(); i++) {
			
			//if ignored word, skip
			if(wordsToIgnore.contains(words.get(FIRST_CHAR_POS))){
				continue;
			}
			
			String new_line = formLine(words);
			
			//add new lines into the list
			permuted_lines.add(formatLine(new_line));
			
			//Shift 1st word to the back
			shiftFirstWordToLast(words);
		}

		return permuted_lines;
	}

	private ArrayList<String> retrieveWords(String line){
		ArrayList<String> words = new ArrayList<String>();
		
		//Separate line into words
		StringTokenizer st = new StringTokenizer(line);
		while(st.hasMoreTokens()){
			words.add(st.nextToken());
		}
		
		return words;
	}
	
	private String formLine(ArrayList<String> words){
		String line = "";
		
		for(int i = 0; i < words.size(); i++){
			line = line + words.get(i);
		}
		
		return line;
	}
	
	//format 1st character of the String to upper case and the rest to lower case
	private String formatLine(String line){
		String formatted_line = line.substring(FIRST_CHAR_POS, SECOND_CHAR_POS).toUpperCase() + line.substring(SECOND_CHAR_POS);
		
		return formatted_line;
	}

	private ArrayList<String> shiftFirstWordToLast(ArrayList<String> words){
		String word = words.remove(FIRST_CHAR_POS);
		words.add(word);
		
		return words;
	}
	
}
