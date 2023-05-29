package fii.aeaa.instances;

import fii.aeaa.constraints.binary.core.BinaryConstraint;
import fii.aeaa.constraints.managers.GraphConstraintManagerImpl;
import fii.aeaa.models.Graph;
import fii.aeaa.models.Node;
import fii.aeaa.utils.ConstraintCreator;
import fii.aeaa.utils.DomainCreator;

import java.util.*;

public class AustraliaInstance extends TestInstance{
    protected void initGraph(){
        graph = new Graph();

        Node WA = new Node("WA");
        Node NT = new Node("NT");
        Node Q = new Node("Q");
        Node SA = new Node("SA");
        Node NSW = new Node("NSW");
        Node V = new Node("V");
        Node T = new Node("T");

        graph.addNode(NT);
        graph.addNode(Q);
        graph.addNode(SA);
        graph.addNode(NSW);
        graph.addNode(V);
        graph.addNode(T);
        graph.addNode(WA);

        graph.addEdge(WA, NT);
        graph.addEdge(WA, SA);
        graph.addEdge(NT, Q);
        graph.addEdge(SA, Q);
        graph.addEdge(Q, NSW);
        graph.addEdge(SA, NSW);
        graph.addEdge(SA, V);
        graph.addEdge(NSW, V);

        DomainCreator.createDomainFourColors(graph.getNodesDFS());
    }

    @Override
    protected void initConstraintManager() {
        Set<BinaryConstraint> binaryConstraints = ConstraintCreator.createAdjacencyConstraints(graph);

        graphConstraintManager = new GraphConstraintManagerImpl()
                .withBinaryConstraints(binaryConstraints)
                .build();
    }
}
