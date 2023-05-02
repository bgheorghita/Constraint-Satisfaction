package fii.aeaa;


import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.layout.hierarchical.stage.mxCoordinateAssignment;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import fii.aeaa.algorithms.implementations.BacktrackingColoringAlgorithm;
import fii.aeaa.algorithms.core.ColoringAlgorithm;
import fii.aeaa.constraints.GraphColoringConstraint;
import fii.aeaa.constraints.GraphColoringConstraintImpl;
import fii.aeaa.constraints.binary.core.BinaryConstraint;
import fii.aeaa.constraints.binary.implementations.DifferentColorBinaryConstraint;
import fii.aeaa.constraints.global.AllDiff;
import fii.aeaa.constraints.global.GlobalConstraint;
import fii.aeaa.constraints.unary.core.UnaryConstraint;
import fii.aeaa.constraints.unary.implementations.DifferentColorUnaryConstraint;
import fii.aeaa.constraints.unary.implementations.ExactColorUnaryConstraint;
import fii.aeaa.models.Color;
import fii.aeaa.models.Graph;
import fii.aeaa.models.Node;

import javax.swing.*;
import java.util.*;

public class Main {
    public static void main(java.lang.String[] args) {
        Graph graph = new Graph();
//        Node SatuMare = new Node("Satu Mare");
//        Node Bihor = new Node("Bihor");
//        Node Arad = new Node("Arad");
//        Node Timisoara = new Node("Timisoara");
//        Node CarasServerin = new Node("Caras Serverin");
//        Node Mehedinti = new Node("Mehedinti");
//        Node Dolj = new Node("Dolj");
//        Node Olt = new Node("Olt");
//        Node Teleorman = new Node("Teleorman");
//        Node Giurgiu = new Node("Giurgiu");
//        Node Calarasi = new Node("Calarasi");
//        Node Constanta = new Node("Constanta");
//        Node Tulcea = new Node("Tulcea");
//        Node Braila = new Node("Braila");
//        Node Galati = new Node("Galati");
//        Node Vaslui = new Node("Vaslui");
//        Node Iasi = new Node("Iasi");
//        Node Botosani = new Node("Botosani");
//        Node Suceava = new Node("Suceava");
//        Node BistritaNasaud = new Node("Bistrita-Nasaud");
//        Node Maramures = new Node("Maramures");
//        Node Salaj = new Node("Salaj");
//        Node Cluj = new Node("Cluj");
//        Node Alba = new Node("Alba");
//        Node Hunedoara = new Node("Hunedoara");
//        Node Gorj = new Node("Gorj");
//        Node Valcea = new Node("Valcea");
//        Node Arges = new Node("Arges");
//        Node Dambovita = new Node("Dambovita");
//        Node Bucuresti = new Node("Bucuresti");
//        Node Ialomita = new Node("Ialomita");
//        Node Prahova = new Node("Prahova");
//        Node Buzau = new Node("Buzau");
//        Node Vrancea = new Node("Vrancea");
//        Node Bacau = new Node("Bacau");
//        Node Neamt = new Node("Neamt");
//        Node Harghita = new Node("Harghita");
//        Node Mures = new Node("Mures");
//        Node Sibiu = new Node("Sibiu");
//        Node Brasov = new Node("Brasov");
//        Node Covasna = new Node("Covasna");
//
//        graph.addNode(SatuMare);
//        graph.addNode(Bihor);
//        graph.addNode(Arad);
//        graph.addNode(Timisoara);
//        graph.addNode(CarasServerin);
//        graph.addNode(Mehedinti);
//        graph.addNode(Dolj);
//        graph.addNode(Olt);
//        graph.addNode(Teleorman);
//        graph.addNode(Giurgiu);
//        graph.addNode(Calarasi);
//        graph.addNode(Constanta);
//        graph.addNode(Tulcea);
//        graph.addNode(Braila);
//        graph.addNode(Galati);
//        graph.addNode(Vaslui);
//        graph.addNode(Iasi);
//        graph.addNode(Botosani);
//        graph.addNode(Suceava);
//        graph.addNode(BistritaNasaud);
//        graph.addNode(Maramures);
//        graph.addNode(Salaj);
//        graph.addNode(Cluj);
//        graph.addNode(Alba);
//        graph.addNode(Hunedoara);
//        graph.addNode(Gorj);
//        graph.addNode(Valcea);
//        graph.addNode(Arges);
//        graph.addNode(Dambovita);
//        graph.addNode(Bucuresti);
//        graph.addNode(Ialomita);
//        graph.addNode(Prahova);
//        graph.addNode(Buzau);
//        graph.addNode(Vrancea);
//        graph.addNode(Bacau);
//        graph.addNode(Neamt);
//        graph.addNode(Harghita);
//        graph.addNode(Mures);
//        graph.addNode(Sibiu);
//        graph.addNode(Brasov);
//        graph.addNode(Covasna);
//
//        graph.addEdge(SatuMare, Bihor);
//        graph.addEdge(SatuMare, Salaj);
//        graph.addEdge(SatuMare, Maramures);
//        graph.addEdge(Bihor, Arad);
//        graph.addEdge(Bihor, Salaj);
//        graph.addEdge(Bihor, Cluj);
//        graph.addEdge(Arad, Hunedoara);
//        graph.addEdge(Arad, Alba);
//        graph.addEdge(Arad, Timisoara);
//        graph.addEdge(Timisoara, CarasServerin);
//        graph.addEdge(Timisoara, Hunedoara);
//        graph.addEdge(CarasServerin, Hunedoara);
//        graph.addEdge(CarasServerin, Gorj);
//        graph.addEdge(CarasServerin, Mehedinti);
//        graph.addEdge(Mehedinti, Gorj);
//        graph.addEdge(Mehedinti, Dolj);
//        graph.addEdge(Dolj, Olt);
//        graph.addEdge(Dolj, Valcea);
//        graph.addEdge(Dolj, Gorj);
//        graph.addEdge(Olt, Valcea);
//        graph.addEdge(Olt, Arges);
//        graph.addEdge(Olt, Teleorman);
//        graph.addEdge(Maramures, BistritaNasaud);
//        graph.addEdge(Maramures, Suceava);
//        graph.addEdge(Maramures, Salaj);
//        graph.addEdge(Maramures, Cluj);
//        graph.addEdge(Cluj, Salaj);
//        graph.addEdge(Cluj, BistritaNasaud);
//        graph.addEdge(Cluj, Alba);
//        graph.addEdge(Cluj, Mures);
//        graph.addEdge(Alba, Hunedoara);
//        graph.addEdge(Alba, Mures);
//        graph.addEdge(Alba, Sibiu);
//        graph.addEdge(Alba, Bihor);
//        graph.addEdge(Alba, Valcea);
//        graph.addEdge(Hunedoara, Valcea);
//        graph.addEdge(Hunedoara, Gorj);
//        graph.addEdge(Gorj, Valcea);
//        graph.addEdge(BistritaNasaud, Suceava);
//        graph.addEdge(BistritaNasaud, Mures);
//        graph.addEdge(Mures, Sibiu);
//        graph.addEdge(Mures, Harghita);
//        graph.addEdge(Mures, Suceava);
//        graph.addEdge(Sibiu, Brasov);
//        graph.addEdge(Sibiu, Valcea);
//        graph.addEdge(Sibiu, Arges);
//        graph.addEdge(Valcea, Arges);
//        graph.addEdge(Teleorman, Arges);
//        graph.addEdge(Teleorman, Dambovita);
//        graph.addEdge(Teleorman, Giurgiu);
//        graph.addEdge(Arges, Brasov);
//        graph.addEdge(Arges, Dambovita);
//        graph.addEdge(Giurgiu, Dambovita);
//        graph.addEdge(Giurgiu, Bucuresti);
//        graph.addEdge(Giurgiu, Calarasi);
//        graph.addEdge(Bucuresti, Calarasi);
//        graph.addEdge(Bucuresti, Dambovita);
//        graph.addEdge(Bucuresti, Prahova);
//        graph.addEdge(Bucuresti, Ialomita);
//        graph.addEdge(Prahova, Dambovita);
//        graph.addEdge(Prahova, Brasov);
//        graph.addEdge(Prahova, Buzau);
//        graph.addEdge(Prahova, Ialomita);
//        graph.addEdge(Brasov, Mures);
//        graph.addEdge(Brasov, Harghita);
//        graph.addEdge(Brasov, Covasna);
//        graph.addEdge(Brasov, Buzau);
//        graph.addEdge(Brasov, Dambovita);
//        graph.addEdge(Harghita, Suceava);
//        graph.addEdge(Harghita, Covasna);
//        graph.addEdge(Harghita, Neamt);
//        graph.addEdge(Harghita, Bacau);
//        graph.addEdge(Suceava, Neamt);
//        graph.addEdge(Suceava, Botosani);
//        graph.addEdge(Suceava, Iasi);
//        graph.addEdge(Neamt, Bacau);
//        graph.addEdge(Neamt, Iasi);
//        graph.addEdge(Neamt, Vaslui);
//        graph.addEdge(Bacau, Covasna);
//        graph.addEdge(Bacau, Vrancea);
//        graph.addEdge(Bacau, Vaslui);
//        graph.addEdge(Vrancea, Covasna);
//        graph.addEdge(Vrancea, Vaslui);
//        graph.addEdge(Vrancea, Galati);
//        graph.addEdge(Vrancea, Buzau);
//        graph.addEdge(Vrancea, Braila);
//        graph.addEdge(Buzau, Covasna);
//        graph.addEdge(Buzau, Braila);
//        graph.addEdge(Buzau, Ialomita);
//        graph.addEdge(Ialomita, Calarasi);
//        graph.addEdge(Ialomita, Braila);
//        graph.addEdge(Ialomita, Constanta);
//        graph.addEdge(Calarasi, Constanta);
//        graph.addEdge(Constanta, Braila);
//        graph.addEdge(Constanta, Tulcea);
//        graph.addEdge(Tulcea, Braila);
//        graph.addEdge(Tulcea, Galati);
//        graph.addEdge(Galati, Braila);
//        graph.addEdge(Galati, Vaslui);
//        graph.addEdge(Vaslui, Iasi);
//        graph.addEdge(Iasi, Botosani);

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

        Set<Node> nodes = graph.getNodesDFS();
        nodes.forEach(node -> node.setDomain(createDomainFourColors()));

        graph.print();

//        UnaryConstraint WA_ColorIsGreen = new ExactColorUnaryConstraint(WA, Color.GREEN);
//        UnaryConstraint T_ColorIsBlue = new ExactColorUnaryConstraint(T, Color.BLUE);
//        UnaryConstraint SA_ColorIsNotRed = new DifferentColorUnaryConstraint(SA, Color.RED);
//        BinaryConstraint V_IsDifferentColorThan_Q = new DifferentColorBinaryConstraint(V, Q);
//        GlobalConstraint Q_And_WA_And_T_DifferentColors = new AllDiff(Q, WA, T);

        GraphColoringConstraint graphColoringConstraints = new GraphColoringConstraintImpl()
                .withActivatedAdjacencyNodesDiffColorConstraint(graph)
//                .withUnaryConstraints(new UnaryConstraint[]{WA_ColorIsGreen, T_ColorIsBlue, SA_ColorIsNotRed})
//                .withGlobalConstraints(new GlobalConstraint[]{Q_And_WA_And_T_DifferentColors})
//                .withBinaryConstraints(new BinaryConstraint[]{V_IsDifferentColorThan_Q})
                .build();

        ColoringAlgorithm algorithm = new BacktrackingColoringAlgorithm(graph, graphColoringConstraints);

        Map<Node, Color> coloredNodesResult = algorithm.colorGraph();
        displayColoredGraph(graph, coloredNodesResult);
    }

    private static Set<Color> createDomainFourColors(){
        return new LinkedHashSet<>(Arrays.asList(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW));
    }

    private static void displayColoredGraph(Graph graph, Map<Node, Color> coloredNodes){
        mxGraph coloredGraph = new mxGraph();
        Object parent = coloredGraph.getDefaultParent();
        Map<Node, Object> vertexMap = new HashMap<>();

        for (Map.Entry<Node, Set<Node>> entry : graph.getAdjacencyList().entrySet()) {
            Node node = entry.getKey();
            Set<Node> neighbors = entry.getValue();
            String nodeColor = coloredNodes.get(node).getColor();

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
                30.0,  // intraCellSpacing
                30.0,  // interRankCellSpacing
                1,  // orientation
                0.0,  // initialX
                10.0  // parallelEdgeSpacing
        );
        ca.execute(coloredGraph.getDefaultParent());

        mxGraphComponent graphComponent = new mxGraphComponent(coloredGraph);
        JFrame frame = new JFrame();
        frame.getContentPane().add(graphComponent);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);
        frame.setVisible(true);
    }
}