package task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleInequalityTest {

    @Test
    public void equilateralTriangle() {
        assertTrue(TriangleInequality.isTriangleExists(12.7, 12.7, 12.7));
    }

    @Test
    public void allZeroSides() {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleInequality.isTriangleExists(0.0, 0.0, 0.0);
        });
    }

    @Test
    public void oneZeroSide() {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleInequality.isTriangleExists(0, 12.0, 34.0);
        });
    }

    @Test
    public void oneNegativeSide() {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleInequality.isTriangleExists(17.0, -23.1, 34.0);
        });
    }

    @Test
    public void realScaleneTriangle() {
        assertTrue(TriangleInequality.isTriangleExists(12.2, 7.4, 14.5));
    }

    @Test
    public void realIsoscelesTriangle() {
        assertTrue(TriangleInequality.isTriangleExists(12.5, 12.5, 14.2));
    }

    @Test
    public void sumOfTwoSidesEqualsThird() {
        assertFalse(TriangleInequality.isTriangleExists(12.5, 12.5, 25.0));
    }

    @Test
    public void sumOfTwoSidesGreaterThird() {
        assertFalse(TriangleInequality.isTriangleExists(12.6, 99.3, 24.7));
    }

    @Test
    public void sumOfTwoSidesLessThird() {
        assertFalse(TriangleInequality.isTriangleExists(12.1, 11.5, 24.9));
    }

    @Test
    public void oneOfTheSideIsMaxDouble() {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleInequality.isTriangleExists(Double.MAX_VALUE, 5.0, 12.0);
        });
    }

    @Test
    public void allSidesIsMaxDouble() {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleInequality.isTriangleExists(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        });
    }
}
