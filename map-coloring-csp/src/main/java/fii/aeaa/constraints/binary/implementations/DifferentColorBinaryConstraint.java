package fii.aeaa.constraints.binary.implementations;

import fii.aeaa.constraints.binary.core.BinaryConstraint;
import fii.aeaa.models.Color;
import fii.aeaa.models.Node;

import java.util.List;

public class DifferentColorBinaryConstraint extends BinaryConstraint {

    public DifferentColorBinaryConstraint(Node firstNode, Node secondNode) {
        super(firstNode, secondNode);
    }

    @Override
    public boolean isConsistent(List<Color> colors) {
        if(colors == null || colors.size() != 2){
            return false;
        }
        String firstNodeColorString = colors.get(0).toString();
        String secondNodeColorString = colors.get(1).toString();
        return !firstNodeColorString.equals(secondNodeColorString);
    }
}
