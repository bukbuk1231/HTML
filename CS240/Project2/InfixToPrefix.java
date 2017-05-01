public class InfixToPrefix
{
    private String expression;
    @SuppressWarnings("unchecked")
    private Stack<Character> operatorStack = new ArrayStack();
    private String prefixReversed = "";
    private String prefix = "";

    public InfixToPrefix()
    {
	expression = "";
    }

    public InfixToPrefix(String infixExpression)
    {
	expression = infixExpression;
    }

    public String ConvertToPrefix()
    {
	// original = null ??
	Character nextCharacter = ' ';
	int charIndex = expression.length() - 1;
	Character topOperator = ' ';
	while(charIndex >= 0)
	{
	    nextCharacter = expression.charAt(charIndex);	   
	    if(!(nextCharacter >= 65 && nextCharacter <= 90) && !(nextCharacter >= 97 && nextCharacter <= 122))
	    {
		switch(nextCharacter)
		{
		case '^':
		    operatorStack.push(nextCharacter);
		    break;
		case '*': case '/':	 
		    if(operatorStack.peek() != null)
			{
			    while(operatorStack.peek() == '^')
				{
				    prefixReversed += operatorStack.pop(); 
				    if(operatorStack.peek() == null)
					break;
				}
			} 		       
		    operatorStack.push(nextCharacter);     
		    break;
		case '+': case '-':
		    if(operatorStack.peek() != null)
			{
			    while(operatorStack.peek() == '^' || operatorStack.peek() == '*' || operatorStack.peek() == '/')
				{
				    prefixReversed += operatorStack.pop();
				    if(operatorStack.peek() == null)
					break;
				}
			}
		    operatorStack.push(nextCharacter);
		    break;
		case ')':
		    operatorStack.push(nextCharacter);
		    break;
		case '(':
		    topOperator = operatorStack.pop();
		    while(topOperator != ')')
			{
			    prefixReversed += topOperator;
			    topOperator = operatorStack.pop();
			}
		    break;
		default: break;
		}
	    }
	    else
		prefixReversed += nextCharacter;
	    charIndex--;
	}
	while(operatorStack.peek() != null)
	{
	    topOperator = operatorStack.pop();
	    prefixReversed += topOperator;
	}
        for(int i = prefixReversed.length() - 1; i >= 0; i--)
	    prefix += prefixReversed.charAt(i);
	return prefix;
    }
}