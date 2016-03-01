
public class MergeSort {

	int[] helper;
	
	public static void main(String[] args) {
		int[] numbers = { 5, 5, 6, 6, 4, 4, 5, 5, 4, 4, 6, 6, 5, 5 };
		MergeSort ms = new MergeSort();
		ms.sort(numbers);
		ms.printArray(numbers);
	}
	
	public void printArray(int[] numbers) {
		for(int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
	}
	
	private void sort(int[] numbers) {
		helper = new int[numbers.length];
		mergeSort(0, numbers.length-1, numbers);
	}

	private void mergeSort(int low, int high, int[] numbers) {
		if(low < high) {
			int middle = low + (high-low)/2;
			mergeSort(low, middle, numbers);
			mergeSort(middle+1, high, numbers);
			merge(low, middle, high, numbers);
		}
	}

	private void merge(int low, int middle, int high, int[] numbers) {
		
		// Copy both parts into the helper array
	    for (int i = low; i <= high; i++) {
	      helper[i] = numbers[i];
	    }
	    
		int i = low;
		int j = middle + 1;
		int k = low;
		while(i <= middle && j <= high) {
			if(helper[i] <= helper[j]) {
				numbers[k] = helper[i];
				i++;
			} else {
				numbers[k] = helper[j];
				j++;
			}
			k++;
		}
		
		//Copy whatever's left in the left sub-array to the main one
		while(i <= middle) {
			numbers[k] = helper[i];
			i++;
			k++;
		}
		
		//Copy whatever's left in the right sub-array to the main one
		while(j <= high) {
			numbers[k] = helper[j];
			j++;
			k++;
		}
		
	}

}
