import java.util.HashSet;
import java.util.Set;

public class StringCombinations {

	private final String inputstring;
	
	Set<String> strings = new HashSet<String>();

	public StringCombinations(final String str) {
		inputstring = str;
		System.out.println("The input string  is \n" + inputstring);
	}

	public void permutation(String str) {
		permutation("", str);
		for(String stri : strings) {
			System.out.println(stri);
		}
	}

	private void permutation(String prefix, String str) {
		int n = str.length();
		if(!prefix.equals("")) {
			strings.add(prefix);
		}
		if (n == 0)
			return;
		else {
			for (int i = 0; i < n; i++) {
				//System.out.println("Prefix: " + prefix + ", String: " + str);
				permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
			}
		}
	}

	public static void main(String[] args) {
		String str = "wxyz";
		StringCombinations sp = new StringCombinations(str);
		sp.permutation(str);
	}

}
