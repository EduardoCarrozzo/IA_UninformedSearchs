package base;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Carlos A. Casanova P.
 * @param <S>
 * @param <A>
 */
public interface SearchBasedAgent<S extends State, A extends AbstractAction> {
    
    /**
     *
     * @param goalState
     * @return
     */
    public Problem<S, A> formulateProblem(S goalState);

    /**
     *
     * @param prob
     * @param searchStrategy
     * @return
     */
    public Optional<List<A>> search(Problem<S, A> prob, Search<S, A> searchStrategy);

    /**
     *
     * @param plan
     */
    public void execute(List<A> plan);
}
