
public class ReverseArray {

	public void reverse(int[] a) {
		int i = 0;
		int j = a.length - 1;
		while(i < j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			
			i++;
			j--;
		}
	}
	
	public void printArray(int[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	public static void main(String[] args) {
		ReverseArray ra = new ReverseArray();
		int a[] = {1,2,5,3,4,6,10,9,8}; //8 9 10 6 4 3 5 2 1
		ra.reverse(a);
		ra.printArray(a);
		System.out.println();
		int b[] = {2,5,3,4,6,10,9,8}; //8 9 10 6 4 3 5 2
		ra.reverse(b);
		ra.printArray(b);
	}

}
