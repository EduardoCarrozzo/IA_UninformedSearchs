package base;

import java.util.List;
import util.Pair;

/**
 *
 * @author Carlos A. Casanova P.
 * @param <S> Some State subclass
 * @param <A> Some Action subclass
 */
public interface Problem<S extends State, A extends AbstractAction> {
    
    /**
     *
     * @return
     */
    S getInitialState();

    /**
     *
     * @param actualState
     * @return
     */
    List<Pair<A, S>> getSuccessors(S actualState);

    /**
     *
     * @param s
     * @return
     */
    boolean testGoal(S s);

    /**
     *
     * @param initialState
     * @param actionToTake
     * @param nextState
     * @return
     */
    double getStepCost(S initialState, A actionToTake, S nextState);
    
}
