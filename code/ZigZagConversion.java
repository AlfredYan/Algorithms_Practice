
public class ZigZagConversion {
	public String convert(String s, int numRows) {
        StringBuffer[] result = new StringBuffer[numRows];
        char[] chars = s.toCharArray();
        int sLen = s.length();
        // create StringBuffer for each row
        for(int i=0; i<result.length; i++) {
        		result[i] = new StringBuffer();
        }
        int currPosition = 0;
        while(currPosition < sLen) {
        		// vertically down
        		for(int index=0; index<numRows && currPosition<sLen; index++) {
        			result[index].append(chars[currPosition++]);
        		}
        		// obliquely up
        		for(int index=numRows-2; index>=1 && currPosition<sLen; index--) {
        			result[index].append(chars[currPosition++]);
        		}
        }
        // join the second and third lines to the first line
        for(int index=1; index<result.length; index++) {
        		result[0].append(result[index]);
        }
        return result[0].toString();
    }
	
	public static void main(String[] args) {
		ZigZagConversion demo = new ZigZagConversion();
		System.out.println(demo.convert("PAYPALISHIRING", 3));
	}
}
