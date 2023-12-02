/*package whatever //do not write package name here */

import java.util.*;
import java.io.*;

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
