package pipeandfilter;

import java.util.ArrayList;
import java.util.Collections;

public class Alphabetizer extends Filter{
	
	public Alphabetizer(Pipe in_pipe, Pipe out_pipe){
		super(in_pipe, out_pipe);
	}
	
	protected void transform(){
		//sort data in ascending order
		ArrayList<String> data = in_pipe_.read();
		Collections.sort(data);
		out_pipe_.write(data);
	}
	
}
