package environment.map;

import base.Problem;
import java.util.ArrayList;
import java.util.List;
import util.Pair;

/**
 *
 * @author Carlos A. Casanova P.
 */
public class MapProblem implements Problem<InLocationState, MoveToAction> {
    
    private final Map map;
    private final String initialLocation;
    private final String goalLocation;

    /**
     *
     * @param map
     * @param initialLocation
     * @param goalLocation
     */
    public MapProblem(Map map, String initialLocation, String goalLocation) {
        this.map = map;
        if(!map.isLocation(initialLocation)) 
            throw new IllegalArgumentException("Initial Location must be a valid location in Map");
        this.initialLocation = initialLocation;
        if(!map.isLocation(goalLocation)) 
            throw new IllegalArgumentException("Goal Location must be a valid location in Map");
        this.goalLocation = goalLocation;
    }
    
    @Override
    public InLocationState getInitialState() {
        return new InLocationState(initialLocation);
    }

    @Override
    public List<Pair<MoveToAction, InLocationState>> getSuccessors(InLocationState actualState) {
        List<Pair<MoveToAction, InLocationState>> result = new ArrayList<>();
        
        List<String> nextLocations;
        nextLocations = map.getPossibleNextLocations(actualState.getInLocation());
        for(String nextLocation: nextLocations){
            result.add(new Pair<>(new MoveToAction(nextLocation), new InLocationState(nextLocation)));
        }
        return result;
    }

    @Override
    public boolean testGoal(InLocationState s) {
        return this.goalLocation.equals(s.getInLocation());
    }

    @Override
    public double getStepCost(InLocationState initialState, MoveToAction actionToTake, InLocationState nextState) {
        return map.getDistance(initialState.getInLocation(), nextState.getInLocation());
    }
    
    
    
}
