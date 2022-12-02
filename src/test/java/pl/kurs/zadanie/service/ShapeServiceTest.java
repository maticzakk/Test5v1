package pl.kurs.zadanie.service;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.kurs.zadanie.exceptions.NoShapeException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ShapeServiceTest {

    @Rule
     public TemporaryFolder folder = new TemporaryFolder();

    ShapeService service;
    @Mock ShapeFactory shapeFactory;
    List<Shape> shapeList;
    List<Shape> emptyList;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
        service = new ShapeService();

        shapeList = new ArrayList<>();
        shapeList.add(new Square(10)); //0
        shapeList.add(new Square(20)); //1
        shapeList.add(new Square(30)); //2
        shapeList.add(new Square(40)); //3
        shapeList.add(new Square(50)); //4
        shapeList.add(new Square(60)); //5
        shapeList.add(new Square(70)); //6

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
        assertEquals(maxPerimeterShape, shapeList.get(6));
    }
    @Test(expected = NoShapeException.class)
    public void shouldThrowNoShapeExceptionWhenListOfPerimeterIsEmpty() throws NoShapeException {
        Shape maxPerimeterShape = service.maxPerimeter(emptyList, Square.class);
        Throwable exception = assertThrows(NoShapeException.class, () -> maxPerimeterShape.getPerimeter());
        assertEquals("Brak figury", exception.getMessage());
    }
}