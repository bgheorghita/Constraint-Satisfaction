package fii.aeaa.constraints.global;

import fii.aeaa.constraints.Constraint;
import fii.aeaa.models.Node;

import java.util.*;

public abstract class GlobalConstraint implements Constraint {
    protected final List<Node> constrainedNodes;

    public GlobalConstraint(List<Node> constrainedNodes){
        this.constrainedNodes = constrainedNodes;
    }

    public boolean isSubjectTo(Node constrainedNode){
        return constrainedNodes.contains(constrainedNode);
    }
}
