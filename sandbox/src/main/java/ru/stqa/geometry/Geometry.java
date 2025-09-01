package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Geometry {
    public static void main(String[] args) {
        Supplier<Square> randomSquare = () -> new Square(new Random().nextDouble(100.0));
        var squares = Stream.generate(randomSquare).limit(5);

//        Consumer<Square> print = square -> {
//            Square.printSquareArea(square);
//            Square.printPerimeter(square);
//        };
        squares.peek(Square::printSquareArea).forEach(Square::printPerimeter);

//        Rectangle.printRectangleArea(7.0, 3.0);
//        Rectangle.printRectangleArea(5.0, 6.0);
//        Rectangle.printRectangleArea(8.0, 9.);
    }

}
