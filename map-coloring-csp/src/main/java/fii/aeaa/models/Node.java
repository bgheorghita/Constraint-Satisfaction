package fii.aeaa.models;

public class Node {
    private final String name;

    public Node(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName(){
        return name;
    }
}
