package pl.kurs.zadanie.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Circle implements Shape {

    final double PI = 3.14;
    private int r;
    @JsonProperty("type")
    private String circle;

    public Circle(int radius) {
        this.r = radius;
        this.circle = "circle";
    }

    public String getCircle() {
        return circle;
    }

    public void createCircle(){
    }
    @JsonIgnore
    @Override
    public double getArea() {
        return PI * r * r;
    }
    @JsonIgnore
    @Override
    public double getPerimeter() {
        return PI * 2 * r;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "r=" + r +
                '}';
    }
}
