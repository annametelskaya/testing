package by.bsu.metelskaya;


public class Triangle {
    private double a;
    private double b;
    private double c;


    Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    boolean getTriangle() {
        if (!(a > 0 || b > 0 || c > 0)) {
            return false;
        }
        return a + b > c && a + c > b && b + c > a;
    }
}