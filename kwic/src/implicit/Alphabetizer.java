package implicit;

import java.util.Observable;
import java.util.Observer;

public class Alphabetizer implements Observer{

	WordStore outputList;
	NotifyFlag flag;
	
	private static int FIRST_CHAR_POS = 0;
	private static int SECOND_CHAR_POS = 1;
	
	@Override
	public void update(Observable observe, Object arg) {
		outputList = (WordStore) observe;
		flag = (NotifyFlag) arg;

		if (flag == NotifyFlag.LIST_FILTERED) {
			this.alphabetize();
		}	
	}

	private void alphabetize(){
		this.setCaps();
		this.sort();
	}
	
	private void setCaps(){
		for(int i = 0; i < outputList.getSize(); i++){
			String currentLine = outputList.getLine(i);
			String newLine = capFirstChar(currentLine) + lowerCase(currentLine);
			outputList.changeLine(i, newLine);
		}
	}
	
	private String capFirstChar(String line){
		return line.substring(FIRST_CHAR_POS, SECOND_CHAR_POS).toUpperCase();
	}
	
	private String lowerCase(String line){
		return line.substring(SECOND_CHAR_POS).toLowerCase();
	}
	
	private void sort(){
		outputList.sort();
	}
}
