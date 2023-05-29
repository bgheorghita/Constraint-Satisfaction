package fii.aeaa.writers;

import fii.aeaa.models.Graph;
import fii.aeaa.models.Node;
import fii.aeaa.readers.GraphReader;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import static fii.aeaa.utils.GraphIOConst.*;

public class GraphWriter {
    private final Logger LOGGER = LoggerFactory.getLogger(GraphReader.class);

    public GraphWriter(){
        loadLoggerProp();
    }

    private void loadLoggerProp() {
        PropertyConfigurator.configure("src/log4j.properties");
    }

    public void writeToFile(Graph graph, String filePath){
        StringBuilder sb = new StringBuilder();

        addNodesToStringBuilderWithFormat(graph.getNodesDFS(), sb);
        addSeparatorBetweenNodesAndEdgesToStringBuilder(sb);
        addAdjacencyNodesToStringBuilderWithFormat(graph.getAdjacencyList(), sb);

        try (FileWriter fileWriter = new FileWriter(filePath);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.write(sb.toString());
            LOGGER.info("Content has been written to the file.");
        } catch (IOException e) {
            LOGGER.error("Content could not be written: " + e.getMessage());
        }
    }

    private void addSeparatorBetweenNodesAndEdgesToStringBuilder(StringBuilder sb) {
        sb.append("\n")
            .append(SEPARATOR_BETWEEN_NODES_AND_EDGES)
            .append("\n");
    }

    private void addAdjacencyNodesToStringBuilderWithFormat(Map<Node, Set<Node>> adjacencyList, StringBuilder sb) {
        for(Map.Entry<Node, Set<Node>> entry : adjacencyList.entrySet()){
            Node node = entry.getKey();
            Set<Node> adjacencyNodes = entry.getValue();

            String aux = String.join(ENUMERATION_SEPARATOR, adjacencyNodes.stream()
                    .map(Node::getName)
                    .toArray(String[]::new));

            sb.append(node.getName())
                    .append(START_ADJACENCY_NODES_SEPARATOR)
                    .append(aux)
                    .append("\n");

            // deletes last ',' character
            if(aux.length() > 0){
                sb.deleteCharAt(sb.length() - 2);
            }
        }
    }

    private void addNodesToStringBuilderWithFormat(Set<Node> nodes, StringBuilder sb) {
        int rowLength = WRITE_NODES_PER_LINE;
        for(Node node : nodes) {
            sb.append(node).append(ENUMERATION_SEPARATOR);
            if(rowLength == 0){
                sb.deleteCharAt(sb.length() - 1);
                sb.append("\n");
                rowLength = WRITE_NODES_PER_LINE;
            }
            rowLength--;
        }

        // deletes last new line
        sb.deleteCharAt(sb.length() - 1);
    }

}
