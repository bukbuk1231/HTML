public class IntegerIsOddException extends Exception {
    public IntegerIsOddException() {
	super( "Integer is odd." );
    }

    public IntegerIsOddException( String msg ) {
	super( msg );
    }

}