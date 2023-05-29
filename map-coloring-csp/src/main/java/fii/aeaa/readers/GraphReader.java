package fii.aeaa.readers;

import fii.aeaa.models.Graph;
import fii.aeaa.models.Node;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static fii.aeaa.utils.GraphIOConst.*;

public class GraphReader {

    private final Logger LOGGER = LoggerFactory.getLogger(GraphReader.class);

    public GraphReader(){
        loadLoggerProp();
    }

    private void loadLoggerProp() {
        PropertyConfigurator.configure("src/log4j.properties");
    }

    public Graph readFromFile(String filePath) {
        Graph graph = new Graph();
        File file = new File(filePath);

        if (!file.exists()) {
            LOGGER.error("File \"" + filePath + "\" does not exist");
            return graph;
        }

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            Set<String> lines = bufferedReader
                    .lines()
                    .collect(Collectors.toCollection(LinkedHashSet::new));

            checkFormat(lines);

            boolean readEdges = false;

            for(String line : lines){
                line = line.trim();
                if(line.startsWith(COMMENT_SYMBOL)){
                    continue;
                }

                if (line.equals(SEPARATOR_BETWEEN_NODES_AND_EDGES)) {
                    readEdges = true;
                    continue;
                }

                if (readEdges) {
                    processEdgeLine(line, graph);
                } else {
                    processNodeLine(line, graph);
                }
            }

        } catch (IOException e) {
            LOGGER.error("Error reading file: " + e.getMessage());
            return graph;
        }

        return graph;
    }

    private void checkFormat(Set<String> lines) {
        // TODO
    }

    private void processEdgeLine(String line, Graph graph) {
        String fromNode = line.substring(0, line.indexOf(START_ADJACENCY_NODES_SEPARATOR));
        String[] toNodes = line.substring(line.indexOf(START_ADJACENCY_NODES_SEPARATOR) + 1).split(ENUMERATION_SEPARATOR);

        for (String toNode : toNodes) {
            if (toNode.trim().length() > 0) {
                Node from = graph.getNodeByName(fromNode);
                Node to = graph.getNodeByName(toNode);
                graph.addEdge(from, to);
            }
        }
    }

    private void processNodeLine(String line, Graph graph) {
        String[] nodes = line.split(ENUMERATION_SEPARATOR);

        for (String node : nodes) {
            Node newNode = new Node(node);
            graph.addNode(newNode);
        }
    }

}
