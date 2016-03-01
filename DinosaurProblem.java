import java.util.Arrays;

public class DinosaurProblem {
	
	public int largestNumOfDinosAliveAtOneTime(int[] dinos) {
		int dinoCount[] = new int[dinos.length];
		for (int i = 0; i <= dinos.length / 2; i=i+2) {
			for (int j = 0; j <= dinos.length / 2; j=j+2) {
				if (dinosAliveAtSameTime(dinos[i], dinos[i + 1], dinos[j], dinos[j + 1])) {
					dinoCount[i]++;
				}
			}
		}
		Arrays.sort(dinoCount);
		return dinoCount[dinoCount.length - 1];
	}

	public boolean dinosAliveAtSameTime(int a1, int a2, int b1, int b2) {
		// Both take birth and die at same time
		if (a1 == b1 && a2 == b2) {
			return true;
		}
		// Both take birth at same time and die at different times
		if ((a1 == b1 && a2 < b2) || (a1 == b1 && a2 > b2)) {
			return true;
		}
		// Both take birth at different times and die at same times
		if ((a1 < b1 && a2 == b2) || (a1 > b1 && a2 == b2)) {
			return true;
		}
		// First is born after and dies before second
		if (a1 > b1 && a2 < b2) {
			return true;
		}
		// First is born before and dies before second, but after second is born
		if (a1 < b1 && a2 < b2) {
			return true;
		}
		// First is born after second and dies after second
		if (a1 > b1 && a1 < b2 && a2 > b2) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		int dinos[] = { -80000, -79950, 20, 70, 22, 60, 58, 65, 1950, 2004, 25, 30, -79990, -79960, 20, 60 };
		DinosaurProblem dp = new DinosaurProblem();
		System.out.println(dp.largestNumOfDinosAliveAtOneTime(dinos));
	}
}
