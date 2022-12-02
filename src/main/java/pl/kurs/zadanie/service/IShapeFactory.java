package pl.kurs.zadanie.service;

public interface IShapeFactory {

    Shape createRectangle(int width, int height);
    Shape createSquare(int length);
    Shape createCircle(int r);
}
