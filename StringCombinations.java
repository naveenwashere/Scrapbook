public class StringCombinations {

	private StringBuilder output = new StringBuilder();
	private final String inputstring;

	public StringCombinations(final String str) {
		inputstring = str;
		System.out.println("The input string  is  : " + inputstring);
	}

	public void showPermutations() {
		showPermutations(0);
	}

	private void showPermutations(int start) {
		for (int i = start; i < inputstring.length(); i++) {
			output.append(inputstring.charAt(i));
			System.out.println(output);
			if (i < inputstring.length()) {
				showPermutations(i + 1);
			}
			output.setLength(output.length() - 1);
		}
	}

	public static void main(String[] args) {
		String str = "wxyz";
		StringCombinations sp = new StringCombinations(str);
		sp.showPermutations();
	}

}
