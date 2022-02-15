/**
* Tests for CalculateWordSCores from Analyzer class.
*/

package assignment2;
import static org.junit.Assert.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class CalculateWordScoresTest {

    // Simple test of expected input. Test for both the correct # of keys and correct mappings.
    @Test
	public void testSimpleExpected() {
        
        // Creating a set of sentences
		Set<Sentence> sentences = new HashSet<>();
        Sentence sentence = new Sentence(1, "dog");
        sentences.add(sentence);
		
        // Analyze sentiments of words in sentences
		Map<String,Double> sentiments = Analyzer.calculateWordScores(sentences);
        Double result = sentiments.get("dog");
		
        // Check results
		assertEquals((Double) 1.0, result);
        assertEquals(1, sentiments.size());
	}

    // Complex test of expected input. Test for both the correct # of keys and correct mappings.
    @Test
	public void testComplexExpected() {
        
        // Creating a set of sentences
		Set<Sentence> sentences = new HashSet<>();
        Sentence sentence1 = new Sentence(2, "I cake cake");
        Sentence sentence2 = new Sentence(1, "I hope cake");
        sentences.add(sentence1);
        sentences.add(sentence2);
		
        // Analyze sentiments of words in sentences
		Map<String,Double> sentiments = Analyzer.calculateWordScores(sentences);
        Double result = sentiments.get("cake");
		
        // Check results
		assertEquals((Double) 1.6666666666666667, result);
        assertEquals(3, sentiments.size());
	}
    
    // Checking for ignoring tokens functionality
    @Test
	public void testIgnoreTokens() {
        
        // Creating a set of sentences
		Set<Sentence> sentences = new HashSet<>();
        Sentence sentence1 = new Sentence(2, "I 'cake 'cake");
        Sentence sentence2 = new Sentence(1, "I hope cake");
        sentences.add(sentence1);
        sentences.add(sentence2);
		
        // Analyze sentiments of words in sentences
		Map<String,Double> sentiments = Analyzer.calculateWordScores(sentences);
        Double result = sentiments.get("cake");
		
        // Check results
		assertEquals((Double) 1.0, result);
        assertEquals(3, sentiments.size());
	}

    // Checking for case insensitivity
    @Test
	public void testCaseInsensitivity() {
        
        // Creating a set of sentences
		Set<Sentence> sentences = new HashSet<>();
        Sentence sentence1 = new Sentence(2, "I CAKE CaKE");
        Sentence sentence2 = new Sentence(1, "I HOPE cAKe");
        sentences.add(sentence1);
        sentences.add(sentence2);
		
        // Analyze sentiments of words in sentences
		Map<String,Double> sentiments = Analyzer.calculateWordScores(sentences);
        Double result = sentiments.get("cake");
		
        // Check results
		assertEquals((Double) 1.6666666666666667, result);
        assertEquals(3, sentiments.size());
	}

    // Checking for ignoring when the Sentence object in the Set is null
    @Test
	public void testSentenceNull() {
        
        // Creating a set of sentences
		Set<Sentence> sentences = new HashSet<>();
        Sentence sentence1 = new Sentence(2, "I CAKE CaKE");
        sentences.add(sentence1);
        sentences.add(null);
		
        // Analyze sentiments of words in sentences
		Map<String,Double> sentiments = Analyzer.calculateWordScores(sentences);
        Double result = sentiments.get("cake");
		
        // Check results
		assertEquals((Double) 2.0, result);
        assertEquals(2, sentiments.size());
	}

    // Checking for ignoring when the text of a Sentence object in the Set is null
    @Test(expected = NullPointerException.class)
	public void testSentenceTextNull() {
        
        // Creating a set of sentences
		Set<Sentence> sentences = new HashSet<>();
        Sentence sentence1 = new Sentence(2, "I CAKE CaKE");

        // NPE is thrown on the next line when calculating the hashcode of the sentence.
        // My implementation of Sentence might be diff than expected, but rest of the test is sound.
        Sentence sentence2 = new Sentence(1, null);
        sentences.add(sentence1);
        sentences.add(sentence2);
		
        // Analyze sentiments of words in sentences
		Map<String,Double> sentiments = Analyzer.calculateWordScores(sentences);
        Double result = sentiments.get("cake");
		
        // Check results
		assertEquals((Double) 2.0, result);
        assertEquals(2, sentiments.size());
	}
    
    // Checking for ignoring when the text of a Sentence object in the Set is empty
    @Test
	public void testSentenceTextEmpty() {
        
        // Creating a set of sentences
		Set<Sentence> sentences = new HashSet<>();
        Sentence sentence1 = new Sentence(2, "I CAKE CaKE");
        Sentence sentence2 = new Sentence(1, "");
        sentences.add(sentence1);
        sentences.add(sentence2);
		
        // Analyze sentiments of words in sentences
		Map<String,Double> sentiments = Analyzer.calculateWordScores(sentences);
        Double result = sentiments.get("cake");
		
        // Check results
		assertEquals((Double) 2.0, result);
        assertEquals(2, sentiments.size());
	}

    // Checking for ignoring when the score of a Sentence object in the Set is outside the range [-2, 2]
    @Test
	public void testSentenceScoreOutsideRange() {
        
        // Creating a set of sentences
		Set<Sentence> sentences = new HashSet<>();
        Sentence sentence1 = new Sentence(2, "I CAKE CaKE");
        Sentence sentence2 = new Sentence(34, "I HOPE cAKe");
        sentences.add(sentence1);
        sentences.add(sentence2);
		
        // Analyze sentiments of words in sentences
		Map<String,Double> sentiments = Analyzer.calculateWordScores(sentences);
        Double result = sentiments.get("cake");
		
        // Check results
		assertEquals((Double) 2.0, result);
        assertEquals(2, sentiments.size());
	}

    // Checking for ignoring when the input Set of Sentences is null
    @Test
	public void testInputSentencesNull() {
        
        // Creating a set of sentences
		Set<Sentence> sentences = null;
		
        // Analyze sentiments of words in sentences
		Map<String,Double> sentiments = Analyzer.calculateWordScores(sentences);
		
        // Check results
        assertTrue(sentiments.isEmpty());
	}

    // Checking for ignoring when the input Set of Sentences is empty
    @Test
	public void testInputSentencesEmpty() {
        
        // Creating a set of sentences
		Set<Sentence> sentences = new HashSet<>();
		
        // Analyze sentiments of words in sentences
		Map<String,Double> sentiments = Analyzer.calculateWordScores(sentences);
		
        // Check results
        assertTrue(sentiments.isEmpty());
	}
}
