package task1;

public class TriangleInequality {
    private static final String ERROR_LENGTH_SIDE = "Triangle side can't be less then 0";
    private static final String ERROR_MAX_LENGTH_SIDE = "Triangle side can't be max double value";

    public static boolean isTriangleExists(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) throw new IllegalArgumentException(ERROR_LENGTH_SIDE);

        if (a == Double.MAX_VALUE || b == Double.MAX_VALUE || c == Double.MAX_VALUE)
            throw new IllegalArgumentException(ERROR_MAX_LENGTH_SIDE);

        return (a + b) > c && (a + c) > b && (b + c) > a;
    }

}
