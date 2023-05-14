package fii.aeaa.constraints.unary.core;

import fii.aeaa.constraints.Constraint;
import fii.aeaa.models.Color;
import fii.aeaa.models.Node;

public abstract class UnaryConstraint implements Constraint {
    protected final Node constrainedNode;
    protected final Color constrainedColor;

    public UnaryConstraint(Node constrainedNode, Color constrainedColor) {
        this.constrainedNode = constrainedNode;
        this.constrainedColor = constrainedColor;
    }

    @Override
    public boolean isSubjectTo(Node node){
        return constrainedNode.getName().equals(node.getName());
    }
}
