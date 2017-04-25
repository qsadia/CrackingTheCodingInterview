package Hard;

import java.util.Random;

public class Shuffle {

	public void shuffle(int[] deck) {

		for (int i = 51; i >= 0; i--) {
			int temp = deck[i];
			int swapIndex = getRandom(i+1);
			deck[i] = deck[swapIndex];
			deck[swapIndex] = temp;
		}

	}

	public int getRandom(int n) {
		Random rand = new Random();
		return rand.nextInt(n);
	}

	public static void main(String[] args) {

		int count = 1;
		int[] deck = new int[52];
		while (count <= 52) {
			deck[count-1] = count;
			count++;
		}

		Shuffle s = new Shuffle();
		s.shuffle(deck);

		for (int v: deck) {
			System.out.print(v + " ");
		}
	}

}
