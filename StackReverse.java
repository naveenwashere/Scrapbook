
public class StackReverse {

	public static void main(String[] args) {
		int a[] = {1,2,3,4};
		StackReverse sr = new StackReverse();
		System.out.println("Reversing stack - Normal Method:");
		sr.reverseStack(a);
		System.out.println("\nReveresing stack in-place:");
		sr.reverseStackInPlace(a);
	}

	private void reverseStackInPlace(int[] a) {
		int top = a.length;
		System.out.println("Existing Stack Contents:");
		for(int i = top-1; i >= 0; i--) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		
		reverseInPlace(a, top);
		
		System.out.println("Reversed Stack Contents:");
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	private void reverseInPlace(int[] a, int top) {
		if(top == 0) {
			return;
		}
		int topNum = a[--top];
		reverseInPlace(a, top);
		a[top] = topNum;
	}

	/*
	 * 1
	 * 2
	 * 3
	 * 4 <- top
	 */
	private void reverseStack(int[] a) {
		int top = a.length;
		System.out.println("Existing Stack Contents:");
		for(int i = top-1; i >= 0; i--) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		
		int stackReverse[] = new int[a.length];
		
		reverse(top, stackReverse, a);
		
		System.out.println("Reversed Stack Contents:");
		for(int i = 0; i < stackReverse.length; i++) {
			System.out.print(stackReverse[i] + " ");
		}
		System.out.println();
	}

	private void reverse(int top, int[] stackReverse, int[] a) {
		if(top == 0) {
			return;
		}
		reverse(--top, stackReverse, a);
		stackReverse[top] = a[top];
	}

}
