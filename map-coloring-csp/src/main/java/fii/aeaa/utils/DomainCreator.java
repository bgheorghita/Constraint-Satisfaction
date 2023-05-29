package fii.aeaa.utils;

import fii.aeaa.models.Color;
import fii.aeaa.models.Node;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class DomainCreator {
    public static void createDomainFourColors(Set<Node> nodes){
        for(Node node : nodes){
            node.setDomain(new LinkedHashSet<>(Arrays.asList(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW)));
        }
    }
}
