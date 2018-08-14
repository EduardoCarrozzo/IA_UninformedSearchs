package environment.map;

/**
 *
 * @author Carlos A. Casanova P.
 */
public class MoveToAction extends base.AbstractAction {
    
    private String location;
    
    /**
     *
     * @param location
     */
    public MoveToAction(String location) {
        super("moveTo");
        this.location = location;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return this.name + "(" + this.location + ")"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
