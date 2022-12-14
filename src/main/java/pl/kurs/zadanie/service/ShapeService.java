package pl.kurs.zadanie.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.kurs.zadanie.exceptions.NoShapeException;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ShapeService {

    public Shape maxArea(List<Shape> ShapeList) throws NoShapeException {
        return Optional.ofNullable(ShapeList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparingDouble(Shape::getArea))
                .orElseThrow(() -> new NoShapeException("Brak figury"));
    }

    public Shape maxPerimeter(List<Shape> shapeList, Class clazz) throws NoShapeException {
        return Optional.ofNullable(shapeList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> x.getClass() == clazz)
                .max(Comparator.comparingDouble(Shape::getPerimeter))
                .orElseThrow(() -> new NoShapeException("Brak figury"));
    }

    public boolean writeJson(List<Shape> shapeList, String filename) throws NoShapeException, IOException { //boolean
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.writeValue(new File(filename), shapeList);
//        return true;
        if (shapeList == null || shapeList.isEmpty()) {
            throw new NoShapeException("Brak listy figur");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(filename), shapeList);
        return true;
    }
    public List<Shape> readJsonFromFile(String filename) throws IOException {
        File file = new File(filename);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(file, ArrayList.class);
    }
}
