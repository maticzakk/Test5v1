package pl.kurs.zadanie.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Rectangle implements Shape {
    @JsonProperty("type")
    public String rectangle;
    private double height;
    private double length;

    public Rectangle(double height, double length) {
        this.rectangle = "rectangle";
        this.height = height;
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    public void createRectangle() {
    }
    @JsonIgnore
    @Override
    public double getArea() {
        return height * length;
    }
    @JsonIgnore
    @Override
    public double getPerimeter() {
        return (height * 2) + (length * 2);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "height=" + height +
                ", length=" + length +
                '}';
    }
}
