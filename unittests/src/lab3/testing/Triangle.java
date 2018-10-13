package lab3.testing;

public class Triangle {

    public static boolean getTriangle(double x, double y, double z) {
        if (!(x > 0 || y > 0 || z > 0)) {
            return false;
        }
        return x + y > z && x + z > y && y + z > x;
    }
}