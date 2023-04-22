package fii.aeaa.constraints.binary.implementations;

import fii.aeaa.constraints.binary.core.BinaryConstraint;
import fii.aeaa.models.Color;
import fii.aeaa.models.Node;

public class ExactColorBinaryConstraint extends BinaryConstraint {
    public ExactColorBinaryConstraint(Node firstNodeConstrained, Node secondNodeConstrained) {
        super(firstNodeConstrained, secondNodeConstrained);
    }

    @Override
    public boolean isConsistent(Color firstNodeColor, Color secondNodeColor) {
        return firstNodeColor.equals(secondNodeColor);
    }
}
