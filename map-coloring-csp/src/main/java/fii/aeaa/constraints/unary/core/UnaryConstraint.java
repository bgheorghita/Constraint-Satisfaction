package fii.aeaa.constraints.unary.core;

import fii.aeaa.models.Color;
import fii.aeaa.models.Node;

public abstract class UnaryConstraint {
    protected final Node constrainedNode;
    protected final Color constrainedColor;

    public UnaryConstraint(Node constrainedNode, Color constrainedColor) {
        this.constrainedNode = constrainedNode;
        this.constrainedColor = constrainedColor;
    }

    public abstract boolean isConsistent(Color color);
    public boolean isSubjectTo(Node constrainedNode){
        return constrainedNode.equals(this.constrainedNode);
    }
}
