package pipeandfilter;

import kwic.Input;

public class InputFilter extends Filter{

	private String line_filename_;
	private String ignoreWords_filename_;
	private Input input;
	
	public InputFilter (String line_filename, String ignoreWords_filename, Pipe out_pipe){
		super(null, out_pipe);
		line_filename_ = line_filename;
		ignoreWords_filename_ = ignoreWords_filename;
		input = new Input();
	}
	
	protected void transform(){
		out_pipe_.write(input.read(line_filename_));
		out_pipe_.write(input.read(ignoreWords_filename_));
	}
	
}
