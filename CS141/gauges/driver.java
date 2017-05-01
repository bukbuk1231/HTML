public class driver {
    public static void main( String[] arg ) {
	int min = Integer.parseInt( arg[ 0 ] );
	int max = Integer.parseInt( arg[ 1 ] );
	int ms  = Integer.parseInt( arg[ 2 ] );
	String type = arg[ 3 ];

	switch ( type.toLowerCase().charAt( 0 ) ) {
	case 'g': testGauge( min, max, ms ); break;
	case 'f': testFormattedGauge( min, max, ms ); break;
	}
    }

    public static void testGauge( int min, int max, int ms ) {
	Gauge G = new Gauge( min, max );

	for (int i = min; i <= max; i++ ) {
	    G.state( i );
	    System.out.println( G );
	    pause( ms );
	}
    }

    public static void pause( int ms ) {
	try {
	    Thread.sleep( ms );
	} catch ( Exception e ) {}
    }

    public static void testFormattedGauge( int min, int max, int ms ) {
	formattedGauge F = new formattedGauge( min, max, "%6.2f%%" );

	for (int i = min; i <= max; i++ ) {
	    F.state( i );
	    System.out.println( F );
	    pause( ms );
	}
	
    }

    
}