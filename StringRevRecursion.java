public class StringRevRecursion {

	public String reverse(String str) {
		int strLen = str.length();
		if(strLen == 1) {
			return str;
		}
		String lastChar = str.substring(strLen-1);
		return lastChar + reverse(str.substring(0, strLen-1));
	}
	
	public String reverseUsingCharAt(String str) {
		if(str.length() == 1) {
			return str;
		}
		return str.charAt(str.length() - 1) + reverseUsingCharAt(str.substring(0, str.length() -1));
	}
	
	public static void main(String[] args) {
		StringRevRecursion reverseStr = new StringRevRecursion();
		System.out.println("Reverse of the string: Naveen is " + reverseStr.reverse("Naveen"));
		System.out.println("Reverse of the string: Naveen is " + reverseStr.reverseUsingCharAt("Naveen"));
	}
}
