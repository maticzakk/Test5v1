package pl.kurs.zadanie.service;

import org.junit.Before;
import org.junit.Test;
import pl.kurs.zadanie.exceptions.NoShapeException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class ShapeServiceTest {

    ShapeService service;
    List<Shape> shapeList;
    List<Shape> emptyList;
    private String filePath = "test.json";

    @Before
    public void init() {
        service = new ShapeService();
        shapeList = Arrays.asList(
                new Square(10), //0
                new Square(20), //1
                new Square(30), //2
                new Square(40), //3
                new Square(50), //4
                new Square(60), //5
                new Square(70) //6
        );
    }

    @Test
    public void shouldReturnMaxAreaOfObjectList() throws NoShapeException {
        Shape maxAreaShape = service.maxArea(shapeList);

//        assertTrue(maxAreaShape == shapeList.get(0));
//        Assertions.assertThat(maxAreaShape)
//                .isSameAs(shapeList.get(0));
        assertEquals(maxAreaShape, shapeList.get(6));
    }

    @Test(expected = NoShapeException.class)
    public void shouldThrowNoShapeExceptionWhenListIsEmpty() throws NoShapeException {
        Shape maxAreaShape = service.maxArea(emptyList);
        Throwable exception = assertThrows(NoShapeException.class, () -> maxAreaShape.getArea());
        assertEquals("Brak figury", exception.getMessage());
    }

    @Test
    public void shouldReturnMaxPerimeterOfObjectList() throws NoShapeException {
        Shape maxPerimeterShape = service.maxPerimeter(shapeList, Square.class);
        //sprawdzamy czy figura o najwiekszym obwodzie znajduje sie na indeksie 6
        assertEquals(maxPerimeterShape, shapeList.get(6));
        //sprawdzamy czy figura jest danego typu
        assertEquals(maxPerimeterShape.getClass(), Square.class);

    }
    @Test(expected = NoShapeException.class)
    public void shouldThrowNoShapeExceptionWhenListOfPerimeterIsEmpty() throws NoShapeException {
        Shape maxPerimeterShape = service.maxPerimeter(emptyList, Square.class);
        Throwable exception = assertThrows(NoShapeException.class, maxPerimeterShape::getPerimeter);
        assertEquals("Brak figury", exception.getMessage());
    }


    @Test(expected = NoShapeException.class)
    public void shouldThrowIOExceptionMessage() throws IOException, NoShapeException {

        List<Shape> shapes = new ArrayList<>();
        service.writeJson(shapes, filePath);
    }

    @Test
    public void checkMethodWhichWriteCorrectlyJson() throws IOException, NoShapeException {
        boolean b = service.writeJson(shapeList, filePath);

        File file = new File(filePath);
        //sprawdzamy czy plik istnieje
        assertTrue(file.exists());
        assertTrue(String.valueOf(b), true);
    }

    @Test
    public void shouldGetFiguresFromJsonFile() throws IOException {
        List<Shape> shapes = service.readJsonFromFile(filePath);
        //sprawdzamy czy zwrócona lista nie jest pusta
        assertNotNull(shapes);
        //sprawdzamy czy lista zawiera odpowiednią liczbę figur
        assertEquals(7, shapeList.size());
    }

    @Test(expected = NoShapeException.class)
    public void whenTheListIsNullThrowNoShapeException() throws IOException, NoShapeException {
        service.writeJson(null, filePath);
    }
}