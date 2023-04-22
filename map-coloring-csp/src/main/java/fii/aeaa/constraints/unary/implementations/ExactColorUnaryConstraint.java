package fii.aeaa.constraints.unary.implementations;


import fii.aeaa.constraints.unary.core.UnaryConstraint;
import fii.aeaa.models.Node;

public class ExactColorUnaryConstraint extends UnaryConstraint {

    public ExactColorUnaryConstraint(Node constrainedNode, String constrainedColor) {
        super(constrainedNode, constrainedColor);
    }

    @Override
    public boolean isConsistent(String constrainedColor) {
        return constrainedColor.equals(this.constrainedColor);
    }
}
