package pl.kurs.zadanie.service;

public class ShapeFactory implements IShapeFactory{

    private IShapeFactory shapeFactory;

    public ShapeFactory(IShapeFactory shapeFactory) {
        this.shapeFactory = shapeFactory;
    }

    public ShapeFactory() {
    }

    @Override
    public Rectangle createRectangle(int width, int height) {
        return new Rectangle(width, height);
    }

    @Override
    public Square createSquare(int length) {
        return new Square(length);
    }

    @Override
    public Circle createCircle(int r) {
        return new Circle(r);
    }

}
