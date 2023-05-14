package fii.aeaa.constraints.managers;

import fii.aeaa.constraints.Constraint;
import fii.aeaa.constraints.ConstraintType;
import fii.aeaa.models.Color;
import fii.aeaa.models.Node;

import java.util.Map;
import java.util.Set;

public interface GraphConstraintManager {
    boolean isConsistent(Map<Node, Color> coloredNodesResult, Node currentNode, Color currentColor);
    Set<Constraint> getConstraints(ConstraintType constraintType);
}
