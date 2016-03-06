
public class PrintPatternWithoutLoop {

	public static void main(String[] args) {
		PrintPatternWithoutLoop ppwl = new PrintPatternWithoutLoop();
		ppwl.printPattern(16, 5);
	}

	private void printPattern(int i, int j) {
		/*if(i > 0) {
			System.out.println(i-j);
			printPattern(i-j, j);
		}
		System.out.println(i);*/
		
		if(i == 0 || i < 0) {
			System.out.println(i);
			return;
		}
		System.out.println(i);
		
		printPattern(i-j, j);
		
		System.out.println(i);
	}

}
