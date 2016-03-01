
public class QuickSort {

	int[] numbers;
	
	public static void main(String[] args) {
		int[] test = { 5, 5, 6, 6, 4, 4, 5, 5, 4, 4, 6, 6, 5, 5 };
		QuickSort qs = new QuickSort();
		qs.sort(test);
		qs.printArray();
	}

	private void sort(int[] test) {
		if(test == null || test.length == 0) {
			return;
		}
		numbers = test;
		quickSort(0, test.length-1);
	}

	private void quickSort(int i, int j) {
		int low = i, high = j;
		int mid = low + (high - low) / 2;
		int pivot = numbers[mid];
		
		while(i <= j) {
			//while numbers[i] < pivot, increment i
			//Because we want to place all elements < pivot in one array
			while(numbers[i] < pivot) {
				i++;
			}
			
			//while numbers[j] > pivot, increment j
			//Because we want to place all elements > pivot in one array
			while(numbers[j] > pivot) {
				j--;
			}
			
			if(i <= j) {
				//Swap the elements on those positions
				swapNumbers(i, j);
				i++;
				j--;
			}
		}
		
		if(low < j) {
			quickSort(low, j);
		}
		if(i < high) {
			quickSort(i, high);
		}
	}

	private void swapNumbers(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	
	public void printArray() {
		for(int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
	}

}
