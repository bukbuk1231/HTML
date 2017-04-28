import java.util.stack;
public class ExpressionEvaluation
{
    private String expression = "";
    private int output  = 0;
    private static final String operators = "-+/*";
    private static final String operands = "0123456789";


    public ExpressionEvaluation()
    {
	expression = null;
    }

    public ExpressionEvaluation(String inputExpression)
    {
	expression = inputExpression;
    }
    
    
    public int EvaluateExpression() 
    {
	char[] chars = expression.toCharArray();
	Stack&lt;Integer&gt; stack = new Stack&lt;Integer&gt;();
	for (char c : chars)
	    {
		if (isOperand(c)) 
		    {
			stack.push(c - '0'); 
		    } 
		else if (isOperator(c)) 
		    {
			int op1 = stack.pop();
			int op2 = stack.pop();
			int result;
			switch (c)
			    {
			    case '*':
				result = op1 * op2;
				stack.push(result);
			    break;
			    case '/':
			    result = op2 / op1;
			    stack.push(result);
			    break;
			    case '+':
				result = op1 + op2;
				stack.push(result);
				break;
			    case '-':
				result = op2 - op1;
				stack.push(result);
				break;
			    }
		    }
	    }
	return stack.pop();
    }   
}