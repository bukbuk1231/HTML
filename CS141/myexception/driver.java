public class driver {
    public static void main( String[] args ) {
	int x = 5;
	try {
	    System.out.println( "Hello World" );
	    if ( x % 2 == 0 ) 
		throw new IntegerIsEvenException( "Even!!!" );
	    else
		throw new IntegerIsOddException( "Odd!!!" );
	} catch ( IntegerIsEvenException e ) {
	    e.printStackTrace();
	} catch ( IntegerIsOddException e ) {
	    e.printStackTrace();
	}
	
    }
}