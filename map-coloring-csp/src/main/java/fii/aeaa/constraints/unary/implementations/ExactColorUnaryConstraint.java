package fii.aeaa.constraints.unary.implementations;


import fii.aeaa.constraints.unary.core.UnaryConstraint;
import fii.aeaa.models.Color;
import fii.aeaa.models.Node;

import java.util.List;

public class ExactColorUnaryConstraint extends UnaryConstraint {

    public ExactColorUnaryConstraint(Node constrainedNode, Color constrainedColor) {
        super(constrainedNode, constrainedColor);
    }

    @Override
    public boolean isConsistent(List<Color> colors) {
        if(colors == null || colors.size() != 1){
            return false;
        }
        String constraintColorString = constrainedColor.toString();
        String wantedColorString = colors.get(0).toString();
        return constraintColorString.equals(wantedColorString);
    }
}
