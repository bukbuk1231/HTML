import java.util.Random;
public class genRandomCSV{
    public static void main(String[] agrs){
	Random R = new Random();
	int numRows = 0;
	int numCols = 0;
	float x = (float)0.0;

	if (args == null){
	    System.out.print("I need rows and cols!\n");
	    System.out.exit(0);
	} else if (args.length < 2){
	    ANSI.setPrintingMode(ANSI.$OFF);
	    System.out.println("I need rows " + ANSI.bold() + "and" + ANSI.resetChars() + " cols!\n");
	}
	numRows = Integer.parseInt( args[0]);
	numCols = Integer.parseInt( args[1]);

	for (int row = 0; row < numRows; row++){
	    for (int col = 0; col < numCols; col++){
		x = (float)( ( 200.0 * R.nextFloat() ) - 100.0);
		System.out.printf("%