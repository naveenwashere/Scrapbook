import java.util.Arrays;

public class StringEqualityChecker {

	public boolean areEqual(String str1, String str2) {
		// Validations
		if (str1 == null && str2 == null) {
			return false;
		}
		
		if (str1 != null && str2 == null) {
			return false;
		}

		if (str2 != null && str1 == null) {
			return false;
		}

		if (str1.length() != str2.length()) {
			return false;
		}
		// If both strings are equal then requirement satisfies
		if (str1.equals(str2)) {
			return true;
		}

		char[] strChar1 = str1.toCharArray();
		char[] strChar2 = str2.toCharArray();
		Arrays.sort(strChar1);
		Arrays.sort(strChar2);

		boolean areEqual = true;
		for (int i = 0; i < strChar1.length; i++) {
			if (strChar1[i] != strChar2[i]) {
				areEqual = false;
				break;
			}
		}
		return areEqual;
	}

	public static void main(String []args) {
		String str1 = "aamskke";
		String str2 = "eaasmkk";
		StringEqualityChecker sec = new StringEqualityChecker();
		System.out.println("Strings are: " + (sec.areEqual(str1, str2) ? "Equal" : "Not Equal"));
	}
}