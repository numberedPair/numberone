package implicit;

import java.util.ArrayList;

public class ImplicitInput {

	public ImplicitInput(){
		
	}
	
	public static void process(ArrayList<String> input, WordStore wordList){
		for (int i = 0; i < input.size(); i++) {
			wordList.addLine(input.get(i));
			wordList.added();
		}
		
		//wordList.added();
	}
}
