package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangleTests {

    @Test
    void cannotCreateRectangleWithNegativeSide(){
        try{
            new Rectangle(-5.0, 3.0);
            Assertions.fail();
        } catch(IllegalArgumentException exception){

        }
    }

    @Test
    void testEquality(){
        var s1 = new Rectangle(5.0, 4.0);
        var s2 = new Rectangle(5.0, 4.0);
        Assertions.assertEquals(s1, s2);
    }

    @Test
    void testEquality2(){
        var s1 = new Rectangle(5.0, 4.0);
        var s2 = new Rectangle(4.0, 5.0);
        Assertions.assertEquals(s1, s2);
    }

}
