package fii.aeaa.constraints;

import fii.aeaa.constraints.binary.core.BinaryConstraint;
import fii.aeaa.constraints.global.GlobalConstraint;
import fii.aeaa.constraints.unary.core.UnaryConstraint;
import fii.aeaa.models.Color;
import fii.aeaa.models.Graph;
import fii.aeaa.models.Node;

import java.util.Map;
import java.util.Set;

public class GraphColoringConstraintImpl implements GraphColoringConstraint {

    protected Graph graph;
    protected UnaryConstraint[] unaryConstraints;
    protected BinaryConstraint[] binaryConstraints;
    protected GlobalConstraint[] globalConstraints;
    protected boolean adjacencyNodesDiffColorConstraint;

    public GraphColoringConstraintImpl(){}

    private GraphColoringConstraintImpl(Graph graph, UnaryConstraint[] unaryConstraints, BinaryConstraint[] binaryConstraints,
                                        GlobalConstraint[] globalConstraints, boolean adjacencyNodesDiffColorConstraint) {
        this.graph = graph;
        this.unaryConstraints = unaryConstraints;
        this.binaryConstraints = binaryConstraints;
        this.globalConstraints = globalConstraints;
        this.adjacencyNodesDiffColorConstraint = adjacencyNodesDiffColorConstraint;
    }

    public GraphColoringConstraintImpl withUnaryConstraints(UnaryConstraint[] unaryConstraints) {
        this.unaryConstraints = unaryConstraints;
        return this;
    }

    public GraphColoringConstraintImpl withBinaryConstraints(BinaryConstraint[] binaryConstraints) {
        this.binaryConstraints = binaryConstraints;
        return this;
    }

    public GraphColoringConstraintImpl withGlobalConstraints(GlobalConstraint[] globalConstraints) {
        this.globalConstraints = globalConstraints;
        return this;
    }

    public GraphColoringConstraintImpl withActivatedAdjacencyNodesDiffColorConstraint(Graph graph) {
        this.graph = graph;
        this.adjacencyNodesDiffColorConstraint = true;
        return this;
    }

    public GraphColoringConstraintImpl build() {
        return new GraphColoringConstraintImpl(graph, unaryConstraints, binaryConstraints, globalConstraints, adjacencyNodesDiffColorConstraint);
    }

    // no adjacent nodes can have the same color
    private boolean adjacentNodesDiffColorConstraintNotSatisfied(Node currentNode, Color currentColor, Map<Node, Color> coloredNodesResult) {
        if(!adjacencyNodesDiffColorConstraint){
            return false;
        }

        Set<Node> currentNodeNeighbors = graph.getNodeNeighbors(currentNode);
        for (Node nodeNeighbor : currentNodeNeighbors) {
            Color nodeNeighborColor = coloredNodesResult.get(nodeNeighbor);
            if (coloredNodesResult.containsKey(nodeNeighbor) && currentColor.equals(nodeNeighborColor)) {
                return true;
            }
        }
        return false;
    }

    private boolean globalConstraintsNotSatisfied(Node currentNode, Color currentColor, Map<Node, Color> coloredNodesResult) {
        if(globalConstraints == null) {
            return false;
        }

        for(GlobalConstraint globalConstraint : globalConstraints){
            for (Node constrainedNode : globalConstraint.getConstrainedNodes()) {
                if (coloredNodesResult.containsKey(constrainedNode)) {
                    Color color = coloredNodesResult.get(constrainedNode);
                    if(globalConstraint.isSubjectTo(currentNode) && !globalConstraint.isConsistent(color, currentColor)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean binaryConstraintsSatisfied(Node currentNode, Color currentColor, Map<Node, Color> coloredNodesResult) {
        if(binaryConstraints == null){
            return true;
        }

        for(BinaryConstraint binaryConstraint : binaryConstraints){
            for(Map.Entry<Node, Color> entry : coloredNodesResult.entrySet()){
                Node node = entry.getKey();
                Color nodeColor = entry.getValue();
                if(binaryConstraint.isSubjectTo(node, currentNode)){
                    if(!binaryConstraint.isConsistent(nodeColor, currentColor)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean unaryConstraintsSatisfied(Node nodeName, Color color) {
        if(unaryConstraints == null){
            return true;
        }

        for(UnaryConstraint unaryConstraint : unaryConstraints){
            if(unaryConstraint.isSubjectTo(nodeName) && !unaryConstraint.isConsistent(color)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isConsistent(Map<Node, Color> coloredNodesResult, Node currentNode, Color currentColor) {
        boolean unaryConstraintsSatisfied = unaryConstraintsSatisfied(currentNode, currentColor);
        boolean binaryConstrainsSatisfied = binaryConstraintsSatisfied(currentNode, currentColor, coloredNodesResult);
        boolean globalConstraintsSatisfied = !globalConstraintsNotSatisfied(currentNode, currentColor, coloredNodesResult);
        boolean adjacentNodesDiffColorConstraintSatisfied = !adjacentNodesDiffColorConstraintNotSatisfied(currentNode, currentColor, coloredNodesResult);
        return unaryConstraintsSatisfied && binaryConstrainsSatisfied && globalConstraintsSatisfied && adjacentNodesDiffColorConstraintSatisfied;
    }
}
