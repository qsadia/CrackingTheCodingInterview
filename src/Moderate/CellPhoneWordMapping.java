package Moderate;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CellPhoneWordMapping {

	private Map<String, List<String>> numberToWords;
	private final Map<Character, Character> map = new HashMap<Character, Character>() {
		{
			put('a', '2');
			put('b', '2');
			put('c', '2');
			put('d', '3');
			put('e', '3');
			put('f', '3');
			put('g', '4');
			put('h', '4');
			put('i', '4');
			put('j', '5');
			put('k', '5');
			put('l', '5');
			put('m', '6');
			put('n', '6');
			put('o', '6');
			put('p', '7');
			put('q', '7');
			put('r', '7');
			put('s', '7');
			put('t', '8');
			put('u', '8');
			put('v', '8');
			put('w', '9');
			put('x', '9');
			put('y', '9');
			put('z', '9');
		}
	};


	public CellPhoneWordMapping(List<String> validWords) {
		numberToWords = new HashMap<String, List<String>>();
		mapWordsToNumber(validWords);
	}


	private void mapWordsToNumber(List<String> validWords) {
		for (String word: validWords) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < word.length(); i++) {
				sb.append(map.get(word.charAt(i)));
			}
			String number = sb.toString();
			if (numberToWords.containsKey(number)) {
				numberToWords.get(number).add(word);
			}
			else {
				List<String> list = new LinkedList<String>();
				list.add(word);
				numberToWords.put(number, list);
			}
		}
	}

	public List<String> getMatchingWords(String number) {
		List<String> words = new LinkedList<String>();

		if (numberToWords.containsKey(number)) {
			words = numberToWords.get(number);
		}

		return words;
	}



	public static void main(String[] args) {
		List<String> words = new LinkedList<String>();
		words.add("tree");
		words.add("used");
		words.add("hello");

		CellPhoneWordMapping c = new CellPhoneWordMapping(words);
		List<String> answer = c.getMatchingWords("8733");
		if (answer.isEmpty()) {
			System.out.print("No matching words.");
		}
		for (String word: answer) {
			System.out.print(word + " ");
		}

	}

}
