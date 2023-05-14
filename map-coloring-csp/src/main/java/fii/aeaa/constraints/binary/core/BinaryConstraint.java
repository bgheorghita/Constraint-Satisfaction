package fii.aeaa.constraints.binary.core;

import fii.aeaa.constraints.Constraint;
import fii.aeaa.models.Node;

public abstract class BinaryConstraint implements Constraint {
    protected final Node firstNodeConstrained;
    protected final Node secondNodeConstrained;

    public BinaryConstraint(Node firstNodeConstrained, Node secondNodeConstrained) {
        this.firstNodeConstrained = firstNodeConstrained;
        this.secondNodeConstrained = secondNodeConstrained;
    }

    public Node getFirstNodeConstrained() {
        return firstNodeConstrained;
    }

    public Node getSecondNodeConstrained() {
        return secondNodeConstrained;
    }

    @Override
    public boolean isSubjectTo(Node node){
        return firstNodeConstrained.getName().equals(node.getName()) || secondNodeConstrained.getName().equals(node.getName());
    }
}
