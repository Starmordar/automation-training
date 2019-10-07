package task1;

public class TriangleInequality {

    public static boolean isTriangleExists(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) return false;
        if ((a + b) > c && (a + c) > b && (b + c) > a) return true;
        return false;
    }

}
