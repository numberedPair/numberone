package kwic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Input {

	private FileReader fileReader;
	private BufferedReader buffReader;
	private ArrayList<String> wordList;
	private String tempLine;
	
	private static String FILE_ERROR = "Exception while reading file: %s "
			+ "\nProgram Terminating";
	private static String FILE_MISSING = "File: %s not found"
			+ "\nProgram Terminating";
	public Input() {

	}

	public ArrayList<String> read(String filename) {
		wordList = new ArrayList<String>();
		try {
			fileReader = new FileReader(filename);
			buffReader = new BufferedReader(fileReader);
			
			this.readFile();
			this.closeFile();
			
			return wordList;
		} catch (FileNotFoundException e ){
			System.out.printf(FILE_MISSING, filename);
			System.exit(0);
			return null;
		} catch (Exception e) {
			System.err.format(FILE_ERROR, filename);
			e.printStackTrace();
			System.exit(0);
			return null;
		}
	}
	
	private void readFile() throws IOException{
		if(buffReader.ready()){
			tempLine = buffReader.readLine();
			
			while (tempLine != null) {
				wordList.add(tempLine);
				tempLine = buffReader.readLine();
			}
		}
	}
	
	private void closeFile() throws IOException {
		fileReader.close();
		buffReader.close();
	}
}
