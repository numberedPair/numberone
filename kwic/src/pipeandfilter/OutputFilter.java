package pipeandfilter;


import kwic.Output;

public class OutputFilter extends Filter {

	private Output output;

	public OutputFilter(Pipe in_pipe, String out_filename) {
		super(in_pipe, null);
		output = new Output(out_filename);
	}

	protected void transform() {
		output.print(in_pipe_.read());
	}


}
