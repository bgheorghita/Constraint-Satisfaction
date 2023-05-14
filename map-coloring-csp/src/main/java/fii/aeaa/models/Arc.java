package fii.aeaa.models;

public class Arc {
    private final Node from;
    private final Node to;

    public Arc(Node from, Node to) {
        this.from = from;
        this.to = to;
    }

    public Node getFrom() {
        return from;
    }

    public Node getTo() {
        return to;
    }
}
