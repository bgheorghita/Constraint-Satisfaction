package fii.aeaa.constraints.binary.implementations;

import fii.aeaa.constraints.binary.core.BinaryConstraint;
import fii.aeaa.models.Node;

public class DifferentColorBinaryConstraint extends BinaryConstraint {

    public DifferentColorBinaryConstraint(Node firstNode, Node secondNode) {
        super(firstNode, secondNode);
    }

    @Override
    public boolean isConsistent(String firstNodeColor, String secondNodeColor) {
        return !firstNodeColor.equals(secondNodeColor);
    }
}
