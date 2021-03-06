package edu.uaskl.cpp.model.node;

import edu.uaskl.cpp.model.edge.EdgeCpp;
import edu.uaskl.cpp.model.edge.EdgeCreatorCpp;
import edu.uaskl.cpp.model.edge.interfaces.EdgeCreator;

/**
 * Chinese postman problem - node. Has all required special properties to solve Chinese postman problem
 * 
 * @author tbach
 */
public class NodeCpp extends NodeBasic<NodeCpp, EdgeCpp> {
    private boolean isAllEdgesVisited = false;
    private NodeCpp nodeForCPP;
    private static final EdgeCreator<NodeCpp, EdgeCpp> edgeCreator = new EdgeCreatorCpp();
    private long lat = 0;
    private long lon = 0;
    public NodeCpp() {
        super(edgeCreator);
    }
    public NodeCpp(String id, long lat, long lon) {
        super(edgeCreator);
        this.nodeId=id;
        this.lat=lat;
        this.lon=lon;
    }
    /** Copy constructor, creates a new node with the same properties */
    public NodeCpp(final NodeCpp otherNode) {
        super(otherNode);
        this.nodeId = otherNode.getNodeId();
        this.lat = otherNode.lat;
        this.lon = otherNode.lon;
    }
    /** Copy constructor for cpp algorithm, creates a new node with the same properties but marks it as a cpp node */
    public NodeCpp(final NodeCpp knoten, final boolean isForCpp) { // TODO static fabric method?
        super(edgeCreator);
        setName(knoten.getName() + "_" + getId());
        if (isForCpp)
            this.nodeForCPP = knoten;
        else
            throw new IllegalArgumentException("not for cpp? Wrong constructor?");
    }

    public NodeCpp getNodeForCpp() {
        return nodeForCPP;
    }

    private void resetAllEdgesVisitedStates() {
        for (final EdgeCpp kantenItem : getEdges())
            kantenItem.resetState();
        this.isAllEdgesVisited = false;
    }

    public boolean isAllEdgesVisited() {
        if (this.isAllEdgesVisited)
            return true;
        for (final EdgeCpp kante : getEdges())
            if (!kante.isVisited())
                return false;
        setAllEdgesVisited();
        return true;
    }

    public void setAllEdgesVisited() {
        this.isAllEdgesVisited = true;
    }

    public void resetStates() {
        resetVisitedState();
        resetAllEdgesVisitedStates();
    }
}
