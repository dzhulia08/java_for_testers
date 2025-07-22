package ru.stqa.geometry.figures;

public record Triangle (double a, double b, double c) {
    public Object area() {
        double p = (this.a + this.b + this.c) / 2;
        double s = Math.sqrt(p * (p - this.a) * (p - this.b) * (p - this.c));
        return s;
    }

    public double perimeter() {
        return this.a + this.b + this.c;
    }
}
