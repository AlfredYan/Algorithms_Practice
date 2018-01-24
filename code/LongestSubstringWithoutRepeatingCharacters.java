import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
      	// i and j are boundaries of the window. (j = i initially)
      	for(int i=0, j=0; j<s.length(); j++){
            if(map.containsKey(s.charAt(j))){
              	// when the character with index j exists in HashMap,
              	// move i to (j+1) directly
                i = Math.max(map.get(s.charAt(j)), i);
            }
            answer = Math.max(answer, j - i + 1);
          	// add the character as key and index+1 as value to the HashMap
          	// (j+1) used for i to move to.
            map.put(s.charAt(j), j+1);
        }
        return answer;
	}
	
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters demo = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(demo.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(demo.lengthOfLongestSubstring("bbbbb"));
		System.out.println(demo.lengthOfLongestSubstring("pwwkew"));
		System.out.println(demo.lengthOfLongestSubstring("abcad"));
	}
}
