package Moderate;

import java.util.LinkedList;
import java.util.List;

public class DivingBoard {

	public List<Integer> getAllLengths(int k, int length1, int length2) {
		List<Integer> lengths = new LinkedList<Integer>();

		for (int numLength1 = 0; numLength1 <= k; numLength1++) {
			int numLength2 = k - numLength1;
			lengths.add(numLength1 * length1 + numLength2 * length2);
		}

		return lengths;
	}

	public static void main(String[] args) {
		DivingBoard d = new DivingBoard();
		List<Integer> answer = d.getAllLengths(7, 5, 10);
		for (int l: answer) {
			System.out.print(l +  " ");
		}
	}

}
