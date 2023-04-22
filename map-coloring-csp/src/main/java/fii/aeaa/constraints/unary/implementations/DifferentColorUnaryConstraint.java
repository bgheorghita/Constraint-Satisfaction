package fii.aeaa.constraints.unary.implementations;

import fii.aeaa.constraints.unary.core.UnaryConstraint;
import fii.aeaa.models.Node;

public class DifferentColorUnaryConstraint extends UnaryConstraint {
    public DifferentColorUnaryConstraint(Node constrainedNode, String constrainedColor) {
        super(constrainedNode, constrainedColor);
    }

    @Override
    public boolean isConsistent(String color) {
        return !color.equals(constrainedColor);
    }
}
