package pl.kurs.zadanie.app;

import pl.kurs.zadanie.exceptions.NoShapeException;
import pl.kurs.zadanie.service.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws IOException, NoShapeException {

        System.out.println("Zaliczłem test.... CHYBA");

//        ShapeFactory shapeFactory = new ShapeFactory();
//        ShapeService service = new ShapeService();
//
//        Square sq1 = shapeFactory.createSquare(10);
//        Square sq2 = shapeFactory.createSquare(10);
//        Rectangle rc1 = shapeFactory.createRectangle(10, 2);
//        Circle cr1 = shapeFactory.createCircle(50);
//
//        List<Shape> shapeList = new ArrayList<>();
//        shapeList.add(sq1);
//        shapeList.add(sq2);
//        shapeList.add(rc1);
//        shapeList.add(cr1);
//        shapeList.add(sq1);
//
//        System.out.println(service.maxArea(shapeList));
//        System.out.println(service.maxPerimeter(shapeList, Square.class));
//        service.writeJson(shapeList, "src/main/resources/shape.json");
//        service.readJsonFromFile("src/main/resources/shape.json");
//
//        List<Shape> shapeList1 = new ArrayList<>();
//        shapeList1.add(new Square(10)); //0
//
//        service.writeJson(shapeList1, "src/main/resources/shapeList1.json");
    }
}
