package fii.aeaa.models;

import java.util.LinkedHashSet;
import java.util.Set;

public class Node {
    private final String name;
    private Set<Color> domain;

    public Node(String name, Set<Color> domain) {
        this.name = name;
        this.domain = domain;
    }

    public Node(String name) {
        this.name = name;
        this.domain = new LinkedHashSet<>();
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName(){
        return name;
    }

    public void removeFromDomain(Color color){
        domain.remove(color);
    }

    public Set<Color> getDomain(){
        return new LinkedHashSet<>(domain);
    }

    public void setDomain(Set<Color> domain){
        this.domain = domain;
    }

    public void addToDomain(Color color){
        this.domain.add(color);
    }
}
