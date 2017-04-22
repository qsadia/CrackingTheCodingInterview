package Moderate;

import java.util.Stack;

public class EngishInteger {

	private final String[] small = {
			"zero", "one", "two", "three", "four",
			"five", "six", "seven", "eight", "nine",
			"ten", "eleven", "twelve", "thirteen", "fourteen",
			"fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
	};

	private final String[] tens = {
			"", "ten", "twenty", "thirty", "forty",
			"fifty", "sixty", "seventy", "eighty", "ninety"
	};

	private final String[] big = {
			"", "thousand", "million", "billion"
	};

	public String convertToEnglish(int num) {
		if (num < 0) {
			return "negative " + convertToEnglish(-1 * num);
		}

		if (num < 20) {
			return small[num];
		}

		StringBuilder sb = new StringBuilder();
		Stack<String> answer = new Stack<String>();

		int chunkCount = 0;
		while (num > 0) {
			if (num % 1000 != 0) {
				String chunk = convertLessThanThousand(num % 1000) + " " + big[chunkCount];
				answer.push(chunk);
			}
			num /= 1000;
			chunkCount++;
		}

		while (!answer.isEmpty()) {
			sb.append(answer.pop() + " ");
		}

		return sb.toString();
	}

	private String convertLessThanThousand(int num) {
		Stack<String> stack = new Stack<String>();
		StringBuilder sb = new StringBuilder();

		if (num > 99) {
			sb.append(small[num / 100]).append(" ");
			sb.append("hundred ");
			num = num % 100;
			if (num > 0) {
				sb.append("and ");
			}
		}

		if (num > 20) {
			int rem = num % 10;
			num /= 10;
			sb.append(tens[num]).append(" ");
			if (rem > 0) {
				sb.append(small[rem]).append(" ");
			}
		}
		else if (num > 0){
			sb.append(small[num]);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		EngishInteger e = new EngishInteger();
		System.out.println(e.convertToEnglish(1689987600));
	}

}
