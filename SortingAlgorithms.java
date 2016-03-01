import java.util.Arrays;
import java.util.Collections;

public class SortingAlgorithms {
	
	/**
	 * 	Stable
		O(1) extra space
		O(n2) comparisons and swaps
		Adaptive: O(n) when nearly sorted
	 * @param a
	 */
	public void bubbleSort(int[] a) {
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a.length-1; j++) {
				if(a[j] > a[j+1]) {
					int x = a[j];
					a[j] = a[j+1];
					a[j+1] = x;
				}
			}
		}
		printArray(a);
	}
	
	/**
	 * 	Stable
		O(1) extra space
		O(n2) comparisons and swaps
		Adaptive: O(n) time when nearly sorted
		Very low overhead
	 * @param a
	 */
	public void insertionSort(int[] a) {
		for(int i = 1; i < a.length; i++) {
			for(int j = i; j > 0; j--) {
				if(a[j] < a[j-1]) {
					int x = a[j];
					a[j] = a[j-1];
					a[j-1] = x;
				}
			}
		}
		printArray(a);
	}
	
	/**
	 * Select the first element, then iterate over the rest of the elements.
	 * Find the smallest element and then swap.
	 * 	Not stable
		O(1) extra space
		Θ(n2) comparisons
		Θ(n) swaps
		Not adaptive
	 * @param a
	 */
	public void selectionSort(int[] a) {
		for(int i = 0; i < a.length; i++) {
			//Assume that the ith element is the smallest as of now
			int k = i;
			for(int j = i+1; j < a.length; j++) {
				if(a[j] < a[k]) {
					k = j;
				}
			}
			int x = a[i];
			a[i] = a[k];
			a[k] = x;
		}
		printArray(a);
	}
	
	public void mergeSort(int[] a) {
		
		printArray(a);
	}
	
	public void quickSort(int[] a) {
		
		printArray(a);
	}
	
	public void printArray(int[] a) {
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int a[] = {23,5,23,1,7,12,3,34,0};
		SortingAlgorithms sa = new SortingAlgorithms();
		System.out.println("Bubble Sort: "); sa.bubbleSort(a);
		int b[] = {1,5,3,2,10,6,7,9,5,8,4};
		System.out.println("Insertion Sort: "); sa.insertionSort(b);
		int c[] = {1,5,3,2,10,6,7,9,5,8,4};
		System.out.println("Selection Sort: "); sa.selectionSort(c);
		int d[] = {1,5,3,2,10,6,7,9,5,8,4};
		System.out.println("Merge Sort: "); sa.mergeSort(d);
		int e[] = {1,5,3,2,10,6,7,9,5,8,4};
		System.out.println("Quick Sort: "); sa.quickSort(e);
		
		String[] splits = {"Hello", "World"};
		
		Arrays.sort(splits, Collections.reverseOrder());
		
		for(int i = 0; i < splits.length; i++){
			System.out.print(splits[i] + " ");
		}
		System.out.println();
	}

}
