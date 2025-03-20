package program1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Simple division should work")
    void testDivide() {
        assertEquals(2, calculator.divide(4, 2), "Regular division should work");
    }

    @RepeatedTest(5)
    @DisplayName("Ensure correct handling of zero in numerator")
    void testDivideWithZero() {
        assertEquals(0, calculator.divide(0, 5), "Division with zero as numerator should be zero");
    }

    @Test
    @DisplayName("Ensure correct handling of zero at denominator")
    void exceptionTesting() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> calculator.divide(5, 0));
        assertEquals("Denominator cannot be 0.", exception.getMessage());
    }
}