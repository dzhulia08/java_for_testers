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

    @Test
    void cannotCreateTriangleWithNegativeSide(){
        try{
            new Triangle(-5.0, 3.0, 4.0);
            Assertions.fail();
        } catch(IllegalArgumentException exception){
            // ОК
        }

        try{
            new Triangle(5.0, -3.0, 4.0);
            Assertions.fail();
        } catch(IllegalArgumentException exception){
            // ОК
        }

        try{
            new Triangle(5.0, 3.0, -4.0);
            Assertions.fail();
        } catch(IllegalArgumentException exception){
            // ОК
        }
    }

    @Test
    void cannotCreateTriangleWithIncorrectSumOfTwoSide(){
        try{
            new Triangle(1.0, 2.0, 4.0);
            Assertions.fail();
        } catch(IllegalArgumentException exception){
            // ОК
        }

        try{
            new Triangle(1.0, 4.0, 2.0);
            Assertions.fail();
        } catch(IllegalArgumentException exception){
            // ОК
        }

        try{
            new Triangle(4.0, 1.0, 2.0);
            Assertions.fail();
        } catch(IllegalArgumentException exception){
            // ОК
        }
    }

    @Test
    void testEquality(){
        var s1 = new Triangle(3.0, 4.0, 5.0);
        var s2 = new Triangle(3.0, 4.0, 5.0);
        Assertions.assertEquals(s1, s2);
    }

    @Test
    void testEquality2(){
        var s1 = new Triangle(3.0, 4.0, 5.0);
        var s2 = new Triangle(3.0, 5.0, 4.0);
        Assertions.assertEquals(s1, s2);
    }

    @Test
    void testEquality3(){
        var s1 = new Triangle(3.0, 4.0, 5.0);
        var s2 = new Triangle(4.0, 3.0, 5.0);
        Assertions.assertEquals(s1, s2);
    }

    @Test
    void testEquality4(){
        var s1 = new Triangle(3.0, 4.0, 5.0);
        var s2 = new Triangle(4.0, 5.0, 3.0);
        Assertions.assertEquals(s1, s2);
    }

    @Test
    void testEquality5(){
        var s1 = new Triangle(3.0, 4.0, 5.0);
        var s2 = new Triangle(5.0, 3.0, 4.0);
        Assertions.assertEquals(s1, s2);
    }

    @Test
    void testEquality6(){
        var s1 = new Triangle(3.0, 4.0, 5.0);
        var s2 = new Triangle(5.0, 4.0, 3.0);
        Assertions.assertEquals(s1, s2);
    }

}
