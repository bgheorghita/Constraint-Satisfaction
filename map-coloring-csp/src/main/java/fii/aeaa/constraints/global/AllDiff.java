package fii.aeaa.constraints.global;

import fii.aeaa.models.Color;
import fii.aeaa.models.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllDiff extends GlobalConstraint{

    public AllDiff(List<Node> constrainedNodes){
        super(constrainedNodes);
    }

    @Override
    public boolean isConsistent(List<Color> colors) {
        if(colors == null){
            return false;
        }

        Queue<Color> visitedColors = new LinkedList<>();
        for(Color color : colors){
            if(visitedColors.contains(color)){
                return false;
            } else {
                visitedColors.add(color);
            }
        }
        return true;
    }
}
