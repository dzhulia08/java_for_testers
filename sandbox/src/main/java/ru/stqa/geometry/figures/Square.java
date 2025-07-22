package ru.stqa.geometry.figures;

public class Square {

    private double side; // описание структуры объекта перечисляет его свойства

    public Square(double side) { // констуктор присваивает значения параметров в эти свойства
        this.side = side;
    }

    public static void printSquareArea(Square s){
        String text = String.format("Площадь квадрата со стороной %f = %f", s.side, s.area());
        System.out.println(text);
    }

//    public static double area(double a) {
//        return a * a;
//    }
//
//    public static double perimeter(double a) {
//        return 4 * a;
//    }

    public Object area() {
        return this.side * this.side;
    }

    public double perimeter() {
        return this.side * 4;
    }
}
