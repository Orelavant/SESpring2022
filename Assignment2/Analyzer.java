/** 
 * This class contains the methods used for conducting a simple sentiment analysis.
 */

import java.util.*;
import java.io.*;

public class Analyzer {
	
	/**
	 * This method reads sentences from the input file, creates a Sentence object
	 * for each, and returns a Set of the Sentences.
	 * 
	 * @param filename Name of the input file to be read
	 * @return Set containing one Sentence object per sentence in the input file
	 */
	public static Set<Sentence> readFile(String filename) throws IllegalArgumentException {
		HashSet<Sentence> sentences = new HashSet<>();

		try {
			/* Read-in Code modified: https://www.tutorialspoint.com/how-to-read-the-data-from-a-c
			*  sv-file-in-java#:~:text=We%20can%20read%20a%20CSV,by%20using%20an%20appropriate%20index.
			*/ 
			String delimiter = " ";
			File file = new File(filename);
			FileReader fr = new FileReader(file);
        	BufferedReader br = new BufferedReader(fr);
			String line = "";
			String[] tempArr;

			// Get score and text from current line. Also check for errors.
			while((line = br.readLine()) != null) {
				tempArr = line.split(delimiter);

				// Check for score that is not an integer (double or not there)
				int score = 0;
				try {
					score = Integer.parseInt(tempArr[0]);
				} catch (NumberFormatException e) {
					continue;
				}

				// Check for score outside range
				if (score > 2 || score < -2) {
					continue;
				}

				// Create text from line
				String[] textArr = Arrays.copyOfRange(tempArr, 1, tempArr.length);
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < textArr.length; i++) {
					sb.append(textArr[i]+" ");
				}
				String text = sb.toString();

				// Check if text is null
				if (text == null) {
					continue;
				}

				// Create sentence and add to set
				Sentence sentence = new Sentence(score, text);
				sentences.add(sentence);
        	}
			fr.close();
			br.close();
		} catch (IOException e) {
			throw new IllegalArgumentException();
		}

		return sentences;
	}

	/**
	 * This method calculates the weighted average for each word in all the Sentences.
	 * This method is case-insensitive and all words should be stored in the Map using
	 * only lowercase letters.
	 * 
	 * @param sentences Set containing Sentence objects with words to score
	 * @return Map of each word to its weighted average
	 */
	public static Map<String, Double> calculateWordScores(Set<Sentence> sentences) {
		if (sentences == null || sentences.isEmpty()) {
			return new HashMap<>();
		}

		// Track word counts and sentiment sums to calculate word sentiments.
		HashMap<String, Integer> sentimentSums = new HashMap<>();
		HashMap<String, Integer> wordCounts = new HashMap<>();
		HashMap<String, Double> sentiments = new HashMap<>();

		// For all the words, calculate priors for their sentiment.
		for (Sentence sentence : sentences) {
			if (sentence == null || sentence.getText() == null || sentence.getText().equals("") || 
				sentence.getScore() > 2 || sentence.getScore() < -2) {
				continue;
			}
			String[] textArr = sentence.getText().split(" ");

			for (String word : textArr) {
				// Convert to lowercase and check if word starts with a letter/is empty
				word = word.toLowerCase();
				if (word.equals("") || !Character.isLetter(word.charAt(0))) {
					continue;
				}

				// Add/update wordcounts and sentimentSums
				if (!wordCounts.containsKey(word)) {
					wordCounts.put(word, 1);
					sentimentSums.put(word, sentence.getScore());
				} else {
					wordCounts.put(word, wordCounts.get(word) + 1);
					sentimentSums.put(word, sentimentSums.get(word) + sentence.getScore());
				}
			}
		}

		// For all the words in wordCounts, calculate  their sentiment and add it to the hashmap.
		for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
			String word = entry.getKey();
			Integer wordCount = entry.getValue();
			sentiments.put(word, (double) sentimentSums.get(word) / wordCount);
		}

		return sentiments;
	}
	
	/**
	 * This method determines the sentiment of the input sentence using the average of the
	 * scores of the individual words, as stored in the Map.
	 * This method is case-insensitive and all words in the input sentence should be
	 * converted to lowercase before searching for them in the Map.
	 * 
	 * @param wordScores Map of words to their weighted averages
	 * @param sentence Text for which the method calculates the sentiment
	 * @return Weighted average scores of all words in input sentence
	 */
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {
		// Check for errors
		if (wordScores == null || wordScores.isEmpty() || sentence == null || sentence.isEmpty()) {
			return 0;
		}
		String[] textArr = sentence.split(" ");
		boolean validSentence = false;
		for (String word : textArr) {
			if (Character.isLetter(word.charAt(0))){
				validSentence = true;
				break;
			}
		}
		if (!validSentence) {
			return 0;
		}

		// Calculate sentence score
		double scoreSum = 0;
		int wordCount = 0;
		for (String word : textArr) {
			word = word.toLowerCase();
			if (!Character.isLetter(word.charAt(0))) {
				continue;
			}
			if (wordScores.containsKey(word)) {
				scoreSum = scoreSum + wordScores.get(word);
			}
			wordCount++;
		}


		return scoreSum / wordCount;
	}
	
	public static void main(String[] args) {
		/*
		 * Implement this method in Part 4
		 */
		Set<Sentence> sentences = readFile("reviews.txt");

		Map<String, Double> wordScores =  calculateWordScores(sentences);
	}

}
