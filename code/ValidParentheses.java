import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		
		for(Character c : s.toCharArray()) {
			if(c == '(') stack.push(')');
			else if(c == '[') stack.push(']');
			else if(c == '{') stack.push('}');
			else if(stack.isEmpty() || stack.pop() != c) {
				/* when we meet a type of second part parentheses, like: ), ], }
				* it should correspond to the most recent one that push to the stack,
				* otherwise the syntax is invalid
				*/
				return false;
			}
		}
		
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		ValidParentheses demo = new ValidParentheses();
		System.out.println(demo.isValid("()[]{}"));
		System.out.println(demo.isValid("(]"));
		System.out.println(demo.isValid("([)]"));
		System.out.println(demo.isValid("{[]}"));
	}
}
