package Moderate;

public class NumberSwapper {

	private int a;
	private int b;

	public NumberSwapper(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public String toString() {
		return "a = " + a + " b = " + b;
	}

	public void swap() {
		a = a + b;
		b = a - b;
		a = a - b;
	}

	public static void main(String[] args) {
		NumberSwapper n = new NumberSwapper(1, 100);
		System.out.println("Before " + n.toString());
		n.swap();
		System.out.println("After " + n.toString());
	}

}
