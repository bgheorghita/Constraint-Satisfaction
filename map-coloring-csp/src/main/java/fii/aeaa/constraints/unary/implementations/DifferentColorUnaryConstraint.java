package fii.aeaa.constraints.unary.implementations;

import fii.aeaa.constraints.unary.core.UnaryConstraint;
import fii.aeaa.models.Color;
import fii.aeaa.models.Node;

public class DifferentColorUnaryConstraint extends UnaryConstraint {
    public DifferentColorUnaryConstraint(Node constrainedNode, Color constrainedColor) {
        super(constrainedNode, constrainedColor);
    }

    @Override
    public boolean isConsistent(Color color) {
        return !color.equals(constrainedColor);
    }
}
