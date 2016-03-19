public class StringPermutations {

	public static void main(String[] args) {
		String str = "wxyz";
		StringPermutations sp = new StringPermutations();
		sp.permutation(str);
	}

	public void permutation(String str) {
		permutation("", str);
	}

	private void permutation(String prefix, String str) {
		int n = str.length();
		if (n == 0)
			System.out.println(prefix);
		else {
			for (int i = 0; i < n; i++) {
				//System.out.println("Prefix: " + prefix + ", String: " + str);
				permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
			}
		}
	}

}
