package fii.aeaa;


import fii.aeaa.algorithms.implementations.BacktrackingColoringAlgorithm;
import fii.aeaa.algorithms.core.ColoringAlgorithm;
import fii.aeaa.constraints.managers.GraphConstraintManager;
import fii.aeaa.constraints.managers.GraphConstraintManagerImpl;
import fii.aeaa.display.DisplayGraph;
import fii.aeaa.models.Color;
import fii.aeaa.models.Graph;
import fii.aeaa.models.Node;
import fii.aeaa.readers.GraphReader;
import fii.aeaa.utils.ConstraintCreator;
import fii.aeaa.utils.DomainCreator;

import java.util.*;

public class Main {
    public static void main(java.lang.String[] args) {
        int nodes = 50;
        int edges = 100;

        GraphReader graphReader = new GraphReader();
        Graph graph = graphReader.readFromFile(System.getProperty("user.dir") + "\\src\\main\\java\\fii\\aeaa\\instances\\generated\\" + nodes + "_"+edges + ".txt");
        DomainCreator.createDomainFourColors(graph.getNodesDFS());
        GraphConstraintManager graphConstraintManager = new GraphConstraintManagerImpl()
                .withBinaryConstraints(ConstraintCreator.createAdjacencyConstraints(graph))
                .build();
        ColoringAlgorithm algorithm = new BacktrackingColoringAlgorithm(graph, graphConstraintManager);
        Map<Node, Color> mapColorResult = algorithm.colorGraph();
        DisplayGraph.drawColoredGraph(graph, mapColorResult);

//        Graph generatedGraph = GraphGenerator.generate(nodes, edges);
//        new GraphWriter().writeToFile(generatedGraph, System.getProperty("user.dir") + "\\src\\main\\java\\fii\\aeaa\\instances\\generated\\" + nodes + "_"+edges + ".txt");

        // Romania Instance
//        TestInstance romaniaInstance = new RomaniaInstance();
//        GraphConstraintManager romaniaGraphConstraintManager = romaniaInstance.getGraphConstraintManager();
//        Graph romaniaGraph = romaniaInstance.getGraph();
//
//        ColoringAlgorithm romaniaColoringAlgorithm = new BacktrackingColoringAlgorithm(romaniaGraph, romaniaGraphConstraintManager);
//        Map<Node, Color> romaniaMapColorResult = romaniaColoringAlgorithm.colorGraph();
        //DisplayGraph.drawColoredGraph(romaniaGraph, romaniaMapColorResult);
    }
}