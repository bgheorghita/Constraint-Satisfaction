package fii.aeaa.constraints.unary.core;

import fii.aeaa.models.Node;

public abstract class UnaryConstraint {
    protected final Node constrainedNode;
    protected final String constrainedColor;

    public UnaryConstraint(Node constrainedNode, String constrainedColor) {
        this.constrainedNode = constrainedNode;
        this.constrainedColor = constrainedColor;
    }

    public abstract boolean isConsistent(String color);
    public boolean isSubjectTo(Node constrainedNode){
        return constrainedNode.equals(this.constrainedNode);
    }
}
