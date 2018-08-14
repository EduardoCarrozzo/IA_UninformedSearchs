package base;

/**
 *
 * @author Carlos A. Casanova P.
 */
public abstract class AbstractAction {

    /**
     *
     */
    protected String name;

    /**
     *
     * @param name
     */
    public AbstractAction(String name) {
        this.name = name;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof AbstractAction){
            AbstractAction anotherAction = (AbstractAction) obj;
            return this.name.equals(anotherAction.name);
        }
        return false;
    }
    
    
}
