package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void canCalculateTriangleArea(){
        var t = new Triangle(3.0, 4.0, 5.0);
        var result = t.area();
        Assertions.assertEquals(6.0, result);
    }

    @Test
    void canCalculateTrianglePerimeter(){
        var t = new Triangle(3.0, 4.0, 5.0);
        var result = t.perimeter();
        Assertions.assertEquals(12.0, result);
    }

}
