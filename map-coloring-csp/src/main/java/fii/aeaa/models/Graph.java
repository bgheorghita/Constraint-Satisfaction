package fii.aeaa.models;

import java.util.*;

public class Graph {
    private final Map<Node, Set<Node>> adjacencyList;

    public Graph(){
        adjacencyList = new HashMap<>();
    }

    public void addNode(Node node){
        Set<Node> currentList = new HashSet<>();
        adjacencyList.put(node, currentList);
    }

    public void addEdge(Node src, Node dst){
        Set<Node> srcList = adjacencyList.get(src);
        Set<Node> dstList = adjacencyList.get(dst);
        srcList.add(dst);
        dstList.add(src);
    }

    public void print(){
        for (Map.Entry<Node, Set<Node>> entry : adjacencyList.entrySet()) {
            Node node = entry.getKey();
            Set<Node> neighbors = entry.getValue();
            System.out.println(node + " -> " + neighbors);
        }
    }

    public Set<Node> getNodesDFS(){
        Set<Node> visited = new LinkedHashSet<>();
        for(Node node : adjacencyList.keySet()){
            if(!visited.contains(node)){
                dfs(node, visited);
            }
        }
        return visited;
    }

    private void dfs(Node root, Set<Node> visited){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (!visited.contains(node)) {
                visited.add(node);
                for (Node neighborNode : this.adjacencyList.get(node)) {
                    stack.push(neighborNode);
                }
            }
        }
    }

    public Set<Node> getNodesBFS(Node root) {
        Set<Node> visited = new LinkedHashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            for (Node neighbor : this.adjacencyList.get(node)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return visited;
    }

    public Set<Node> getNodeNeighbors(String nodeName){
        for (Map.Entry<Node, Set<Node>> entry : adjacencyList.entrySet()) {
            Node node = entry.getKey();
            if(node.getName().equals(nodeName)){
                return entry.getValue();
            }
        }
        return new HashSet<>();
    }

    public Set<Node> getNodeNeighbors(Node node){
        return adjacencyList.get(node);
    }
}