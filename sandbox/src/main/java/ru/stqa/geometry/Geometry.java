package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;

public class Geometry {
    public static void main(String[] args) {
        Square.printSquareArea(7.0);
        Square.printSquareArea(5.);
        Square.printSquareArea(3.0);

        Rectangle.printRectangleArea(7.0, 3.0);
        Rectangle.printRectangleArea(5.0, 6.0);
        Rectangle.printRectangleArea(8.0, 9.);
    }

}
