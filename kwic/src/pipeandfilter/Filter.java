package pipeandfilter;

public abstract class Filter{

	protected Pipe in_pipe_;
	protected Pipe out_pipe_;
	
	public Filter(Pipe in_pipe, Pipe out_pipe){
		in_pipe_ = in_pipe;
		out_pipe_ = out_pipe;
	}
	
	public void start(){
		transform();
	}

	abstract protected void transform();
	
}
