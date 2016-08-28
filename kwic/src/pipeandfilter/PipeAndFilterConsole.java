package pipeandfilter;

public class PipeAndFilterConsole {

	//Main console of Pipe and Filter Architecture
	
	private String lines_filename_;
	private String ignoreWords_filename_;
	private String output_filename_;
	
	public PipeAndFilterConsole(String lines_filename, String ignoreWords_filename, String output_filename){
		lines_filename_ = lines_filename;
		ignoreWords_filename_ = ignoreWords_filename;
		output_filename_ = output_filename;
	}
	
	public void start(){
		//Initialize Pipes
		Pipe in_cs_pipe = new Pipe();
		Pipe cs_lr_pipe = new Pipe();
		Pipe lr_alpha_pipe = new Pipe();
		Pipe alpha_out_pipe = new Pipe();
		
		//Initialize Filters
		InputFilter in_filter = new InputFilter(lines_filename_, ignoreWords_filename_, in_cs_pipe);
		CircularShifter cs_filter = new CircularShifter(in_cs_pipe, cs_lr_pipe);
		LineRemover lr_filter = new LineRemover(cs_lr_pipe, lr_alpha_pipe);
		Alphabetizer alpha_filter = new Alphabetizer(lr_alpha_pipe, alpha_out_pipe);
		OutputFilter out_filter = new OutputFilter(alpha_out_pipe, output_filename_);
		
		//Start all Filters
		in_filter.start();
		cs_filter.start();
		lr_filter.start();
		alpha_filter.start();
		out_filter.start();
	}
	
}
