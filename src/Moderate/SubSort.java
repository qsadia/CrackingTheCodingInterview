package Moderate;

import java.util.LinkedList;
import java.util.List;

public class SubSort {

	public List<Integer> getIndices(int[] a) {
		List<Integer> indices = new LinkedList<Integer>();
		if (a.length <= 1) {
			return indices;
		}
		// get left middle
		int leftMiddle = 0;
		for (int i = 1; i < a.length; i++) {
			if (a[i] < a[i-1]) {
				leftMiddle = i;
				break;
			}
		}

		// get right middle
		int rightMiddle = a.length - 1;
		for (int i = a.length - 2; i >= 0; i--) {
			if (a[i] > a[i+1]) {
				rightMiddle = i;
				break;
			}
		}

		// get left
		int leftMax = a[leftMiddle];
		int left = 0;
		for (int i = 0; i < leftMiddle; i++) {
			if (a[i] >= leftMax) {
				left = i;
				break;
			}
		}

		// get right
		int rightMin = a[rightMiddle];
		int right = a.length - 1;
		for (int i = a.length - 1; i >= rightMiddle; i--) {
			if (a[i] <= rightMin) {
				right = i;
				break;
			}
		}

		indices.add(left);
		indices.add(right);

		return indices;
	}

	public static void main(String[] args) {
		SubSort s = new SubSort();
		int[] a = new int[] {1,2,4,7,10,11,7,12,6,7,16,18,19};
		List<Integer> answer = s.getIndices(a);
		for (int i: answer) {
			System.out.print(i + " ");
		}

	}

}
