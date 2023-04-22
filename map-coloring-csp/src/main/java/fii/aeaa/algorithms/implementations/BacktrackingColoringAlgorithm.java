package fii.aeaa.algorithms.implementations;

import fii.aeaa.algorithms.core.ColoringAlgorithm;
import fii.aeaa.constraints.GraphColoringConstraint;
import fii.aeaa.models.Graph;
import fii.aeaa.models.Node;

import java.util.*;

public class BacktrackingColoringAlgorithm extends ColoringAlgorithm {

    public BacktrackingColoringAlgorithm(Graph graph, String[] availableColors,
                                         GraphColoringConstraint graphColoringConstraint) {
        super(graph, availableColors, graphColoringConstraint);
    }

    @Override
    public Map<Node, String> colorGraph() {
        Map<Node, String> coloredNodesResult = new HashMap<>();
        Set<Node> uncoloredNodes = this.graph.getNodesDFS();

        boolean solution = backtrackingSearch(coloredNodesResult, uncoloredNodes);

        if(solution){
            System.out.println("Nodes colored successfully:");
            coloredNodesResult.forEach((node, color) -> System.out.println(node + ": " + color));
        } else {
            System.out.println("Failed to color nodes using " + availableColors.length + " colors.");
        }

        return coloredNodesResult;
    }

    private boolean backtrackingSearch(Map<Node, String> coloredNodesResult, Set<Node> uncoloredNodes) {
        // assignment is complete
        if (uncoloredNodes.isEmpty()) {
            return true;
        }

        // Select-Unassigned-Variable
        Node currentNode = uncoloredNodes.iterator().next();
        System.out.println("Node received: " + currentNode);

        // for each value in Order-Domain-Value
        for (String currentColor : availableColors) {
            // check if value is consistent with assignment
            if (graphColoringConstraint.isConsistent(coloredNodesResult, currentNode, currentColor)) {

                // add value to assignment
                coloredNodesResult.put(currentNode, currentColor);
                uncoloredNodes.remove(currentNode);

                // inferences will be added here //

                // continue with the next unassigned variable
                if (backtrackingSearch(coloredNodesResult, uncoloredNodes)) {
                    return true;
                }

                // Backtrack (constraints not satisfied)
                System.out.println("backtrack");
                coloredNodesResult.remove(currentNode);
                uncoloredNodes.add(currentNode);
            }
        }

        // No valid coloring found
        return false;
    }
}
