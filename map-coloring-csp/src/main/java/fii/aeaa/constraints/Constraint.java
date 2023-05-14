package fii.aeaa.constraints;

import fii.aeaa.models.Color;
import fii.aeaa.models.Node;

import java.util.List;

public interface Constraint {
    boolean isSubjectTo(Node node);
    boolean isConsistent(List<Color> colors);
}
