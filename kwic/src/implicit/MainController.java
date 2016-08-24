package implicit;

public class MainController {
	static String INVALID_USAGE = "Usage Error \nProper Usage: kwic.jar <input file> <filter file> <output file>";
	
	public static void main(String[] args) {
		
		checkUsage(args);
		String inputPath = args[0];
		String filterPath = args[1];
		String outputPath = args[2];
		
		//Read Inputs
		
		//Print and save Output
		
		//Testing
		System.out.println("KWIC IMPLICIT");
		System.out.println(inputPath);
		System.out.println(filterPath);
		System.out.println(outputPath);
	}
	
	public static void checkUsage(String[] args){
		if (args.length != 3) {
			System.out.println(INVALID_USAGE);
			System.exit(0);
		}
	}
}
