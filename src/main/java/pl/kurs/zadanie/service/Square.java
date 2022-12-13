package pl.kurs.zadanie.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Square implements Shape {

    @JsonProperty("type")
    private String square;
    private double side;

    public Square(double side) {
        this.square = "square";
        this.side = side;
    }

    public String getSquare() {
        return square;
    }

    public void createSquare() {
    }

    public double getSide() {
        return side;
    }

    @JsonIgnore
    @Override
    public double getArea() {
        return side * side;
    }
    @JsonIgnore
    @Override
    public double getPerimeter() {
        return side * 4;
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                '}';
    }
}