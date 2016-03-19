
public class PalindromeRecursion {

	public boolean isPalindrome(String str) {
		return validatePalindrome(0, str.length(), str);
	}
	
	private boolean validatePalindrome(int i, int length, String str) {
		boolean isAMatch = true;
		if((i+1) != length/2) {
			isAMatch = validatePalindrome(i+1, length, str);
			//Once we receive false, then cut short the statements below
			if(!isAMatch) {
				return false;
			}
		} 
		
		if (str.charAt(i) == str.charAt(length - 1 - i)) {
			return isAMatch && true;
		} else {
			return isAMatch && false;
		}
	}

	public static void main(String[] args) {
		String str = "abia";
		PalindromeRecursion pr = new PalindromeRecursion();
		if(pr.isPalindrome(str)) {
			System.out.println("Is Palindrome"); 
		} else {
			System.out.println("Is not!");
		}
	}

}
