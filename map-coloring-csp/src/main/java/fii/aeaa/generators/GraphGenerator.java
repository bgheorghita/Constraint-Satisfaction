package fii.aeaa.generators;

import fii.aeaa.models.Graph;
import fii.aeaa.models.Node;

import java.util.Random;

public class GraphGenerator {
    public static Graph generate(int nodes, int edges){
        Graph graph = new Graph();

        for(int i=0; i<nodes; i++){
            Node node = new Node(String.valueOf(i));
            graph.addNode(node);
        }

        for(int i=0; i<edges; i++){
            int firstNodeName = randomInt(0, nodes - 1);
            int secondNodeName = randomInt(0, nodes - 1);
            Node firstNode = graph.getNodeByName(String.valueOf(firstNodeName));
            Node secondNode = graph.getNodeByName(String.valueOf(secondNodeName));
            if(firstNode.getName().equals(secondNode.getName())){
                edges++;
                continue;
            }
            graph.addEdge(firstNode, secondNode);
        }

        return graph;
    }

    private static int randomInt(int from, int toInclusive){
        int range = toInclusive - from + 1;
        Random random = new Random();
        return random.nextInt(range) + from;
    }
}
