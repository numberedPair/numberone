package implicit;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Filter implements Observer{

	WordStore outputList;
	ArrayList<String> ignoreList;
	NotifyFlag flag;
	int lastCount;
	
	public Filter (ArrayList<String> ignoreList){
		this.ignoreList = ignoreList;
		this.standardize();
		lastCount = 0;
	}
	
	@Override
	public void update(Observable observe, Object arg) {
		outputList = (WordStore) observe;
		flag = (NotifyFlag) arg;

		if (flag == NotifyFlag.LIST_SHIFTED) {
			filterList();
		}	
	}
	
	private void filterList(){
		for(int i = lastCount; i < outputList.size(); i++){
			String keyword = keyword(outputList.get(i));
			if(ignoreList.contains(keyword)){
				outputList.delete(i);
			}
		}
		lastCount = outputList.size();
		outputList.filtered();
	}

	private String keyword(String line){
		String[] splitted = line.split(" ", 2);
		return splitted[0].toLowerCase();	
	}
	
	private void standardize(){
		for(int i = 0; i < ignoreList.size(); i++){
			ignoreList.set(i, ignoreList.get(i).toLowerCase());
		}		
	}
}
