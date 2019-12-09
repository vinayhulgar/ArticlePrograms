import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateComposition2 {
	
	public static void main(String[] args) {
		final List<String> items = new ArrayList<String>();
		items.add("Groovy");
		items.add("Gradle");
		items.add("Grails");
		items.add("Micronaut");
		items.add("Java");
		items.add("Kotlin");
		
		final List<String> grtStuff = items.stream()
				.filter(startsWith("Gr").or(startsWith("M")))
				.collect(Collectors.toList());
		
		 assert grtStuff.size() == 4 : "gr8Stuff contains 4 items";
	     assert grtStuff.contains("Groovy");
	     assert grtStuff.contains("Gradle");
	     assert grtStuff.contains("Grails");
	     assert grtStuff.contains("Micronaut");
	}
	
	private static Predicate<String> startsWith(final String begin){
		return s -> s.startsWith(begin);
	}
	
}
