package fii.aeaa.constraints.global;

import fii.aeaa.models.Color;
import fii.aeaa.models.Node;

import java.util.*;

public abstract class GlobalConstraint {
    private final Set<Node> constrainedNodes;

    public GlobalConstraint(Node[] constrainedNodes){
        this.constrainedNodes = new HashSet<>();
        this.constrainedNodes.addAll(Arrays.asList(constrainedNodes));
    }

    public Set<Node> getConstrainedNodes() {
        return new HashSet<>(constrainedNodes);
    }

    public boolean isSubjectTo(Node constrainedNode){
        return constrainedNodes.contains(constrainedNode);
    }

    public abstract boolean isConsistent(Color firstNodeColor, Color secondNodeColor);
}
