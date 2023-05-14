package fii.aeaa.utils;

import fii.aeaa.constraints.binary.core.BinaryConstraint;
import fii.aeaa.constraints.binary.implementations.DifferentColorBinaryConstraint;
import fii.aeaa.models.Graph;
import fii.aeaa.models.Node;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConstraintCreator {
    public static Set<BinaryConstraint> createAdjacencyConstraints(Graph graph) {
        Set<BinaryConstraint> binaryConstraints = new HashSet<>();
        Map<Node, Set<Node>> adjacencyList = graph.getAdjacencyList();
        for (Map.Entry<Node, Set<Node>> entry : adjacencyList.entrySet()){
            Node node = entry.getKey();
            Set<Node> neighbors = entry.getValue();
            for (Node neighbor : neighbors){
                BinaryConstraint binaryConstraint = new DifferentColorBinaryConstraint(node, neighbor);
                binaryConstraints.add(binaryConstraint);
            }
        }
        return binaryConstraints;
    }
}
