package pipeandfilter;


import kwic.Output;

public class OutputFilter extends Filter {

	private String out_filename_;
	private Output output;

	public OutputFilter(Pipe in_pipe, String out_filename) {
		super(in_pipe, null);
		out_filename_ = out_filename;
		output = new Output();
	}

	protected void transform() {
		output.print(out_filename_, in_pipe_.read());
	}


}
