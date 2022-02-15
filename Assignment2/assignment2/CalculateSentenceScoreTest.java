package assignment2;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class CalculateSentenceScoreTest {
    
    // Simple test of expected input
    @Test
	public void testSimpleExpected() {
        
        // Creating an input sentence and various word scores
		Map<String, Double> wordScores = new HashMap<>();
        Double negDouble1 = -1.0;
        Double negDouble2 = -0.3;
        wordScores.put("dog", (Double) 1.0);
        wordScores.put("cake", negDouble1);
        wordScores.put("fun", negDouble2);
        wordScores.put("cool", (Double) 0.6);
        String sentence = "dog cake fun cool";
		
        // Analyze sentiment of sentence
		double result = Analyzer.calculateSentenceScore(wordScores, sentence);
		
        // Check results. Typecasting to avoid deprecation
		assertEquals((Double) 0.075, (Double) result);
	}

    // Test case with repeated words in sentence
    @Test
	public void testRepeatedWords() {
        
        // Creating an input sentence and various word scores
		Map<String, Double> wordScores = new HashMap<>();
        Double negDouble1 = -1.0;
        Double negDouble2 = -0.3;
        wordScores.put("dog", (Double) 1.0);
        wordScores.put("cake", negDouble1);
        wordScores.put("fun", negDouble2);
        wordScores.put("cool", (Double) 0.6);
        String sentence = "dog dog fun cool";
		
        // Analyze sentiment of sentence
		double result = Analyzer.calculateSentenceScore(wordScores, sentence);
		
        // Check results. Typecasting to avoid deprecation
		assertEquals((Double) 0.575, (Double) result);
	}

    // Test case with words in sentence not starting with letters
    @Test
	public void testNotLetters() {
        
        // Creating an input sentence and various word scores
		Map<String, Double> wordScores = new HashMap<>();
        Double negDouble1 = -1.0;
        Double negDouble2 = -0.3;
        wordScores.put("dog", (Double) 1.0);
        wordScores.put("cake", negDouble1);
        wordScores.put("fun", negDouble2);
        wordScores.put("cool", (Double) 0.6);
        String sentence = "dog ?cake ?fun cool";
		
        // Analyze sentiment of sentence
		double result = Analyzer.calculateSentenceScore(wordScores, sentence);
		
        // Check results. Typecasting to avoid deprecation
		assertEquals((Double) 0.8, (Double) result);
	}

    // Test case with words not in word scores
    @Test
	public void testWordsNotInMap() {
        
        // Creating an input sentence and various word scores
		Map<String, Double> wordScores = new HashMap<>();
        wordScores.put("dog", (Double) 1.0);
        wordScores.put("cool", (Double) 0.6);
        String sentence = "dog cake fun cool";
		
        // Analyze sentiment of sentence
		double result = Analyzer.calculateSentenceScore(wordScores, sentence);
		
        // Check results. Typecasting to avoid deprecation
		assertEquals((Double) 0.4, (Double) result);
	}

    // Test case with sentence having capitalized words.
    @Test
	public void testCapitalizedWords() {
        
        // Creating an input sentence and various word scores
		Map<String, Double> wordScores = new HashMap<>();
        Double negDouble1 = -1.0;
        Double negDouble2 = -0.3;
        wordScores.put("dog", (Double) 1.0);
        wordScores.put("cake", negDouble1);
        wordScores.put("fun", negDouble2);
        wordScores.put("cool", (Double) 0.6);
        String sentence = "doG cAke FUN cOoL";
		
        // Analyze sentiment of sentence
		double result = Analyzer.calculateSentenceScore(wordScores, sentence);
		
        // Check results. Typecasting to avoid deprecation
		assertEquals((Double) 0.075, (Double) result);
	}

    // Test case when the input Map is null
    @Test
	public void testInputMapNull() {
        
        // Creating an input sentence and various word scores
		Map<String, Double> wordScores = null;
        String sentence = "dog cake fun cool";
		
        // Analyze sentiment of sentence
		double result = Analyzer.calculateSentenceScore(wordScores, sentence);
		
        // Check results. Typecasting to avoid deprecation
		assertEquals((Double) 0.0, (Double) result);
	}

    // Test case when the input Map is empty.
    @Test
	public void testInputMapEmpty() {
        
        // Creating an input sentence and various word scores
		Map<String, Double> wordScores = new HashMap<>();
        String sentence = "dog cake fun cool";
		
        // Analyze sentiment of sentence
		double result = Analyzer.calculateSentenceScore(wordScores, sentence);
		
        // Check results. Typecasting to avoid deprecation
		assertEquals((Double) 0.0, (Double) result);
	}
    
    // Test case when the input sentence is null
    @Test
	public void testInputSentenceNull() {
        
        // Creating an input sentence and various word scores
		Map<String, Double> wordScores = new HashMap<>();
        Double negDouble1 = -1.0;
        Double negDouble2 = -0.3;
        wordScores.put("dog", (Double) 1.0);
        wordScores.put("cake", negDouble1);
        wordScores.put("fun", negDouble2);
        wordScores.put("cool", (Double) 0.6);
        String sentence = null;
		
        // Analyze sentiment of sentence
		double result = Analyzer.calculateSentenceScore(wordScores, sentence);
		
        // Check results. Typecasting to avoid deprecation
		assertEquals((Double) 0.0, (Double) result);
	}

    // Test case when the input sentence is empty
    @Test
	public void testInputSentenceEmpty() {
        
        // Creating an input sentence and various word scores
		Map<String, Double> wordScores = new HashMap<>();
        Double negDouble1 = -1.0;
        Double negDouble2 = -0.3;
        wordScores.put("dog", (Double) 1.0);
        wordScores.put("cake", negDouble1);
        wordScores.put("fun", negDouble2);
        wordScores.put("cool", (Double) 0.6);
        String sentence = "";
		
        // Analyze sentiment of sentence
		double result = Analyzer.calculateSentenceScore(wordScores, sentence);
		
        // Check results. Typecasting to avoid deprecation
		assertEquals((Double) 0.0, (Double) result);
	}

    // Test case when the the input sentence does not contain any valid words.
    @Test
	public void testInputSentenceInvalid() {
        
        // Creating an input sentence and various word scores
		Map<String, Double> wordScores = new HashMap<>();
        Double negDouble1 = -1.0;
        Double negDouble2 = -0.3;
        wordScores.put("dog", (Double) 1.0);
        wordScores.put("cake", negDouble1);
        wordScores.put("fun", negDouble2);
        wordScores.put("cool", (Double) 0.6);
        String sentence = "?dog ?cake ?fun ?cool";
		
        // Analyze sentiment of sentence
		double result = Analyzer.calculateSentenceScore(wordScores, sentence);
		
        // Check results. Typecasting to avoid deprecation
		assertEquals((Double) 0.0, (Double) result);
	}
}
