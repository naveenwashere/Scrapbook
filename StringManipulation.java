
public class StringManipulation {

	public static void main(String[] args) {
		String str2 = "Hellos";
		System.out.println(str2.hashCode());
		
		String str1 = new String("Hellos");
		System.out.println(str1.hashCode());
		
		//str1 = str1.intern();
		
		if(str1 == str2) {
			System.out.println("Equal");
		}
		
		str2.concat("KumarHello");
		
		System.out.println(str2.hashCode());

		str2 = str2.concat("KumarHelloo");
		
		System.out.println(str2.hashCode());
	}

}
