
public class ExpressionBalanceValidator {

	public boolean isBalanced(String expression) {
		char stack[] = new char[expression.length()];
		int top = -1;
		for(int i = 0; i < expression.length(); i++) {
			if(expression.charAt(i) == '(' || expression.charAt(i) == '[' || expression.charAt(i) == '{') {
				stack[++top] = expression.charAt(i);
			} else if(expression.charAt(i) == ')' || expression.charAt(i) == ']' || expression.charAt(i) == '}') {
				if(top == -1) {
					return false;
				}
				if((stack[top] == '(' && expression.charAt(i) != ')')
						|| (stack[top] == '[' && expression.charAt(i) != ']')
						|| (stack[top] == '{' && expression.charAt(i) != '}')) {
					return false;
				}
				if ((stack[top] == '(' && expression.charAt(i) == ')')
						|| (stack[top] == '[' && expression.charAt(i) == ']')
						|| (stack[top] == '{' && expression.charAt(i) == '}')) {
					
					top--;
				}
			}
		}
		
		if(top == -1) {
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		String exprOne = "{(a,b)}"; //TRUE
		String exprTwo = "{(a},b)"; // FALSE
		String exprThree = "{)(a,b}"; //FALSE
		String exprFour = "()(){}{}{()}"; //TRUE
		String exprFive = "((({}{}))()"; //FALSE
		String exprSix = "}{"; // FALSE
		String exprSeven = ""; //TRUE
		String exprEight = "(a+(b*c)-d)"; //TRUE
		String exprRedmart = "((a+b)+((c+d)))"; //TRUE
		String exprNine = "[()]{}{[()()]()}"; //TRUE
		String exprTen = "{}([])"; //TRUE
		String exprEleven = "([}])"; //FALSE
		String exprTwelve = "([])"; //TRUE
		String exprThirteen = "()[]{}[][]"; //TRUE
		
		ExpressionBalanceValidator ebv = new ExpressionBalanceValidator();
		
		System.out.println(exprOne + ": " + ebv.isBalanced(exprOne));
		System.out.println(exprTwo + ": " + ebv.isBalanced(exprTwo));
		System.out.println(exprThree + ": " + ebv.isBalanced(exprThree));
		System.out.println(exprFour + ": " + ebv.isBalanced(exprFour));
		System.out.println(exprFive + ": " + ebv.isBalanced(exprFive));
		System.out.println(exprSix + ": " + ebv.isBalanced(exprSix));
		System.out.println(exprSeven + ": " + ebv.isBalanced(exprSeven));
		System.out.println(exprEight + ": " + ebv.isBalanced(exprEight));
		System.out.println(exprRedmart + ": " + ebv.isBalanced(exprRedmart));
		System.out.println(exprNine + ": " + ebv.isBalanced(exprNine));
		System.out.println(exprTen + ": " + ebv.isBalanced(exprTen));
		System.out.println(exprEleven + ": " + ebv.isBalanced(exprEleven));
		System.out.println(exprTwelve + ": " + ebv.isBalanced(exprTwelve));
		System.out.println(exprThirteen + ": " + ebv.isBalanced(exprThirteen));
	}
}
