package fii.aeaa.algorithms.core;

import fii.aeaa.constraints.GraphColoringConstraint;
import fii.aeaa.models.Color;
import fii.aeaa.models.Graph;
import fii.aeaa.models.Node;

import java.util.Map;

public abstract class ColoringAlgorithm {
    protected final Graph graph;
    protected GraphColoringConstraint graphColoringConstraint;

    public ColoringAlgorithm(Graph graph, GraphColoringConstraint graphColoringConstraint){
        this.graph = graph;
        this.graphColoringConstraint = graphColoringConstraint;
    }

    public abstract Map<Node, Color> colorGraph();
}
