import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetDifference {

	public static void main(String[] args) {
		SetDifference sd = new SetDifference();
		int setOne[] = {2, 8};
		int setTwo[] = {4, 14};
		//setOne - setTwo = 2, 3, 9, 10, 11, 12, 13, 14
		sd.findDifferenceInSets(setOne, setTwo);
	}

	private void findDifferenceInSets(int[] setOne, int[] setTwo) {
		int setOneElements[] = new int[(setOne[1] - setOne[0]) + 1];
		int setTwoElements[] = new int[(setTwo[1] - setTwo[0]) + 1];
		
		for(int i = setOne[0]; i <= setOne[1]; i++) {
			int index = i - setOne[0];
			setOneElements[index] = i;
		}
		Arrays.sort(setOneElements);
		
		System.out.println("Set One Elements: ");
		for(int i = 0; i <= setOneElements.length - 1; i++) {
			System.out.print(setOneElements[i] + " ");
		}
		
		System.out.println();
		
		for(int i = setTwo[0]; i <= setTwo[1]; i++) {
			int index = i - setTwo[0];
			setTwoElements[index] = i;
		}
		Arrays.sort(setTwoElements);
		
		System.out.println("Set Two Elements: ");
		for(int i = 0; i <= setTwoElements.length - 1; i++) {
			System.out.print(setTwoElements[i] + " ");
		}
		
		System.out.println();

		Set<Integer> finalSet = new HashSet<Integer>();
		
		//If doing setOne - setTwo, i.e., everything in setOne that's not in setTwo -> O(n2)
		//Can be done using the MERGE logic of Merge Sort
		for(int i = 0; i < setOneElements.length - 1; i++) {
			boolean isFoundinSetTwo = false;
			for(int j = 0; j < setTwoElements.length - 1; j++) {
				if(setOneElements[i] == setTwoElements[j]) {
					isFoundinSetTwo = true;
				}
			}
			if(!isFoundinSetTwo) {
				finalSet.add(setOneElements[i]);
			}
		}
		
		System.out.println("setOne - setTwo = " + finalSet);
		
		validateResult();
		
	}

	private void validateResult() {
		//Validation code using java.util.Set code
		Set<Integer> test1 = new HashSet<Integer>();
		test1.add(2);
		test1.add(3);
		test1.add(4);
		test1.add(5);
		test1.add(6);
		test1.add(7);
		test1.add(8);

		Set<Integer> test2 = new HashSet<Integer>();
		test2.add(4);
		test2.add(5);
		test2.add(6);
		test2.add(7);
		test2.add(8);
		test2.add(9);
		test2.add(10);
		test2.add(11);
		test2.add(12);
		test2.add(13);
		test2.add(14);

		test1.removeAll(test2);
		System.out.println("setOne - setTwo = " + test1);
	}

}
