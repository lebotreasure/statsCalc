import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

public class StatisticsCalculatorTest {

    private StatisticsCalculator calculator;

    @BeforeEach
    public void setUp() {
        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        calculator = new StatisticsCalculator(numbers);
    }

    @Test
    public void testGetMin() {
        assertEquals(1, calculator.getMin());
    }

    @Test
    public void testGetMax() {
        assertEquals(5, calculator.getMax());
    }

    @Test
    public void testGetCount() {
        assertEquals(5, calculator.getCount());
    }

    @Test
    public void testGetAverage() {
        assertEquals(3.0, calculator.getAverage());
    }

    @Test
    public void testEmptyListThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new StatisticsCalculator(List.of());
        });

        String expectedMessage = "The list of numbers cannot be null or empty";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testNullListThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new StatisticsCalculator(null);
        });
        String expectedMessage = "The list of numbers cannot be null or empty";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
