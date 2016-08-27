package pipeandfilter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Pipe {

	private Queue<ArrayList<String>> dataInPipe_;
	
	public Pipe(){
		dataInPipe_ = new LinkedList<ArrayList<String>>();
	}
	
	//returns null if empty.
	public ArrayList<String> read(){
		return dataInPipe_.poll();
	}
	
	public void write(ArrayList<String> in_data){
		dataInPipe_.offer(in_data);
	}

}