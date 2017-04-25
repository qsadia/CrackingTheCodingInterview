package Moderate;

import java.util.Stack;
import java.util.StringTokenizer;

public class Calculator {

	public double compute(String expression) {

		Stack<Double> numbers = new Stack<Double>();
		Stack<Character> operands = new Stack<Character>();

		StringTokenizer st = new StringTokenizer(expression);

		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			if (token.equals("+")) {
				operands.push('+');
			}
			else if (token.equals("-")) {
				operands.push('-');
			}
			else if (token.equals("*")) {
				String temp = st.nextToken();
				numbers.push(numbers.pop() * Double.parseDouble(temp));
			}
			else if (token.equals("/")) {
				String temp = st.nextToken();
				numbers.push(numbers.pop() / Double.parseDouble(temp));
			}
			else {
				numbers.push(Double.parseDouble(token));
			}
		}

		while(!operands.isEmpty()) {
			char op = operands.pop();
			if (op == '+') {
				numbers.push(numbers.pop() + numbers.pop());
			}
			else if (op == '-') {
				numbers.push((-1 * numbers.pop()) - numbers.pop());
			}
		}

		return numbers.pop();
	}


	public static void main(String[] args) {
		Calculator c = new Calculator();
		String expr = "2 * 3 + 5 / 6 * 3 + 15";
		System.out.println(c.compute(expr));
	}

}
