import java.util.HashSet;
import java.util.Set;

public class PalindromeCounter {
	public int returnPalindromeCount(String str) {
		Set<String> listofPalindromes = new HashSet<String>();
		for(int i = 0; i < str.length()-1; i++) {
			for(int j = i; j < str.length()-1; j++) {
				String subStr = str.substring(i, j+1);
				System.out.println(subStr + " -> " + new StringBuffer(subStr).reverse().toString());
				if(subStr.length() == 1) {
					//System.out.println(subStr);
					listofPalindromes.add(subStr);
				}
				if(subStr.equals(new StringBuffer(subStr).reverse().toString())) {
					//System.out.println(subStr);
					listofPalindromes.add(subStr);
				}
			}	
		}
		return listofPalindromes.size();
	}

	public static void main(String[] args) {
		PalindromeCounter pc = new PalindromeCounter();
		System.out.println("No of Palindromes in this string are: " + pc.returnPalindromeCount("barbarabar"));
	}
}

