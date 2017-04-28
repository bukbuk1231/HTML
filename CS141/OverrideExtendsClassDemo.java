public class square {
    private int length = 0;
    
    public square( int length ) {
        this.length = length;
    } 
    
    public int length() {
        return length;
    } 
    
    public void length( int length ) {
        this.length = length;
    } 
    
    public int area() {
        return length * length;
    } 
    
    public String toString() {
        return "Square, side length = " + length;
    } 
    
    public boolean equals( square S ) {
        return length == S.length();  // Careful: S is a square, not String!
    }
}

public class cube extends square {

  // Need a constructor since the super class contains no default
  //  constructor (a "no-arg" constructor). 
  public cube( int length ) {
    super( length );          // Call the parent's constructor explicitly
  }

  // Create a new method
  public int volume() {
    return length * length * length;
  }

  //  *Override* toString
  public String toString() {
    return "Cube, side length = " + length;
  }

}