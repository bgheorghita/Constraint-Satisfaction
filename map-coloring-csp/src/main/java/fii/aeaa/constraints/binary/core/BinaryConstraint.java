package fii.aeaa.constraints.binary.core;

import fii.aeaa.models.Color;
import fii.aeaa.models.Node;

public abstract class BinaryConstraint {
    protected final Node firstNodeConstrained;
    protected final Node secondNodeConstrained;

    public BinaryConstraint(Node firstNodeConstrained, Node secondNodeConstrained) {
        this.firstNodeConstrained = firstNodeConstrained;
        this.secondNodeConstrained = secondNodeConstrained;
    }

    public boolean isSubjectTo(Node firstNodeConstrained, Node secondNodeConstrained){
        return this.firstNodeConstrained.equals(firstNodeConstrained) && this.secondNodeConstrained.equals(secondNodeConstrained)
                || this.firstNodeConstrained.equals(secondNodeConstrained) && this.secondNodeConstrained.equals(firstNodeConstrained);
    }
    public abstract boolean isConsistent(Color firstNodeColor, Color secondNodeColor);
}
