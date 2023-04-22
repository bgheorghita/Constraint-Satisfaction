package fii.aeaa;


import fii.aeaa.algorithms.implementations.BacktrackingColoringAlgorithm;
import fii.aeaa.algorithms.core.ColoringAlgorithm;
import fii.aeaa.constraints.binary.core.BinaryConstraint;
import fii.aeaa.constraints.binary.implementations.DifferentColorBinaryConstraint;
import fii.aeaa.constraints.GraphColoringConstraint;
import fii.aeaa.constraints.global.AllDiff;
import fii.aeaa.constraints.global.GlobalConstraint;
import fii.aeaa.constraints.GraphColoringConstraintImpl;
import fii.aeaa.constraints.unary.core.UnaryConstraint;
import fii.aeaa.constraints.unary.implementations.DifferentColorUnaryConstraint;
import fii.aeaa.constraints.unary.implementations.ExactColorUnaryConstraint;
import fii.aeaa.models.Color;
import fii.aeaa.models.Graph;
import fii.aeaa.models.Node;

public class Main {
    public static void main(java.lang.String[] args) {
        Graph graph = new Graph();
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

        graph.print();

        Color[] colors = new Color[]{Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};

        UnaryConstraint WA_ColorIsGreen = new ExactColorUnaryConstraint(WA, Color.GREEN);
        UnaryConstraint T_ColorIsBlue = new ExactColorUnaryConstraint(T, Color.BLUE);
        UnaryConstraint SA_ColorIsNotRed = new DifferentColorUnaryConstraint(SA, Color.RED);
        BinaryConstraint V_IsDifferentColorThan_Q = new DifferentColorBinaryConstraint(V, Q);
        GlobalConstraint Q_And_WA_And_T_DifferentColors = new AllDiff(Q, WA, T);

        GraphColoringConstraint graphColoringConstraints = new GraphColoringConstraintImpl()
                .withActivatedAdjacencyNodesDiffColorConstraint(graph)
                .withUnaryConstraints(new UnaryConstraint[]{WA_ColorIsGreen, T_ColorIsBlue, SA_ColorIsNotRed})
                .withGlobalConstraints(new GlobalConstraint[]{Q_And_WA_And_T_DifferentColors})
                .withBinaryConstraints(new BinaryConstraint[]{V_IsDifferentColorThan_Q})
                .build();

        ColoringAlgorithm algorithm = new BacktrackingColoringAlgorithm(graph, colors, graphColoringConstraints);

        algorithm.colorGraph();
    }
}