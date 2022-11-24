package TriangleHW;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {

    @Test
    @DisplayName("Positive test")
    void positiveTest() throws IsNotATriangleException {
        Triangle triangle = new Triangle();
        assertEquals(6.0, triangle.getTriangleArea(3, 4 ,5));
    }

    @ParameterizedTest
    @CsvSource({"0, 4, 5", "10, 0, 30", "9, 8, 0"})
    @DisplayName("Test with ZERO length value")
    void negativeTest1(int a, int b, int c) {
        Triangle triangle = new Triangle();
        assertThrows(IsNotATriangleException.class, ()-> triangle.getTriangleArea(a, b ,c));
        Throwable exception = assertThrows(IsNotATriangleException.class, () -> {
            throw new IsNotATriangleException("Length of the triangle side can't be a negative number or equal to zero.");
        });
        assertEquals(exception.getMessage(), "Length of the triangle side can't be a negative number or equal to zero.");
    }

    @ParameterizedTest
    @CsvSource({"-3, 4, 5", "10, -20, 30", "9, 8, -7"})
    @DisplayName("Test with NEGATIVE length value")
    void negativeTest2(int a, int b, int c) {
        Triangle triangle = new Triangle();
        assertThrows(IsNotATriangleException.class, ()-> triangle.getTriangleArea(a, b ,c));
        Throwable exception = assertThrows(IsNotATriangleException.class, () -> {
            throw new IsNotATriangleException("Length of the triangle side can't be a negative number or equal to zero.");
        });
        assertEquals(exception.getMessage(), "Length of the triangle side can't be a negative number or equal to zero.");
    }

    @ParameterizedTest
    @CsvSource({"1, 4, 1", "10, 200, 30", "9, 7, 18"})
    @DisplayName("Test for a non-existent triangle")
    void negativeTest3(int a, int b, int c) {
        Triangle triangle = new Triangle();
        assertThrows(IsNotATriangleException.class, ()-> triangle.getTriangleArea(a, b ,c));
        Throwable exception = assertThrows(IsNotATriangleException.class, () -> {
            throw new IsNotATriangleException("A triangle with such sides can't exist. Try with other length values.");
        });
        assertEquals(exception.getMessage(), "A triangle with such sides can't exist. Try with other length values.");
    }


}
