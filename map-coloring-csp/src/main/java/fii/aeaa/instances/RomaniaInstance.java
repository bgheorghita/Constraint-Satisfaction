package fii.aeaa.instances;

import fii.aeaa.constraints.binary.core.BinaryConstraint;
import fii.aeaa.constraints.binary.implementations.DifferentColorBinaryConstraint;
import fii.aeaa.constraints.binary.implementations.ExactColorBinaryConstraint;
import fii.aeaa.constraints.managers.GraphConstraintManagerImpl;
import fii.aeaa.models.Graph;
import fii.aeaa.models.Node;
import fii.aeaa.utils.ConstraintCreator;
import fii.aeaa.utils.DomainCreator;

import java.util.*;

public class RomaniaInstance extends TestInstance{

    @Override
    protected void initConstraintManager() {
        Node Teleorman = graph.getNodeByName("Teleorman");
        Node Alba = graph.getNodeByName("Alba");
        Node Gorj = graph.getNodeByName("Gorj");
        Node Covasna = graph.getNodeByName("Covasna");
        Node Galati = graph.getNodeByName("Galati");
        Node Prahova = graph.getNodeByName("Prahova");
        Node BistritaNasaud = graph.getNodeByName("Bistrita-Nasaud");
        Node Timisoara = graph.getNodeByName("Timisoara");
        Node Maramures = graph.getNodeByName("Maramures");
        Node Valcea = graph.getNodeByName("Valcea");
        Node Ialomita = graph.getNodeByName("Ialomita");
        Node Iasi = graph.getNodeByName("Iasi");
        Node Hunedoara = graph.getNodeByName("Hunedoara");
        Node Neamt = graph.getNodeByName("Neamt");
        Node Bucuresti = graph.getNodeByName("Bucuresti");
        Node Braila = graph.getNodeByName("Braila");

        Set<BinaryConstraint> binaryConstraints = ConstraintCreator.createAdjacencyConstraints(graph);
        binaryConstraints.add(new DifferentColorBinaryConstraint(Teleorman, Alba));
        binaryConstraints.add(new DifferentColorBinaryConstraint(Gorj, Covasna));
        binaryConstraints.add(new DifferentColorBinaryConstraint(Galati, Prahova));
        binaryConstraints.add(new DifferentColorBinaryConstraint(Galati, BistritaNasaud));
        binaryConstraints.add(new DifferentColorBinaryConstraint(Timisoara, Maramures));
        binaryConstraints.add(new DifferentColorBinaryConstraint(Valcea, Ialomita));
        binaryConstraints.add(new ExactColorBinaryConstraint(Iasi, Hunedoara));

        graphConstraintManager = new GraphConstraintManagerImpl()
                .withBinaryConstraints(binaryConstraints)
                .build();
    }

    @Override
    protected void initGraph() {
        graph = new Graph();
        Node SatuMare = new Node("Satu Mare");
        Node Bihor = new Node("Bihor");
        Node Arad = new Node("Arad");
        Node Timisoara = new Node("Timisoara");
        Node CarasServerin = new Node("Caras Serverin");
        Node Mehedinti = new Node("Mehedinti");
        Node Dolj = new Node("Dolj");
        Node Olt = new Node("Olt");
        Node Teleorman = new Node("Teleorman");
        Node Giurgiu = new Node("Giurgiu");
        Node Calarasi = new Node("Calarasi");
        Node Constanta = new Node("Constanta");
        Node Tulcea = new Node("Tulcea");
        Node Braila = new Node("Braila");
        Node Galati = new Node("Galati");
        Node Vaslui = new Node("Vaslui");
        Node Iasi = new Node("Iasi");
        Node Botosani = new Node("Botosani");
        Node Suceava = new Node("Suceava");
        Node BistritaNasaud = new Node("Bistrita-Nasaud");
        Node Maramures = new Node("Maramures");
        Node Salaj = new Node("Salaj");
        Node Cluj = new Node("Cluj");
        Node Alba = new Node("Alba");
        Node Hunedoara = new Node("Hunedoara");
        Node Gorj = new Node("Gorj");
        Node Valcea = new Node("Valcea");
        Node Arges = new Node("Arges");
        Node Dambovita = new Node("Dambovita");
        Node Bucuresti = new Node("Bucuresti");
        Node Ialomita = new Node("Ialomita");
        Node Prahova = new Node("Prahova");
        Node Buzau = new Node("Buzau");
        Node Vrancea = new Node("Vrancea");
        Node Bacau = new Node("Bacau");
        Node Neamt = new Node("Neamt");
        Node Harghita = new Node("Harghita");
        Node Mures = new Node("Mures");
        Node Sibiu = new Node("Sibiu");
        Node Brasov = new Node("Brasov");
        Node Covasna = new Node("Covasna");

        graph.addNode(SatuMare);
        graph.addNode(Bihor);
        graph.addNode(Arad);
        graph.addNode(Timisoara);
        graph.addNode(CarasServerin);
        graph.addNode(Mehedinti);
        graph.addNode(Dolj);
        graph.addNode(Olt);
        graph.addNode(Teleorman);
        graph.addNode(Giurgiu);
        graph.addNode(Calarasi);
        graph.addNode(Constanta);
        graph.addNode(Tulcea);
        graph.addNode(Braila);
        graph.addNode(Galati);
        graph.addNode(Vaslui);
        graph.addNode(Iasi);
        graph.addNode(Botosani);
        graph.addNode(Suceava);
        graph.addNode(BistritaNasaud);
        graph.addNode(Maramures);
        graph.addNode(Salaj);
        graph.addNode(Cluj);
        graph.addNode(Alba);
        graph.addNode(Hunedoara);
        graph.addNode(Gorj);
        graph.addNode(Valcea);
        graph.addNode(Arges);
        graph.addNode(Dambovita);
        graph.addNode(Bucuresti);
        graph.addNode(Ialomita);
        graph.addNode(Prahova);
        graph.addNode(Buzau);
        graph.addNode(Vrancea);
        graph.addNode(Bacau);
        graph.addNode(Neamt);
        graph.addNode(Harghita);
        graph.addNode(Mures);
        graph.addNode(Sibiu);
        graph.addNode(Brasov);
        graph.addNode(Covasna);

        graph.addEdge(SatuMare, Bihor);
        graph.addEdge(SatuMare, Salaj);
        graph.addEdge(SatuMare, Maramures);
        graph.addEdge(Bihor, Arad);
        graph.addEdge(Bihor, Salaj);
        graph.addEdge(Bihor, Cluj);
        graph.addEdge(Arad, Hunedoara);
        graph.addEdge(Arad, Alba);
        graph.addEdge(Arad, Timisoara);
        graph.addEdge(Timisoara, CarasServerin);
        graph.addEdge(Timisoara, Hunedoara);
        graph.addEdge(CarasServerin, Hunedoara);
        graph.addEdge(CarasServerin, Gorj);
        graph.addEdge(CarasServerin, Mehedinti);
        graph.addEdge(Mehedinti, Gorj);
        graph.addEdge(Mehedinti, Dolj);
        graph.addEdge(Dolj, Olt);
        graph.addEdge(Dolj, Valcea);
        graph.addEdge(Dolj, Gorj);
        graph.addEdge(Olt, Valcea);
        graph.addEdge(Olt, Arges);
        graph.addEdge(Olt, Teleorman);
        graph.addEdge(Maramures, BistritaNasaud);
        graph.addEdge(Maramures, Suceava);
        graph.addEdge(Maramures, Salaj);
        graph.addEdge(Maramures, Cluj);
        graph.addEdge(Cluj, Salaj);
        graph.addEdge(Cluj, BistritaNasaud);
        graph.addEdge(Cluj, Alba);
        graph.addEdge(Cluj, Mures);
        graph.addEdge(Alba, Hunedoara);
        graph.addEdge(Alba, Mures);
        graph.addEdge(Alba, Sibiu);
        graph.addEdge(Alba, Bihor);
        graph.addEdge(Alba, Valcea);
        graph.addEdge(Hunedoara, Valcea);
        graph.addEdge(Hunedoara, Gorj);
        graph.addEdge(Gorj, Valcea);
        graph.addEdge(BistritaNasaud, Suceava);
        graph.addEdge(BistritaNasaud, Mures);
        graph.addEdge(Mures, Sibiu);
        graph.addEdge(Mures, Harghita);
        graph.addEdge(Mures, Suceava);
        graph.addEdge(Sibiu, Brasov);
        graph.addEdge(Sibiu, Valcea);
        graph.addEdge(Sibiu, Arges);
        graph.addEdge(Valcea, Arges);
        graph.addEdge(Teleorman, Arges);
        graph.addEdge(Teleorman, Dambovita);
        graph.addEdge(Teleorman, Giurgiu);
        graph.addEdge(Arges, Brasov);
        graph.addEdge(Arges, Dambovita);
        graph.addEdge(Giurgiu, Dambovita);
        graph.addEdge(Giurgiu, Bucuresti);
        graph.addEdge(Giurgiu, Calarasi);
        graph.addEdge(Bucuresti, Calarasi);
        graph.addEdge(Bucuresti, Dambovita);
        graph.addEdge(Bucuresti, Prahova);
        graph.addEdge(Bucuresti, Ialomita);
        graph.addEdge(Prahova, Dambovita);
        graph.addEdge(Prahova, Brasov);
        graph.addEdge(Prahova, Buzau);
        graph.addEdge(Prahova, Ialomita);
        graph.addEdge(Brasov, Mures);
        graph.addEdge(Brasov, Harghita);
        graph.addEdge(Brasov, Covasna);
        graph.addEdge(Brasov, Buzau);
        graph.addEdge(Brasov, Dambovita);
        graph.addEdge(Harghita, Suceava);
        graph.addEdge(Harghita, Covasna);
        graph.addEdge(Harghita, Neamt);
        graph.addEdge(Harghita, Bacau);
        graph.addEdge(Suceava, Neamt);
        graph.addEdge(Suceava, Botosani);
        graph.addEdge(Suceava, Iasi);
        graph.addEdge(Neamt, Bacau);
        graph.addEdge(Neamt, Iasi);
        graph.addEdge(Neamt, Vaslui);
        graph.addEdge(Bacau, Covasna);
        graph.addEdge(Bacau, Vrancea);
        graph.addEdge(Bacau, Vaslui);
        graph.addEdge(Vrancea, Covasna);
        graph.addEdge(Vrancea, Vaslui);
        graph.addEdge(Vrancea, Galati);
        graph.addEdge(Vrancea, Buzau);
        graph.addEdge(Vrancea, Braila);
        graph.addEdge(Buzau, Covasna);
        graph.addEdge(Buzau, Braila);
        graph.addEdge(Buzau, Ialomita);
        graph.addEdge(Ialomita, Calarasi);
        graph.addEdge(Ialomita, Braila);
        graph.addEdge(Ialomita, Constanta);
        graph.addEdge(Calarasi, Constanta);
        graph.addEdge(Constanta, Braila);
        graph.addEdge(Constanta, Tulcea);
        graph.addEdge(Tulcea, Braila);
        graph.addEdge(Tulcea, Galati);
        graph.addEdge(Galati, Braila);
        graph.addEdge(Galati, Vaslui);
        graph.addEdge(Vaslui, Iasi);
        graph.addEdge(Iasi, Botosani);

        DomainCreator.createDomainFourColors(graph.getNodesDFS());
    }
}
