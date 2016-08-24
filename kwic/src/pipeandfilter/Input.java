package pipeandfilter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Input extends Filter{

	private File in_file_;

	
	public Input (File in_file, Pipe out_pipe){
		super(null, out_pipe);
		in_file_ = in_file;
	}
	
	protected void transform(){
		try{
			out_pipe_.write(readFromFile());
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	private ArrayList<String> readFromFile() throws IOException{
		ArrayList<String> data = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader(in_file_));
		
		String line;
		while((line = br.readLine()) != null){
			data.add(line);
		}
		br.close();
		
		return data;
	}
	
	
}
