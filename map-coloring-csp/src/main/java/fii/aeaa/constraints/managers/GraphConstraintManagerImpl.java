package fii.aeaa.constraints.managers;

import fii.aeaa.constraints.Constraint;
import fii.aeaa.constraints.ConstraintType;
import fii.aeaa.constraints.binary.core.BinaryConstraint;
import fii.aeaa.constraints.global.GlobalConstraint;
import fii.aeaa.constraints.unary.core.UnaryConstraint;
import fii.aeaa.models.Color;
import fii.aeaa.models.Graph;
import fii.aeaa.models.Node;

import java.util.*;

public class GraphConstraintManagerImpl implements GraphConstraintManager {

    protected Graph graph;
    protected Set<UnaryConstraint> unaryConstraints;
    protected Set<BinaryConstraint> binaryConstraints;
    protected Set<GlobalConstraint> globalConstraints;

    public GraphConstraintManagerImpl(){}

    private GraphConstraintManagerImpl(Graph graph, Set<UnaryConstraint> unaryConstraints,
                                       Set<BinaryConstraint> binaryConstraints,
                                       Set<GlobalConstraint> globalConstraints) {
        this.graph = graph;
        this.unaryConstraints = unaryConstraints;
        this.binaryConstraints = binaryConstraints;
        this.globalConstraints = globalConstraints;
    }

    public GraphConstraintManagerImpl withUnaryConstraints(Set<UnaryConstraint> unaryConstraints) {
        this.unaryConstraints = unaryConstraints;
        return this;
    }

    public GraphConstraintManagerImpl withBinaryConstraints(Set<BinaryConstraint> binaryConstraints) {
        this.binaryConstraints = binaryConstraints;
        return this;
    }

    public GraphConstraintManagerImpl withGlobalConstraints(Set<GlobalConstraint> globalConstraints) {
        this.globalConstraints = globalConstraints;
        return this;
    }

    public GraphConstraintManagerImpl build() {
        return new GraphConstraintManagerImpl(graph, unaryConstraints, binaryConstraints, globalConstraints);
    }

    private boolean globalConstraintsNotSatisfied(Node currentNode, Color currentColor, Map<Node, Color> coloredNodesResult) {
        if(globalConstraints == null) {
            return false;
        }

        for (GlobalConstraint globalConstraint : globalConstraints){
            List<Color> colors = new ArrayList<>();
            if(globalConstraint.isSubjectTo(currentNode)){
                colors.add(currentColor);
            } else {
                continue;
            }
            for(Map.Entry<Node, Color> entry : coloredNodesResult.entrySet()){
                Node node = entry.getKey();
                Color color = entry.getValue();

                if(globalConstraint.isSubjectTo(node)){
                    colors.add(color);
                }
            }
            if(!globalConstraint.isConsistent(colors)){
                return true;
            }
        }

        return false;
    }

    private boolean binaryConstraintsSatisfied(Node currentNode, Color currentColor, Map<Node, Color> coloredNodesResult) {
        if(binaryConstraints == null){
            return true;
        }

        for(BinaryConstraint binaryConstraint : binaryConstraints){
            for(Map.Entry<Node, Color> entry : coloredNodesResult.entrySet()){
                Node node = entry.getKey();
                Color nodeColor = entry.getValue();
                if(binaryConstraint.isSubjectTo(node) && binaryConstraint.isSubjectTo(currentNode)){
                    if(!binaryConstraint.isConsistent(List.of(nodeColor, currentColor))){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean unaryConstraintsSatisfied(Node node, Color color) {
        if(unaryConstraints == null){
            return true;
        }

        for(UnaryConstraint unaryConstraint : unaryConstraints){
            if(unaryConstraint.isSubjectTo(node) && !unaryConstraint.isConsistent(List.of(color))){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isConsistent(Map<Node, Color> coloredNodesResult, Node currentNode, Color currentColor) {
        boolean unaryConstraintsSatisfied = unaryConstraintsSatisfied(currentNode, currentColor);
        boolean binaryConstrainsSatisfied = binaryConstraintsSatisfied(currentNode, currentColor, coloredNodesResult);
        boolean globalConstraintsSatisfied = !globalConstraintsNotSatisfied(currentNode, currentColor, coloredNodesResult);
        return unaryConstraintsSatisfied && binaryConstrainsSatisfied && globalConstraintsSatisfied;
    }

    @Override
    public Set<Constraint> getConstraints(ConstraintType constraintType) {
        switch (constraintType){
            case UNARY_CONSTRAINT -> {
                return new HashSet<>(unaryConstraints);
            }
            case BINARY_CONSTRAINT -> {
                return new HashSet<>(binaryConstraints);
            }
            case GLOBAL_CONSTRAINT -> {
                return new HashSet<>(globalConstraints);
            }
        }
        return new HashSet<>();
    }
}
