public class Gauge {

    protected int min, max, state;

    public Gauge() {
	this( 0, 100 );
    }

    public Gauge( int max ) {
	this( 0, max );
    }

    public Gauge( int min, int max ) {
	this.min = min;
	this.max = max;
	state = 0;
    }

    public void state( int x ) {
	state = x;
    }

    public int state() {
	return state;
    }

    public String toString() {
	return "" + (int)( ( ( state - min ) * 1.0 ) / 
			   ( max - min ) * 100.0 );
    }

}