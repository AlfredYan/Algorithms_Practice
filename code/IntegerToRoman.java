
public class IntegerToRoman {
	String thousands[] = {"", "M", "MM", "MMM"};
    String hundreds[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String tens[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String bits[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
	
	public String integerToRoman(int number) {
		if(number >=1 && number <= 3999)
			return thousands[number / 1000] + hundreds[(number % 1000) / 100] + 
						tens[(number % 100) / 10] + bits[(number % 10)];
		else
			return "Out of Range";
	}
	
	public static void main(String[] args) {
		IntegerToRoman demo = new IntegerToRoman();
		System.out.println(demo.integerToRoman(7));
		System.out.println(demo.integerToRoman(20));
		System.out.println(demo.integerToRoman(365));
		System.out.println(demo.integerToRoman(1234));
		System.out.println(demo.integerToRoman(3999));
		System.out.println(demo.integerToRoman(39999));
	}
}
