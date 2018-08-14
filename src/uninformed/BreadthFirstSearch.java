package uninformed;

import base.AbstractAction;
import base.Search;
import base.State;
import java.util.LinkedList;
import java.util.Queue;
import util.Path;

/**
 *
 * @author Carlos A. Casanova P.
 * @param <S>
 * @param <A>
 */
public class BreadthFirstSearch<S extends State, A extends AbstractAction> extends Search<S, A>{
    
    private final Queue<Path<S, A>> frontier;

    /**
     *
     */
    public BreadthFirstSearch() {
        super();
        this.frontier = new LinkedList<>();
    }
    
    /**
     *
     * @param path
     */
    @Override
    protected void addToFrontier(Path<S, A> path) {
        frontier.add(path);
    }

    @Override
    protected Path<S, A> removeFromFrontier() {
        return frontier.poll();
    }

    @Override
    protected boolean isFrontierEmpty() {
        return frontier.isEmpty();
    }
    
}
