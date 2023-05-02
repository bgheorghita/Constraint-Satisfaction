package fii.aeaa.algorithms.implementations;

import fii.aeaa.algorithms.core.ColoringAlgorithm;
import fii.aeaa.constraints.GraphColoringConstraint;
import fii.aeaa.models.Color;
import fii.aeaa.models.Graph;
import fii.aeaa.models.Node;

import java.util.*;

public class BacktrackingColoringAlgorithm extends ColoringAlgorithm {

    public BacktrackingColoringAlgorithm(Graph graph, GraphColoringConstraint graphColoringConstraint) {
        super(graph, graphColoringConstraint);
    }

    @Override
    public Map<Node, Color> colorGraph() {
        Map<Node, Color> coloredNodesResult = new HashMap<>();
        Set<Node> uncoloredNodes = this.graph.getNodesDFS();

        boolean solution = backtrackingSearch(coloredNodesResult, uncoloredNodes);

        if(solution){
            System.out.println("Nodes colored successfully:");
            coloredNodesResult.forEach((node, color) -> System.out.println(node + ": " + color));
        } else {
            System.out.println("Failed to color nodes.");
        }

        return coloredNodesResult;
    }

    private boolean backtrackingSearch(Map<Node, Color> coloredNodesResult, Set<Node> uncoloredNodes) {
        // assignment is complete
        if (uncoloredNodes.isEmpty()) {
            return true;
        }

        // Select-Unassigned-Variable
        Node currentNode = uncoloredNodes.iterator().next();
        Set<Color> currentDomain = currentNode.getDomain();
        System.out.println("Node received: " + currentNode + ", domain: " + currentDomain);

        // for each value in Order-Domain-Value
        for (Color currentColor : currentDomain) {
            // check if value is consistent with assignment
            if (graphColoringConstraint.isConsistent(coloredNodesResult, currentNode, currentColor)) {

                // add value to assignment
                coloredNodesResult.put(currentNode, currentColor);
                uncoloredNodes.remove(currentNode);

                // inferences //
                applyForwardChecking(uncoloredNodes, currentNode, currentColor);

                // continue with the next unassigned variable
                if (backtrackingSearch(coloredNodesResult, uncoloredNodes)) {
                    return true;
                }

                // Backtrack (constraints not satisfied)
                System.out.println("backtrack");
                coloredNodesResult.remove(currentNode);
                uncoloredNodes.add(currentNode);
                redoForwardChecking(uncoloredNodes, currentNode, currentColor);
            }
        }

        // No valid coloring found
        return false;
    }

    private void redoForwardChecking(Set<Node> uncoloredNodes, Node currentNode, Color currentColor) {
        Set<Node> neighbors = this.graph.getNodeNeighbors(currentNode);
        neighbors.forEach(neighbor -> {
            if(uncoloredNodes.contains(neighbor)){
                neighbor.addToDomain(currentColor);
            }
        });
    }

    private void applyForwardChecking(Set<Node> uncoloredNodes, Node currentNode, Color currentColor) {
        Set<Node> neighbors = this.graph.getNodeNeighbors(currentNode);
        neighbors.forEach(neighbor -> {
            if(uncoloredNodes.contains(neighbor)){
                neighbor.removeFromDomain(currentColor);
            }
        });
    }
}
