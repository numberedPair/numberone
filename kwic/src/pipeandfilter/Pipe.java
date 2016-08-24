package pipeandfilter;

import java.util.ArrayList;

public class Pipe {

	private ArrayList<String> data_;
	
	public Pipe(){
		data_ = null;
	}
	
	//returns an empty list if empty.
	public ArrayList<String> read(){
		ArrayList<String> out_data_;
		
		while(data_ == null){/*Wait for data*/}
		
		out_data_ = data_;
		data_ = null;
		
		return out_data_;
	}
	
	public void write(ArrayList<String> in_data){
		data_ = in_data;
	}

}