package fii.aeaa.algorithms.core;

import fii.aeaa.constraints.GraphColoringConstraint;
import fii.aeaa.models.Graph;
import fii.aeaa.models.Node;

import java.util.Map;

public abstract class ColoringAlgorithm {
    protected final Graph graph;
    protected final String[] availableColors;
    protected GraphColoringConstraint graphColoringConstraint;

    public ColoringAlgorithm(Graph graph, String[] availableColors, GraphColoringConstraint graphColoringConstraint){
        this.graph = graph;
        this.availableColors = availableColors;
        this.graphColoringConstraint = graphColoringConstraint;
    }

    public abstract Map<Node, String> colorGraph();
}
