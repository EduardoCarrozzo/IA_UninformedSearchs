package util;

/**
 * A class formed by pairs of (X x Y) (cartesian product)
 * @author Carlos A. Casanova P.
 * @param <X> First component class
 * @param <Y> Second component class
 */
public class Pair<X, Y> { 
  private final X first; 
  private final Y second; 
  
    /**
     *
     * @param x
     * @param y
     */
    public Pair(X x, Y y) { 
    this.first = x; 
    this.second = y; 
  } 

    /**
     *
     * @return
     */
    public X getFirst() {
        return first;
    }

    /**
     *
     * @return
     */
    public Y getSecond() {
        return second;
    }

    /**
     * 
     * @param o
     * @return true if pairs are equals
     */
    @Override
    public boolean equals(Object o) {
        if(o != null && o instanceof Pair){
            Pair p = (Pair) o;
            return this.first == p.first && this.second == p.second;
        }
        return false;
    }
  
} 
