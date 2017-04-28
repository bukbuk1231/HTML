public class test
{
    public static void main(String[] args)
    {
	Stack<Character> x = new ArrayStack();
	Character l = 'A';
	Character m = '*';
	x.push(l);
	x.push(m);
	System.out.println(x.pop());
	System.out.println(x.pop());

    }
}