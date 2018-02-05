public class ReverseInteger {
	public int reverse(int x) {
		int result = 0;
		int newResult = 0;
		int tail = 0;
		while(x != 0) {
			// get the value of last digit
			tail = x%10;
			newResult = result*10 + tail;
			// fix overflow problem
			if((newResult - tail)/10 != result) {
				return 0;
			}
			result = newResult;
			x=x/10;
		}
		return result;
	}
	
	public static void main(String[] args) {
		ReverseInteger demo = new ReverseInteger();
		System.out.println(demo.reverse(123));
		System.out.println(demo.reverse(-123));
		System.out.println(demo.reverse(120));
		System.out.println(demo.reverse(1534236469));
	}
}
