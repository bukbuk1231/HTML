import java.util.Scanner;
public class XFixDriver
{
    public static void main(String[] args)
    {
	/*		
	String expression = "a*(b+c/d)";
	InfixToPostfix infixToPostfix = new InfixToPostfix(expression);
	String postfix = infixToPostfix.ConvertToPostfix();
	System.out.println(postfix);
	*/
	
	/*
	String expression = "ABC+*D/";
	PostfixToInfix postfixToInfix = new PostfixToInfix(expression);
	String infix = postfixToInfix.ConvertToInfix();
	System.out.println(infix);
	*/

	/*
	String expression = "*a+b/cd";
	PrefixToInfix prefixToInfix = new PrefixToInfix(expression);
	String infix = prefixToInfix.ConvertToInfix();
	System.out.println(infix);
	*/

	/*
	String expression = "((a*(b+c))/d)";
	InfixToPrefix infixToPrefix = new InfixToPrefix(expression);
	String prefix = infixToPrefix.ConvertToPrefix();
	System.out.println(prefix);
	*/

	/*
	String expression = "*a+b/cd";
	PrefixToPostfix prefixToPostfix = new PrefixToPostfix(expression);
	String postfix = prefixToPostfix.ConvertToPostfix();
	System.out.println(postfix);
	*/

	/*
	String expression = "abc+*d/";
	PostfixToPrefix postfixToPrefix = new PostfixToPrefix(expression);
	String prefix = postfixToPrefix.ConvertToPrefix();
	System.out.println(prefix);
	*/

	Scanner kb = new Scanner(System.in);
	System.out.println("What type of expression would you like to enter?");
	System.out.print("1)Infix\n2)Postfix\n3)Prefix\n0)Quit\n");
	int userSelection1 = kb.nextInt();
	int userSelection2 = 0;
	do
	{
	if(userSelection1 != 0)
	{	   
	    String expression = "";
	   
	   
	    System.out.print("Enter Expression: ");
	    expression = kb.nextLine();
	    System.out.print("1)To infix\n2)To prefix\n3)To postfix\n4)Evaluate Expression\n5)Retrun to main menu\n0)Quit\n");
	    userSelection2 = kb.nextInt();
	    if(userSelection2 == 1 && userSelection1 == 1)
		System.out.println(expression);
	    if(userSelection2 == 2 && userSelection1 == 1)
	    {
		InfixToPrefix infixToPrefix = new InfixToPrefix(expression);
		String prefix = infixToPrefix.ConvertToPrefix();
		System.out.println(prefix);
	    }
	    if(userSelection2 == 3 && userSelection1 == 1)
	    {
		InfixToPostfix infixToPostfix = new InfixToPostfix(expression);
		String postfix = infixToPostfix.ConvertToPostfix();
		System.out.println(postfix);
	    }
	    if(userSelection2 == 4 && userSelection1 == 1)	    
		{
		InfixToPostfix infixToPostfix = new InfixToPostfix(expression);
		String postfix = infixToPostfix.ConvertToPostfix();
		System.out.println(postfix);
		ExpressionEvaluation evaluation = new ExpressionEvaluation(postfix);
		System.out.println(evaluation.EvaluateExpression());
	    }
	    if(userSelection2 == 1 && userSelection1 == 2)
	    {
		PostfixToInfix postfixToInfix = new PostfixToInfix(expression);
		String infix = postfixToInfix.ConvertToInfix();
		System.out.println(infix);
	    }
	    if(userSelection2 == 2 && userSelection1 == 2)
	    {
		PostfixToPrefix postfixToPrefix = new PostfixToPrefix(expression);
		String prefix = postfixToPrefix.ConvertToPrefix();
		System.out.println(prefix);
	    }
	    if(userSelection2 == 3 && userSelection1 == 2)
		System.out.println(expression);
	    if(userSelection2 == 4 && userSelection1 == 2)
      	    {		
		ExpressionEvaluation evaluation = new ExpressionEvaluation(expression);
	    System.out.println(evaluation.EvaluateExpression());
	    }
	    if(userSelection2 == 1 && userSelection1 == 3)
	    {
		PrefixToInfix prefixToInfix = new PrefixToInfix(expression);
		String infix = prefixToInfix.ConvertToInfix();
		System.out.println(infix);
	    }
	    if(userSelection2 == 2 && userSelection1 == 3)
		System.out.println(expression);
	    if(userSelection2 == 3 && userSelection1 == 3)
	    {
		PrefixToPostfix prefixToPostfix = new PrefixToPostfix(expression);
		String postfix = prefixToPostfix.ConvertToPostfix();
		System.out.println(postfix);
	    }
	    if(userSelection2 == 4 && userSelection1 == 3)
	    {
		PrefixToPostfix prefixToPostfix = new PrefixToPostfix(expression);
		String postfix = prefixToPostfix.ConvertToPostfix();
		System.out.println(postfix);
		ExpressionEvaluation evaluation = new ExpressionEvaluation(postfix);
		System.out.println(evaluation.EvaluateExpression());
	    }
	}
	}
	while(userSelection2 == 5);
    
    }	       
}