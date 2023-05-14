package fii.aeaa.algorithms.core;

import fii.aeaa.constraints.managers.GraphConstraintManager;
import fii.aeaa.models.Color;
import fii.aeaa.models.Graph;
import fii.aeaa.models.Node;

import java.util.Map;

public abstract class ColoringAlgorithm {
    protected final Graph graph;
    protected GraphConstraintManager graphConstraintManager;

    public ColoringAlgorithm(Graph graph, GraphConstraintManager graphConstraintManager){
        this.graph = graph;
        this.graphConstraintManager = graphConstraintManager;
    }

    public abstract Map<Node, Color> colorGraph();
}
