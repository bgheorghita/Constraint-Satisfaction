package fii.aeaa.instances;

import fii.aeaa.constraints.managers.GraphConstraintManager;
import fii.aeaa.models.Color;
import fii.aeaa.models.Graph;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class TestInstance {

    protected Graph graph;
    protected GraphConstraintManager graphConstraintManager;

    protected TestInstance(){
        createGraph();
        createConstraintManager();
    }

    public Graph getGraph(){
        return graph;
    }
    public GraphConstraintManager getGraphConstraintManager(){
        return graphConstraintManager;
    }

    protected abstract void createGraph();
    protected abstract void createConstraintManager();

    protected Set<Color> createDomainFourColors(){
        return new LinkedHashSet<>(Arrays.asList(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW));
    }
}
