package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;

import java.util.List;
import java.util.function.Consumer;

public class Geometry {
    public static void main(String[] args) {
        var squares = List.of(new Square(7.0), new Square(5.0), new Square(3.0));
//        for (Square square : squares) {
//            Square.printSquareArea(square);
//        }
        squares.forEach(Square::printSquareArea);

//        Rectangle.printRectangleArea(7.0, 3.0);
//        Rectangle.printRectangleArea(5.0, 6.0);
//        Rectangle.printRectangleArea(8.0, 9.);
    }

}
