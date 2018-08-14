package base;

import java.util.List;
import java.util.Optional;
import util.Pair;
import util.Path;

/**
 * Template class Search
 * @author Carlos A. Casanova P.
 * @param <S>
 * @param <A>
 */
public abstract class Search<S extends State, A extends AbstractAction> {
    
    private Problem<S, A> problem;
    //private Collection<Path<S, A>> frontier;

    /**
     *
     */
    public Search() {
        this.problem = null;
    }
    
    /**
     *
     * @param prob
     */
    public void init(Problem<S, A> prob){
        this.problem = prob;
    }
    
    /**
     *
     * @return
     */
    public Optional<List<A>> search(){
        if(this.problem == null) throw new IllegalStateException("Problem == null");
        if(this.isFrontierEmpty()){
            Path<S, A> root = new Path<>(problem.getInitialState());
            if (problem.testGoal(root.getActualState())) {
                return Optional.of(root.getActionSequence());
            }
            addToFrontier(root);
        }
        while (!isFrontierEmpty() ) {
            // choose a leaf node and remove it from the frontier
            Path<S, A> pathToExpand = removeFromFrontier();
            if (problem.testGoal(pathToExpand.getActualState())) // if the path contains a goal state then return the
            // corresponding solution
            {
                return Optional.of(pathToExpand.getActionSequence());
            }

            // get actual state succesors
            List<Pair<A, S>> successors = problem.getSuccessors(pathToExpand.getActualState());
            
            for (Pair<A, S> successor : successors) {
                Path<S, A> newPath = new Path(pathToExpand);
                newPath.add(successor.getFirst(), successor.getSecond());
                addToFrontier(newPath);
            }
        }
        // if the frontier is empty then return failure
        return Optional.empty();
    }
    
    // Protected methods

    /**
     *
     * @param path
     */
    protected abstract void addToFrontier(Path<S, A> path);

    /**
     * Primitive operation which removes and returns the node at the head of the
     * frontier.
     *
     * @return the node at the head of the frontier.
     */
    protected abstract Path<S, A> removeFromFrontier();

    /**
     * Primitive operation which checks whether the frontier contains not yet
     * expanded nodes.
     * @return 
     */
    protected abstract boolean isFrontierEmpty();
    
    
}
