/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import base.AbstractAction;
import base.State;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos A. Casanova P.
 * @param <S> Some State subclass
 * @param <A> Some Action subclass
 */
public class Path<S extends State, A extends AbstractAction> {
    
    private S initialState;
    List<Pair<A, S>> alternateSequence = new ArrayList<>();

    /**
     * Constructs a Path formed by a single S
     * @param initialState
     */
    public Path(S initialState) {
        this.initialState = initialState;
    }
    
    /**
     * Copy constructor
     * @param anotherPath
     */
    public Path(Path<S, A> anotherPath){
        this.initialState = anotherPath.initialState;
        this.alternateSequence.addAll(anotherPath.alternateSequence);
    }
    
    /**
     * Adds a pair (A, S) to this Path
     * @param action
     * @param state
     */
    public void add(A action, S state){
        alternateSequence.add(new Pair<>(action, state));
    }
    
    /**
     * Gets last S in this Path
     * @return last S
     */
    public S getActualState(){
        if(alternateSequence.isEmpty())
            return initialState;
        else
            return alternateSequence.get(alternateSequence.size()-1).getSecond();
    }
    
    /**
     * Gets last action in this Path
     * @return last A
     */
    public A getLastAction(){
        if(alternateSequence.isEmpty())
            return null;
        else
            return alternateSequence.get(alternateSequence.size()-1).getFirst();
    }
    
    /**
     * Gets the sequence of Actions in this Path
     * @return
     */
    public List<A> getActionSequence(){
        List<A> secuencia = new ArrayList<>();
        this.alternateSequence.forEach(pair -> secuencia.add(pair.getFirst()));
        return secuencia;
    }
}
