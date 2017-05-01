import java.util.Scanner;
public class stringSort {
    public static void main( String[] args ) {
	int count = 1000;
	String[] list = new String[ count ];
	Scanner k = new Scanner( System.in );

	while ( count > 0 ) {
	    list[ count - 1 ] = k.nextLine();
	    count--;
	}

	sort( list );
	printList( list );
    }

    public static void printList( String[] list ) {
	int count = 0;

	while ( count < list.length )
	    System.out.println( list[ count++ ] );
    }

    public static void sort( String[] list ) {
	sortRec( list, list.length - 1 );
    }

    public static void sortRec( String[] list, int bottom ) {
	int maxLocation = 0;
	String temp = "";

	if ( bottom != 0 ) {
	    maxLocation = findMaxLocation( list, bottom );
	    
	    temp = list[ maxLocation ];             //  Perform
	    list[ maxLocation ] = list[ bottom ];   //  the
	    list[ bottom ] = temp;                  //  swap

	    sortRec( list, bottom -1 );
	}
    }

    public static int findMaxLocation( String[] list, int bottom ) {
	return findMaxLocationRec( list, bottom, 0, 1 );
	// int assumedMax = 0;

	// for ( int i = 1; i <= bottom; i++ ) {
	//     if ( list[ assumedMax ].compareTo( list[ i ] ) < 0 ) {
	// 	assumedMax = i;
	//     }
	// }
	// return assumedMax;
    }


    public static int findMaxLocationRec( String[] list, int bottom, int assumedMax, int current ) {
	if ( current <= bottom )
	    if ( list[ assumedMax ].compareTo( list[ current ] ) < 0 )
		return findMaxLocationRec( list, bottom, current, current + 1 );
	    else
		return findMaxLocationRec( list, bottom, assumedMax, current + 1 );
	return assumedMax;
    }


}