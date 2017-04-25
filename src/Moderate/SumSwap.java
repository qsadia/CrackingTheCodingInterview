package Moderate;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SumSwap {

	public List<Integer> getValues(int[] a, int[] b) {
		if (a.length == 0 || b.length == 0) {
			throw new IllegalArgumentException();
		}

		if (a.length < b.length) {
			getValues(b, a);
		}

		List<Integer> answer = new LinkedList<Integer>();

		int sumA = getSum(a);
		int sumB = getSum(b);

		// put one of the arrays in a set
		Set<Integer> bSet = new HashSet<Integer>();
		for (int v: b) {
			bSet.add(v);
		}

		System.out.println("Sums: a = " + sumA + " b = " + sumB);
		for (int v: a) {
			int aSumWithout = sumA - v;
			int bSumWith= sumB + v;
			int need = (bSumWith - aSumWithout) / 2;
			System.out.println("Sums: a = " + aSumWithout + " b = " + bSumWith + " need = " + need);
			if (bSet.contains(need)) {
				answer.add(v);
				answer.add(need);
				break;
			}
		}

		return answer;
	}

	private int getSum(int[] a) {
		int sum = 0;

		for (int i: a) {
			sum += i;
		}

		return sum;
	}

	public static void main(String[] args) {
		int[] a = new int[] {4,1,2,1,1,2};
		int[] b = new int[] {3,6,3,3};

		SumSwap s = new SumSwap();
		List<Integer> l = s.getValues(a,b);
		for (int v: l) {
			System.out.print(v + " ");
		}

	}

}
