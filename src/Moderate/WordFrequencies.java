package Moderate;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class WordFrequencies {

	private Map<String, Integer> wordCount;

	public WordFrequencies(String book) {
		this.wordCount = new HashMap<String, Integer>();
		this.determineCounts(book);
	}

	public int getCount(String word) {
		if (wordCount.containsKey(word)) {
			return wordCount.get(word);
		}
		return 0;
	}

	public void printFrequencies() {
		for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
			System.out.println(entry.getKey() + ":\t" + entry.getValue());
		}
	}

	private void determineCounts(String book) {
		StringTokenizer st = new StringTokenizer(book);
		while (st.hasMoreTokens()) {
			String word = st.nextToken();
			if (isPunctuation(word.charAt(word.length() - 1))) {
				word = word.substring(0, word.length() - 1);
			}
			word = word.toLowerCase();
			wordCount.put(word, wordCount.containsKey(word) ? wordCount.get(word) + 1 : 1);
		}
	}

	private boolean isPunctuation(char c) {
		return c == '.'
				|| c == '!'
				|| c == '?'
				|| c == ','
				|| c == ':';
	}

	public static void main(String[] args) {
		String text = "Hello, this is a sentence. This is a test sentence to verify that the word frequencies table is populated correctly.";
		WordFrequencies w = new WordFrequencies(text);
		w.printFrequencies();
	}

}
