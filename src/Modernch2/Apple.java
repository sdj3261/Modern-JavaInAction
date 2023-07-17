package Modernch2;


public class Apple {
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private String color;
    private Integer weight;

    public Integer getWeight() {
        return weight;
    }

    public static boolean isRedAndHeavy(Apple apple) {
        return "RED".equals(apple.getColor()) && apple.getWeight() > 100;
    }
}
