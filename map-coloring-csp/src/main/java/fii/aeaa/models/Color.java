package fii.aeaa.models;

public enum Color {
    RED("red"),
    GREEN("green"),
    BLUE("blue"),
    YELLOW("yellow");

    private final String color;
    Color(String color){
        this.color = color;
    }

    @Override
    public String toString(){
        return color;
    }

}
