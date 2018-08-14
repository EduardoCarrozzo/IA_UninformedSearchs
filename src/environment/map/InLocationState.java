package environment.map;

import base.State;

/**
 *
 * @author Carlos A. Casanova P.
 */
public class InLocationState implements State {
    
    private final String inLocation;

    /**
     *
     * @param inLocation
     */
    public InLocationState(String inLocation) {
        this.inLocation = inLocation;
    }

    /**
     *
     * @return
     */
    public String getInLocation() {
        return inLocation;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof InLocationState){
            InLocationState anotherState = (InLocationState) obj;
            return inLocation.equals(anotherState.inLocation);
        }
        return false;
    }
}
