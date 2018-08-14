package environment.map;

import java.util.Collections;
import java.util.List;

/**
 * Implements a map with locations, distance labeled links between the
 * locations.
 * Locations are represented by strings and travel distances by double values.
 * Locations and links can be added dynamically and removed after creation. This
 * enables to read maps from file or to modify them with respect to newly
 * obtained knowledge.
 * 
 * @author Ruediger Lunde
 */
public class Map {
    private LabeledGraph<String, Double> graphMap;
    
    /**
     *
     */
    public Map() {
        graphMap = new LabeledGraph<String, Double>();
    }

    /**
     * Removes everything.
     */
    public void clear() {
        graphMap.clear();
    }

    /**
     * Returns a list of all locations.
     * @return 
     */
    public List<String> getLocations() {
        return graphMap.getVertexLabels();
    }

    /**
     * Checks whether the given string is the name of a location.
     * @param str
     * @return 
     */
    public boolean isLocation(String str) {
        return graphMap.isVertexLabel(str);
    }

    /**
     * Answers to the question: Where can I get, following one of the
     * connections starting at the specified location?
     * @param location
     * @return 
     */
    public List<String> getPossibleNextLocations(String location) {
        List<String> result = graphMap.getSuccessors(location);
        Collections.sort(result);
        return result;
    }

    /**
     * Answers to the question: From where can I reach a specified location,
     * following one of the map connections? This implementation just calls
     * {@link #getPossibleNextLocations(String)} as the underlying graph
     * structure cannot be traversed efficiently in reverse order.
     * @param location
     * @return 
     */
    public List<String> getPossiblePrevLocations(String location) {
        return getPossibleNextLocations(location);
    }

    /**
     * Returns the travel distance between the two specified locations if they
     * are linked by a connection and null otherwise.
     * @param fromLocation
     * @param toLocation
     * @return 
     */
    public Double getDistance(String fromLocation, String toLocation) {
        return graphMap.get(fromLocation, toLocation);
    }

    /**
     * Adds a one-way connection to the map.
     * @param fromLocation
     * @param distance
     * @param toLocation
     */
    public void addUnidirectionalLink(String fromLocation, String toLocation, Double distance) {
        graphMap.set(fromLocation, toLocation, distance);
    }

    /**
     * Adds a connection which can be traveled in both direction. Internally,
     * such a connection is represented as two one-way connections.
     * @param fromLocation
     * @param toLocation
     * @param distance
     */
    public void addBidirectionalLink(String fromLocation, String toLocation, Double distance) {
        graphMap.set(fromLocation, toLocation, distance);
        graphMap.set(toLocation, fromLocation, distance);
    }

    /**
     * Removes a one-way connection.
     * @param fromLocation
     * @param toLocation
     */
    public void removeUnidirectionalLink(String fromLocation, String toLocation) {
        graphMap.remove(fromLocation, toLocation);
    }

    /**
     * Removes the two corresponding one-way connections.
     * @param fromLocation
     * @param toLocation
     */
    public void removeBidirectionalLink(String fromLocation, String toLocation) {
        graphMap.remove(fromLocation, toLocation);
        graphMap.remove(toLocation, fromLocation);
    }
}
