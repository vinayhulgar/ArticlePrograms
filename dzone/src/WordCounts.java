import java.util.Arrays;
import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
	To demonstrate how to group a list of Strings by creating a WordCounts class which includes:

	getWordCounts – group a given sentence by its word’s counts
	getWordLength – group a given sentence by its word’s length
	getWordLength_List – group a given sentence by its words’ length, return it as a List
	getWordLength_Set – group a given sentence by its words’ length, return it as a Set
	getwordLength_String – group a given sentence by its words’ length and return it as a String
*/public class WordCounts {

	private String sentence;
	public String getSentence() {
		return sentence;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence.replaceAll("[;,.]", "");
		words = this.sentence.split(" ");
	}

	public String[] getWords() {
		return words;
	}

	public void setWords(String[] words) {
		this.words = words;
	}

	private String [] words;
	
	public WordCounts(String sentence) {
		super();
		setSentence(sentence);
	}
	
	
	public Map<String, Long> getWordCounts(){
		return Arrays.stream(words)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}
	
	
	public Map<Integer, List<String>> getWordLength(){
		return Arrays.stream(words)
				.collect(Collectors.groupingBy(String::length));
	}
	
	public Map<Integer, Collection<String>> getWordLength_Set(){
		return Arrays.stream(words)
				.collect(Collectors.groupingBy(String::length, Collectors.toCollection(TreeSet::new)));
	}
	
	public Map<Integer, List<String>> getWordLength_List(){
		return Arrays.stream(words)
				.collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toList()));
	}
	
	public Map<Integer, String> getWordLength_String(){
		return Arrays.stream(words)
				.collect(Collectors.groupingBy(String::length, Collectors.joining("|","[","]")));
	}
	
	public Map<Integer, IntSummaryStatistics> getWordLength_summarizingInt(){
		return Arrays.stream(words)
				.collect(Collectors.groupingBy(String::length, Collectors.summarizingInt(String::hashCode)));
	}
}
