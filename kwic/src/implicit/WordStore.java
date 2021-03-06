package implicit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

public class WordStore extends Observable{

	private List<String> wordLines;
	
	public WordStore(){
		wordLines = new ArrayList<String>();
	}
	
	public void add(String line) {
		wordLines.add(line);		
	}
	
	public void set(int index, String line){
		wordLines.set(index, line);
	}
	
	public String get(int index) {
		return wordLines.get(index);
	}
	
	public String getLast(){
		int lastIndex = wordLines.size() - 1;
		return wordLines.get(lastIndex);
	}
	
	public void delete(int index){
		wordLines.remove(index);
	}
	
	public int size(){
		return wordLines.size();
	}

	public void added(){
		setChanged();
		notifyObservers(NotifyFlag.ADD_WORD);		
	}
	
	public void shifted(){
		setChanged();
		notifyObservers(NotifyFlag.LIST_SHIFTED);	
	}
	
	public void filtered(){
		setChanged();
		notifyObservers(NotifyFlag.LIST_FILTERED);	
	}

	public void sort() {
		Collections.sort(wordLines);
	}
}
