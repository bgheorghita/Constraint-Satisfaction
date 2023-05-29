package fii.aeaa.instances;

import fii.aeaa.constraints.managers.GraphConstraintManager;
import fii.aeaa.models.Graph;


public abstract class TestInstance {

    protected Graph graph;
    protected GraphConstraintManager graphConstraintManager;

    protected TestInstance(){
        initGraph();
        initConstraintManager();
    }

    public Graph getGraph(){
        return graph;
    }
    public GraphConstraintManager getGraphConstraintManager(){
        return graphConstraintManager;
    }

    protected abstract void initGraph();
    protected abstract void initConstraintManager();
}
