package Moderate;

import java.util.Arrays;

public class SmallestDifference {

	public int getSmallestDifference(int[] a, int[] b) {

		// Sort arrays
		Arrays.sort(a);
		Arrays.sort(b);

		int n = a.length;
		int m = b.length;

		int index1 = 0;
		int index2 = 0;
		int min = Integer.MAX_VALUE;

		while(index1 < n && index2 < m) {
			if (Math.abs(a[index1] - b[index2]) < min) {
				min = Math.abs(a[index1] - b[index2]);
			}

			// Move pointer for array with smaller value
			if (a[index1] < b[index2]) {
				index1++;
			}
			else {
				index2++;
			}
		}

		return min;
	}


	public static void main(String[] args) {
		int[] a = {1, 3, 15, 11, 2};
		int[] b = {23, 127, 235, 19, 8};
		SmallestDifference s = new SmallestDifference();
		System.out.println(s.getSmallestDifference(a, b));
	}

}
