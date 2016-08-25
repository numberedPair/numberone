package kwic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Output {

	private FileWriter fileWriter;
	private BufferedWriter buffWriter;
	private ArrayList<String> wordList;
	
	private static String FILE_ERROR = "Exception while writing file: %s";
	
	public Output() {
		
	}
	
	public boolean print(String filename, ArrayList<String> wordList){
		this.wordList = wordList;
		
		try {
			fileWriter = new FileWriter(filename);
			buffWriter = new BufferedWriter(fileWriter);
			
			this.writeFile();
			this.closeFile();
			
			return true;
		} catch (Exception e) {
			System.err.format(FILE_ERROR, filename);
			e.printStackTrace();
			return false;
		}
	}
	
	public void writeFile() throws IOException{
		for(int i =0; i< wordList.size(); i++){
			buffWriter.write(wordList.get(i));
			this.display(wordList.get(i));
		}
	}
	
	public void display(String line){
		System.out.println(line);
	}
	
	public void closeFile() throws IOException{
		buffWriter.close();
		fileWriter.close();
	}
}

