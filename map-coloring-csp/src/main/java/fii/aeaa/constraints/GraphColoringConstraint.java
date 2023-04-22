package fii.aeaa.constraints;

import fii.aeaa.models.Color;
import fii.aeaa.models.Node;

import java.util.Map;

public interface GraphColoringConstraint {
    boolean isConsistent(Map<Node, Color> coloredNodesResult, Node currentNode, Color currentColor);
}
