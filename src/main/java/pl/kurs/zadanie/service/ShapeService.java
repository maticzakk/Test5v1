package pl.kurs.zadanie.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
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

    public void writeJson(List<Shape> shapeList, String filename) throws IOException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(filename), shapeList);
        } catch (IOException e) {
            System.out.println("Zły plik");
        }
    }
    public List<Shape> readJsonFromFile(String filename) throws IOException {
        File file = new File(filename);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(file, ArrayList.class);
    }
}
