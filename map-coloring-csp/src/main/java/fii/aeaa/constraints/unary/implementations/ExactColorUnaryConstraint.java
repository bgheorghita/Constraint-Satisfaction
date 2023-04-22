package fii.aeaa.constraints.unary.implementations;


import fii.aeaa.constraints.unary.core.UnaryConstraint;
import fii.aeaa.models.Color;
import fii.aeaa.models.Node;

public class ExactColorUnaryConstraint extends UnaryConstraint {

    public ExactColorUnaryConstraint(Node constrainedNode, Color constrainedColor) {
        super(constrainedNode, constrainedColor);
    }

    @Override
    public boolean isConsistent(Color constrainedColor) {
        return constrainedColor.equals(this.constrainedColor);
    }
}
