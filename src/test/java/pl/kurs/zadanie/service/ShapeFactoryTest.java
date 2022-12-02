package pl.kurs.zadanie.service;

import junit.framework.TestCase;
import org.junit.Test;

public class ShapeFactoryTest extends TestCase {
    ShapeFactory shapeFactory = new ShapeFactory();

    @Test
    public void testCreateRectangle() {
        Shape fromFactory = shapeFactory.createRectangle(10, 5);
        assertEquals(fromFactory.getClass().getName(), Rectangle.class.getName());
    }

    public void testCreateSquare() {
        Shape fromFactory = shapeFactory.createSquare(10);
        assertEquals(fromFactory.getClass().getName(), Square.class.getName());
    }

    public void testCreateCircle() {
        Shape fromFactory = shapeFactory.createCircle(10);
        assertEquals(fromFactory.getClass().getName(), Circle.class.getName());
    }
}