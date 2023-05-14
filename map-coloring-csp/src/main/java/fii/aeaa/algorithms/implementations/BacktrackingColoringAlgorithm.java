package fii.aeaa.algorithms.implementations;

import fii.aeaa.algorithms.core.ColoringAlgorithm;
import fii.aeaa.constraints.ConstraintType;
import fii.aeaa.constraints.managers.GraphConstraintManager;
import fii.aeaa.constraints.binary.core.BinaryConstraint;
import fii.aeaa.models.Arc;
import fii.aeaa.models.Color;
import fii.aeaa.models.Graph;
import fii.aeaa.models.Node;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

public class BacktrackingColoringAlgorithm extends ColoringAlgorithm {

    private int iterationCounter = 0;
    private Set<BinaryConstraint> binaryConstraints;
    private static final Logger LOGGER = LoggerFactory.getLogger(BacktrackingColoringAlgorithm.class);

    public BacktrackingColoringAlgorithm(Graph graph, GraphConstraintManager graphConstraintManager) {
        super(graph, graphConstraintManager);
        initBinaryConstraints();
        loadLoggerPropFile();
    }

    private void loadLoggerPropFile() {
        PropertyConfigurator.configure("src/log4j.properties");
    }

    private void initBinaryConstraints() {
        binaryConstraints = graphConstraintManager
                .getConstraints(ConstraintType.BINARY_CONSTRAINT)
                .stream()
                .map(constraint -> (BinaryConstraint) constraint)
                .collect(Collectors.toSet());
    }

    @Override
    public Map<Node, Color> colorGraph() {
        Map<Node, Color> coloredNodesResult = new HashMap<>();
        Set<Node> uncoloredNodes = this.graph.getNodesDFS();

        long start = System.currentTimeMillis();
        boolean solution = backtrackingSearch(coloredNodesResult, uncoloredNodes);
        long end = System.currentTimeMillis();

        LOGGER.info("Time: " + (end - start) + " ms");
        LOGGER.info("Backtracking iterations: " + iterationCounter);

        if(solution){
            LOGGER.info("Nodes colored successfully.");
            coloredNodesResult.forEach((node, color) -> System.out.println(node + ": " + color));
        } else {
            LOGGER.info("Failed to color nodes.");
            coloredNodesResult = new HashMap<>();
        }

        return coloredNodesResult;
    }

    private boolean backtrackingSearch(Map<Node, Color> coloredNodesResult, Set<Node> uncoloredNodes) {
        // assignment is complete
        if (uncoloredNodes.isEmpty()) {
            return true;
        }

        iterationCounter++;

        // Select-Unassigned-Variable
//        Node currentNode = uncoloredNodes.iterator().next();
        Node currentNode = getVariableMRV(uncoloredNodes, true);
        Set<Color> currentDomain = currentNode.getDomain();
        System.out.println("Node received: " + currentNode + ", domain: " + currentDomain);

        // for each value in Order-Domain-Value
        for (Color currentColor : currentDomain) {
            // check if value is consistent with assignment
            if (graphConstraintManager.isConsistent(coloredNodesResult, currentNode, currentColor)) {

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


    /*
        To use the MRV heuristic, we need to compute the number of remaining legal values
        for each variable that has not yet been assigned a value, and then select the variable
        with the minimum remaining values.
     */
    Node getVariableMRV(Set<Node> uncoloredNodes, boolean applyDegreeHeuristic){
        int minimumRemainingValues = Integer.MAX_VALUE; // smallest domain size of a variable
        int maxDegree = -1;
        Node mostConstrainedVariable = null; // variable with the smallest domain size

        for(Node variable : uncoloredNodes){
            int domainSize = variable.getDomain().size();
            int degree = getNumberOfBinaryConstraints(variable);
            if(domainSize < minimumRemainingValues){
                minimumRemainingValues = domainSize;
                mostConstrainedVariable = variable;
                maxDegree = degree;
            } else if(applyDegreeHeuristic && (domainSize == minimumRemainingValues && degree > maxDegree)){
                mostConstrainedVariable = variable;
                maxDegree = degree;
            }
        }

        return mostConstrainedVariable;
    }

    private int getNumberOfBinaryConstraints(Node node) {
        int numberConstraints = 0;
        for(BinaryConstraint binaryConstraint : binaryConstraints){
            Node firstNodeConstrained = binaryConstraint.getFirstNodeConstrained();
            Node secondNodeConstrained = binaryConstraint.getSecondNodeConstrained();
            if (firstNodeConstrained.getName().equals(node.getName()) || secondNodeConstrained.getName().equals(node.getName())){
                numberConstraints++;
            }
        }
        return numberConstraints;
    }

    private void redoForwardChecking(Set<Node> uncoloredNodes, Node currentNode, Color currentColor) {
        for (BinaryConstraint binaryConstraint : binaryConstraints){
            for(Node uncoloredNode : uncoloredNodes){
                if(binaryConstraint.isSubjectTo(currentNode) && binaryConstraint.isSubjectTo(uncoloredNode)){
                    uncoloredNode.addToDomain(currentColor);
                }
            }
        }
    }

    private void applyForwardChecking(Set<Node> uncoloredNodes, Node currentNode, Color currentColor) {
        for (BinaryConstraint binaryConstraint : binaryConstraints){
            for(Node uncoloredNode : uncoloredNodes){
                if(binaryConstraint.isSubjectTo(currentNode) && binaryConstraint.isSubjectTo(uncoloredNode)){
                    uncoloredNode.removeFromDomain(currentColor);
                }
            }
        }
    }

     /*
     AC3 is a constraint propagation algorithm that reduces the domain of a variable if the domain of another variable
     does not contain any value that satisfies the constraint between the two variables. It iteratively revises the
     domain until it reaches a solution or detects an inconsistency.
     */
    private boolean applyAC3(Set<BinaryConstraint> binaryConstraints) {
        Queue<Arc> arcs = getArcs(binaryConstraints);
        while (!arcs.isEmpty()) {
            Arc arc = arcs.remove();
            Node x = arc.getFrom();
            Node y = arc.getTo();
            if (revise(binaryConstraints, x, y)) {
                if (x.getDomain().isEmpty()) {
                    return false;
                }
                // check possible inconsistencies created due to reduced domains
                // to maintain the rule: no adjacency nodes are colored the same
                Set<Node> neighbors = graph.getNodeNeighbors(x);
                neighbors.forEach(neighbor -> arcs.add(new Arc(neighbor, x)));
            }
        }
        return true;
    }

    private boolean revise(Set<BinaryConstraint> binaryConstraints, Node x, Node y) {
        Optional<BinaryConstraint> constraint = findBinaryConstraint(binaryConstraints, x, y);
        if (constraint.isEmpty()) {
            return false;
        }

        boolean revised = false;
        Set<Color> xDomain = x.getDomain();
        Set<Color> yDomain = y.getDomain();

        for (Color xColor : xDomain) {
            boolean isConsistent = false;
            for (Color yColor : yDomain) {
                if (constraint.get().isConsistent(List.of(xColor, yColor))) {
                    isConsistent = true;
                    break;
                }
            }
            if (!isConsistent) {
                x.removeFromDomain(xColor);
                revised = true;
            }
        }
        return revised;
    }

    private Optional<BinaryConstraint> findBinaryConstraint(Set<BinaryConstraint> binaryConstraints, Node x, Node y) {
        for (BinaryConstraint binaryConstraint : binaryConstraints) {
            if (binaryConstraint.isSubjectTo(x) && binaryConstraint.isSubjectTo(y)) {
                return Optional.of(binaryConstraint);
            }
        }
        return Optional.empty();
    }

    private Queue<Arc> getArcs(Set<BinaryConstraint> binaryConstraints){
        Queue<Arc> arcs = new LinkedList<>();
        for (BinaryConstraint binaryConstraint : binaryConstraints) {
            Arc arc = new Arc(binaryConstraint.getFirstNodeConstrained(), binaryConstraint.getSecondNodeConstrained());
            arcs.add(arc);
        }
        return arcs;
    }
}
