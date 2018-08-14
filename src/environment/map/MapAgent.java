package environment.map;

import base.Problem;
import base.Search;
import base.SearchBasedAgent;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Carlos A. Casanova P.
 */
public class MapAgent implements SearchBasedAgent<InLocationState, MoveToAction>{

    private final Map map;
    private Search<InLocationState, MoveToAction> searchAlgorithm;
    private String inLocation;

    /**
     *
     * @param map
     * @param inLocation
     */
    public MapAgent(Map map, String inLocation) {
        this.map = map;
        this.inLocation = inLocation;
    }
    
    /**
     *
     * @param goalState
     * @return
     */
    @Override
    public Problem<InLocationState, MoveToAction> formulateProblem(InLocationState goalState) {
        return new MapProblem(map, inLocation, goalState.getInLocation());
    }

    /**
     *
     * @param prob
     * @param searchStrategy
     * @return
     */
    @Override
    public Optional<List<MoveToAction>> search(Problem<InLocationState, MoveToAction> prob, Search<InLocationState, MoveToAction> searchStrategy) {
        searchStrategy.init(prob);
        this.searchAlgorithm = searchStrategy;
        return this.searchAlgorithm.search();    
    }

    /**
     *
     * @param plan
     */
    @Override
    public void execute(List<MoveToAction> plan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
