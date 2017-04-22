package Moderate;

/*
 * 10, and 5 * 2 contributes to 0s
 * Counting all multiples of 5 up to n gives the number of zeros
 * Note: numbers such as 25 = 5 * 5 are counted twice
 */
public class FactorialZeros {

	public int numZeros(int n) {
		int count = 0;

		// Go through all multiples of 5 and increase count
		for (int i = 5; n / i > 0; i *= 5) {
			count += n / i;
		}

		return count;
	}

	public static void main(String[] args) {
		FactorialZeros f = new FactorialZeros();
		System.out.println(f.numZeros(19));
	}

}
