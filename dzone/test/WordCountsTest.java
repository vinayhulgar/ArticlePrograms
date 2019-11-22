import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class WordCountsTest {

	private WordCounts wordCounts;
    
    @Before
    public void setup() {
        wordCounts = new WordCounts("John likes beef, Mary likes beef, Tom likes beef; but Allen and Jerry hate beef.");
    }
 
     
    @Test
    public void getWordCounts() {   
    	setup();
        Map<String, Long> wc = wordCounts.getWordCounts();
        System.out.println(wc);
         
        assertEquals(1, wc.get("John").longValue());
        assertEquals(3, wc.get("likes").longValue());
        assertEquals(4, wc.get("beef").longValue());
        assertEquals(1, wc.get("Jerry").longValue());
    }
     
    @Test
    public void getWordLength() {
    	setup();
        Map<Integer, List<String>> wordlength = wordCounts.getWordLength();
         
        System.out.println(wordlength);
         
        assertEquals(3, wordlength.get(new Integer(3)).size());
        assertEquals(7, wordlength.get(new Integer(4)).size());
        assertEquals(5, wordlength.get(new Integer(5)).size());
         
    }
     
    @Test
    public void getWordLength_Set() {
    	setup();
    	Map<Integer, Collection<String>> wordlength = wordCounts.getWordLength_Set();       
        System.out.println(wordlength);
        assertEquals(3, wordlength.get(new Integer(3)).size());
        assertEquals(4, wordlength.get(new Integer(4)).size());
        assertEquals(3, wordlength.get(new Integer(5)).size());     
    }
     
    @Test
    public void getWordLength_List() {
    	setup();
    	Map<Integer, List<String>> wordlength = wordCounts.getWordLength_List();
        System.out.println(wordlength);
    }
     
    @Test
    public void getWordLength_String() {        
    	setup();
    	Map<Integer, String> wordlength = wordCounts.getWordLength_String();
         
        System.out.println(wordlength);
        assertEquals("[Tom|but|and]", wordlength.get(new Integer(3)));
        assertEquals("[John|beef|Mary|beef|beef|hate|beef]", wordlength.get(new Integer(4)));
        assertEquals("[likes|likes|likes|Allen|Jerry]", wordlength.get(new Integer(5)));
    }
     
    @Test
    public void getWordLength_summarizingInt() {
    	setup();
    	Map<Integer, IntSummaryStatistics> rets = wordCounts.getWordLength_summarizingInt();      
        System.out.println(rets);
    }

}
