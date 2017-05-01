public class IntegerIsEvenException extends Exception {

    public IntegerIsEvenException() {
	super( "Integer is even." );
    }

    public IntegerIsEvenException( String msg ) {
	super( msg );
    }
}