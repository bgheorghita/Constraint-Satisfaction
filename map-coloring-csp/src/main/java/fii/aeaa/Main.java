package fii.aeaa;


import fii.aeaa.algorithms.implementations.BacktrackingColoringAlgorithm;
import fii.aeaa.algorithms.core.ColoringAlgorithm;
import fii.aeaa.constraints.managers.GraphConstraintManager;
import fii.aeaa.display.DisplayGraph;
import fii.aeaa.instances.AustraliaInstance;
import fii.aeaa.instances.RomaniaInstance;
import fii.aeaa.instances.TestInstance;
import fii.aeaa.models.Color;
import fii.aeaa.models.Graph;
import fii.aeaa.models.Node;

import java.util.*;

public class Main {
    public static void main(java.lang.String[] args) {

        // Australia Instance
//        TestInstance australiaInstance = new AustraliaInstance();
//        GraphConstraintManager australiaConstraintManager = australiaInstance.getGraphConstraintManager();
//        Graph australiaGraph = australiaInstance.getGraph();
//
//        ColoringAlgorithm colorAustraliaAlgorithm = new BacktrackingColoringAlgorithm(australiaGraph, australiaConstraintManager);
//        Map<Node, Color> australiaMapColorResult = colorAustraliaAlgorithm.colorGraph();
//        DisplayGraph.drawColoredGraph(australiaGraph, australiaMapColorResult);


        // Romania Instance
        TestInstance romaniaInstance = new RomaniaInstance();
        GraphConstraintManager romaniaGraphConstraintManager = romaniaInstance.getGraphConstraintManager();
        Graph romaniaGraph = romaniaInstance.getGraph();

        ColoringAlgorithm romaniaColoringAlgorithm = new BacktrackingColoringAlgorithm(romaniaGraph, romaniaGraphConstraintManager);
        Map<Node, Color> romaniaMapColorResult = romaniaColoringAlgorithm.colorGraph();
        DisplayGraph.drawColoredGraph(romaniaGraph, romaniaMapColorResult);
    }
}