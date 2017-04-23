package Moderate;

public class ContiguousSum {

	public int largestContiguousSum(int[] a) {
		int max = Integer.MIN_VALUE;
		int sum = 0;

		for (int i: a) {
			sum += i;
			max = Math.max(max, sum);
			if (sum < 0) {
				sum = 0;
			}
		}

		return max;
	}

	public static void main(String[] args) {
		ContiguousSum c = new ContiguousSum();

		int[] a = new int[] {-2, 8, -3, 2, 4, -10};
		System.out.println(c.largestContiguousSum(a));
	}

}
