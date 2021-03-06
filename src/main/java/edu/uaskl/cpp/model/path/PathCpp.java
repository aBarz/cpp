package edu.uaskl.cpp.model.path;

import java.util.Collections;
import java.util.List;

import edu.uaskl.cpp.model.node.NodeCpp;
import edu.uaskl.cpp.model.path.interfaces.Path;
import edu.uaskl.cpp.tools.CollectionTools;

/**
 * @author tbach
 */
public class PathCpp implements Path {
    /** Empty path without a start node */
    public static final PathCpp emptyPath = new PathCpp(Collections.<NodeCpp> emptyList());
    private final List<NodeCpp> nodes;
    private int distance;

    public PathCpp(final List<NodeCpp> knoten) {
        this.nodes = knoten;
    }

    public PathCpp(final List<NodeCpp> nodes, final int distance) {
        this.nodes = nodes;
        this.distance = distance;
    }

    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public int getLength() {
        return nodes.size();
    }

    @Override
    public List<NodeCpp> getNodes() {
        return nodes;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Distance: ").append(distance).append(", length: ").append(nodes.size()).append("\n");
        stringBuilder.append(CollectionTools.join("->", nodes));
        return stringBuilder.toString();
    }
}
