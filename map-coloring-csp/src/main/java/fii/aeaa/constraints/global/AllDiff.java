package fii.aeaa.constraints.global;

import fii.aeaa.models.Color;
import fii.aeaa.models.Node;

public class AllDiff extends GlobalConstraint{

    public AllDiff(Node... constrainedNodes){
        super(constrainedNodes);
    }

    @Override
    public boolean isConsistent(Color firstNodeColor, Color secondNodeColor) {
        return !firstNodeColor.equals(secondNodeColor);
    }
}
