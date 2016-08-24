package pipeandfilter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Output extends Filter {

	private File out_file_;

	public Output(Pipe in_pipe, File out_file) {
		super(in_pipe, null);
		out_file_ = out_file;
	}

	protected void transform() {
		ArrayList<String> data = in_pipe_.read();

		try {
			writeToFile(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		displayOutput(data);
	}

	private void writeToFile(ArrayList<String> data) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(out_file_));

		for(int i =0; i<data.size(); i++){
			bw.write(data.get(i));
		}
		bw.close();
	}

	private void displayOutput(ArrayList<String> data) {
		for(int i =0; i<data.size(); i++){
			System.out.println(data.get(i));
		}
	}

}
