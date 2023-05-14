package fii.aeaa.display;

import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.layout.hierarchical.stage.mxCoordinateAssignment;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import fii.aeaa.models.Color;
import fii.aeaa.models.Graph;
import fii.aeaa.models.Node;

import javax.swing.*;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DisplayGraph {
    public static void drawColoredGraph(Graph graph, Map<Node, Color> coloredNodes){
        int graphSize = graph.getNodesDFS().size();
        int coloredNodesSize = coloredNodes.size();

        if(graphSize != coloredNodesSize){
            throw new InvalidParameterException("Number of colored nodes should be the same as the number of nodes in the graph.");
        }

        mxGraph coloredGraph = new mxGraph();
        Object parent = coloredGraph.getDefaultParent();
        Map<Node, Object> vertexMap = new HashMap<>();

        for (Map.Entry<Node, Set<Node>> entry : graph.getAdjacencyList().entrySet()) {
            Node node = entry.getKey();
            Set<Node> neighbors = entry.getValue();
            String nodeColor = coloredNodes.get(node).toString();

            String style = "fillColor=" + nodeColor + ";fontColor=black;labelBackgroundColor=white;labelBorderColor=black";
            Object vertex = coloredGraph.insertVertex(parent, null, node.getName(), 0, 0, 50, 50, style);
            vertexMap.put(node, vertex);

            for (Node neighbor : neighbors) {
                Object sourceVertex = vertexMap.get(node);
                Object targetVertex = vertexMap.get(neighbor);

                coloredGraph.insertEdge(parent, null, "", sourceVertex, targetVertex);
                coloredGraph.insertEdge(parent, null, "", targetVertex, sourceVertex);
            }
        }

        mxHierarchicalLayout layout = new mxHierarchicalLayout(coloredGraph);
        layout.execute(coloredGraph.getDefaultParent());

        mxCoordinateAssignment ca = new mxCoordinateAssignment(
                layout,
                20.0,  // intraCellSpacing
                20.0,  // interRankCellSpacing
                1,  // orientation
                0.0,  // initialX
                10.0  // parallelEdgeSpacing
        );
//        ca.execute(coloredGraph.getDefaultParent());

        mxGraphComponent graphComponent = new mxGraphComponent(coloredGraph);
        JFrame frame = new JFrame();
        frame.getContentPane().add(graphComponent);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);
        frame.setVisible(true);
    }

    public static void consolePrint(Graph graph){
        Map<Node, Set<Node>> adjacencyList = graph.getAdjacencyList();
        for (Map.Entry<Node, Set<Node>> entry : adjacencyList.entrySet()) {
            Node node = entry.getKey();
            Set<Node> neighbors = entry.getValue();
            System.out.println(node + " -> " + neighbors);
        }
    }
}
