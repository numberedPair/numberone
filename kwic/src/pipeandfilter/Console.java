package pipeandfilter;

import java.io.File;

public class Console {

	//Main console of Pipe and Filter Architecture
	
	private File lines_file_;
	private File ignoreWords_file_;
	private File output_file_;
	
	public Console(File lines_file, File ignoreWords_file, File output_file){
		lines_file_ = lines_file;
		ignoreWords_file_ = ignoreWords_file;
		output_file_ = output_file;
	}
	
	public void start(){
		//Initialize Pipes
		Pipe in_cs_pipe = new Pipe();
		Pipe cs_alpha_pipe = new Pipe();
		Pipe alpha_out_pipe = new Pipe();
		
		//Initialize Filters
		Input in1_filter = new Input(ignoreWords_file_, in_cs_pipe);
		Input in2_filter = new Input(lines_file_, in_cs_pipe);
		CircularShifter cs_filter = new CircularShifter(in_cs_pipe, cs_alpha_pipe);
		Alphabetizer alpha_filter = new Alphabetizer(cs_alpha_pipe, alpha_out_pipe);
		Output out_filter = new Output(alpha_out_pipe, output_file_);
		
		//Start all Filters
		in1_filter.run();
		cs_filter.run();
		in2_filter.run(); //to ensure wordsToIgnore is read 1st before lines
		alpha_filter.run();
		out_filter.run();
	}
	
}
