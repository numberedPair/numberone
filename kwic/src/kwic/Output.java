package kwic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Output {

	private FileWriter fileWriter;
	private BufferedWriter buffWriter;
	private ArrayList<String> wordList;
	private String filename;
	
	private static String FILE_ERROR = "Exception while writing file: %s"
			+ "\nProgram Terminating";
	
	public Output(String filename) {
		this.filename = filename; 
		
		try {
			fileWriter = new FileWriter(filename);
		}catch (Exception e) {
			System.err.format(FILE_ERROR, filename);
			e.printStackTrace();
			System.exit(0);
		}
		
		buffWriter = new BufferedWriter(fileWriter);
	}
	
	public void print(ArrayList<String> wordList){
		this.wordList = wordList;
		
		try {			
			this.writeFile();
			this.closeFile();

		} catch (Exception e) {
			System.err.format(FILE_ERROR, filename);
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	private void writeFile() throws IOException{
		for(int i =0; i< wordList.size(); i++){
			buffWriter.write(wordList.get(i));
			buffWriter.newLine();
			this.display(wordList.get(i));
		}
	}
	
	private void display(String line){
		System.out.println(line);
	}
	
	private void closeFile() throws IOException{
		buffWriter.close();
		fileWriter.close();
	}
}

