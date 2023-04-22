package fii.aeaa.constraints.binary.implementations;

import fii.aeaa.constraints.binary.core.BinaryConstraint;
import fii.aeaa.models.Node;

public class ExactColorBinaryConstraint extends BinaryConstraint {
    public ExactColorBinaryConstraint(Node firstNodeConstrained, Node secondNodeConstrained) {
        super(firstNodeConstrained, secondNodeConstrained);
    }

    @Override
    public boolean isConsistent(String firstNodeColor, String secondNodeColor) {
        return firstNodeColor.equals(secondNodeColor);
    }
}
