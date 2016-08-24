package pipeandfilter;

public abstract class Filter implements Runnable {

	protected Pipe in_pipe_;
	protected Pipe out_pipe_;
	private boolean started_;
	
	public Filter(Pipe in_pipe, Pipe out_pipe){
		in_pipe_ = in_pipe;
		out_pipe_ = out_pipe;
	}
	
	public void start(){
		if(!started_){
			started_ = true;
			Thread thread = new Thread(this);
			thread.start();
		}
	}
	
	public void stop(){
		started_ = false;
	}
	
	public void run(){
		transform();
	}
	
	abstract protected void transform();
	
}
