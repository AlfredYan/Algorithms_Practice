
public class LongestCommonPrefix {
	public String getLongestCommonPrefix(String[] strings) {
		if(strings == null || strings.length == 0) return "";
		
		// set first string as common prefix
		String comPrefix = strings[0];
		int currPos = 1;
		while(currPos < strings.length) {
			
			// find the common prefix
			// when no common prefix, comPrefix becomes ""
			while(strings[currPos].indexOf(comPrefix) != 0)
				comPrefix = comPrefix.substring(0, comPrefix.length()-1);
			
			currPos++;
		}
		return comPrefix;
	}
	
	public static void main(String[] args) {
		LongestCommonPrefix demo = new LongestCommonPrefix();
		String[] strings_0 = {"a", "a", "b"};
		System.out.println(demo.getLongestCommonPrefix(strings_0));
		String[] strings_1 = {"abc", "abcde"};
		System.out.println(demo.getLongestCommonPrefix(strings_1));
		String[] strings_2 = {"ac", "a", "a", "ac"};
		System.out.println(demo.getLongestCommonPrefix(strings_2));
	}
}
