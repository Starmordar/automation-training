package task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleInequalityTest {

    @Test
    public void equilateralTriangle() {
        assertEquals(true, TriangleInequality.isTriangleExists(12.7, 12.7, 12.7));
    }

    @Test
    public void allZeroSides() {
        assertEquals(false, TriangleInequality.isTriangleExists(0.0, 0.0, 0.0));
    }

    @Test
    public void oneZeroSide() {
        assertEquals(false, TriangleInequality.isTriangleExists(0, 12.0, 34.0));
    }

    @Test
    public void oneNegativeSide() {
        assertEquals(false, TriangleInequality.isTriangleExists(17.0, -23.1, 34.0));
    }

    @Test
    public void realScaleneTriangle() {
        assertEquals(true, TriangleInequality.isTriangleExists(12.2, 7.4, 14.5));
    }

    @Test
    public void realIsoscelesTriangle() {
        assertEquals(true, TriangleInequality.isTriangleExists(12.5, 12.5, 14.2));
    }

    @Test
    public void sumOfTwoSidesEqualsThird() {
        assertEquals(false, TriangleInequality.isTriangleExists(12.5, 12.5, 25.0));
    }

    @Test
    public void sumOfTwoSidesGreaterThird() {
        assertEquals(false, TriangleInequality.isTriangleExists(12.6, 99.3, 24.7));
    }

    @Test
    public void sumOfTwoSidesLessThird() {
        assertEquals(false, TriangleInequality.isTriangleExists(12.1, 11.5, 24.9));
    }

    @Test
    public void oneOfTheSideIsMaxDouble() {
        assertEquals(false, TriangleInequality.isTriangleExists(Double.MAX_VALUE , 5.0, 12.0));
    }

    @Test
    public void allSidesIsMaxDouble() {
        assertEquals(true, TriangleInequality.isTriangleExists(Double.MAX_VALUE , Double.MAX_VALUE, Double.MAX_VALUE));
    }
}
