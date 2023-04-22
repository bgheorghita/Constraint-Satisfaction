package fii.aeaa.constraints.global;

import fii.aeaa.models.Node;

public class AllDiff extends GlobalConstraint{

    public AllDiff(Node... constrainedNodes){
        super(constrainedNodes);
    }

    @Override
    public boolean isConsistent(String firstNodeColor, String secondNodeColor) {
        return !firstNodeColor.equals(secondNodeColor);
    }
}
