/*package whatever //do not write package name here */

import java.util.*;
import java.io.*;

// Using HashMap

// T = O(n);
// S = O(n);  where n is distinct characters
class GFG {
	public static void main (String[] args) {
		String s = "harshverma";
		
		Map<Character, Integer> charCount = new HashMap<Character, Integer>();
		for(int i=0; i<s.length(); i++) {
		    char key = s.charAt(i);
		    if (!charCount.containsKey(key))
		        charCount.put(key, 1);
		    else
		        charCount.put(key, charCount.get(key)+1 ); 
		}
		
		System.out.println(charCount);
	}
}

// Using Java 8 - Streams

// T = O(n);
// S = O(n);  where n is distinct characters
class GFG {
	public static void main (String[] args) {
		String input = "harshverma";
        Map<Character, Long> characterCount = input.chars()  // Change to int stream
                .mapToObj(c -> (char) c)
		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));	// Grouping by characters & counting its no.s
                // .collect(Collectors.groupingBy(c -> c, Collectors.counting()));	
                
		System.out.println(characterCount);
	}
}

