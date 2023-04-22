package fii.aeaa.constraints;

import fii.aeaa.models.Node;

import java.util.Map;

public interface GraphColoringConstraint {
    boolean isConsistent(Map<Node, String> coloredNodesResult, Node currentNode, String currentColor);
}
