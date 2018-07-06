
public class ImplementStrFun {
	public int strStr(String haystack, String needle) {
		
		// some special condition
		if(haystack == null || needle == null) return -1;
		if(needle.length() == 0) return 0;
		if(haystack.length() < needle.length()) return -1;
		
		for(int i=0; i<haystack.length(); i++) {
			int haystackIndex = i;
			int needleIndex = 0;
			
			// keep comparing each character until difference occurs
			while(haystackIndex < haystack.length() && needleIndex < needle.length() 
					&& haystack.charAt(haystackIndex) == needle.charAt(needleIndex)) {
				haystackIndex++;
				needleIndex++;
			}
			
			// when find the index that the needle starts
			if(needleIndex == needle.length())	return i;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		ImplementStrFun demo = new ImplementStrFun();
		System.out.println(demo.strStr("hello", "ll"));
		System.out.println(demo.strStr("aaaaa", "bba"));
	}
}
