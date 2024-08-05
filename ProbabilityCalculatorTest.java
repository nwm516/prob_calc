import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static java.lang.Float.NaN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import javax.swing.*;

public class ProbabilityCalculatorTest {
    private ProbabilityCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new ProbabilityCalculator();
        // Prevents NullPointerException
        calculator.add(new JLabel());
    }

    // Normal Test Cases

    @Test
    public void testCalculatePositiveProbability_NormalCase1() {
        double prevalence = 0.01;
        double sensitivity = 0.9;
        double specificity = 0.9;
        double expected = 0.0833;
        double result = calculator.calculatePositiveProbability(prevalence, sensitivity, specificity);
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void testCalculatePositiveProbability_NormalCase2() {
        double prevalence = 0.05;
        double sensitivity = 0.85;
        double specificity = 0.95;
        double expected = 0.4722;
        double result = calculator.calculatePositiveProbability(prevalence, sensitivity, specificity);
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void testCalculatePositiveProbability_NormalCase3() {
        double prevalence = 0.2;
        double sensitivity = 0.75;
        double specificity = 0.85;
        double expected = 0.5555;
        double result = calculator.calculatePositiveProbability(prevalence, sensitivity, specificity);
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void testCalculateNegativeProbability_NormalCase1() {
        double prevalence = 0.01;
        double sensitivity = 0.9;
        double specificity = 0.9;
        double expected = 0.0011;
        double result = calculator.calculateNegativeProbability(prevalence, sensitivity, specificity);
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void testCalculateNegativeProbability_NormalCase2() {
        double prevalence = 0.05;
        double sensitivity = 0.85;
        double specificity = 0.95;
        double expected = 0.0082;
        double result = calculator.calculateNegativeProbability(prevalence, sensitivity, specificity);
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void testCalculateNegativeProbability_NormalCase3() {
        double prevalence = 0.2;
        double sensitivity = 0.75;
        double specificity = 0.85;
        double expected = 0.0685;
        double result = calculator.calculateNegativeProbability(prevalence, sensitivity, specificity);
        assertEquals(expected, result, 0.0001);
    }

    // Edge Test Cases

    @Test
    public void testCalculatePositiveProbability_EdgeCase1() {
        double prevalence = 0.0;
        double sensitivity = 0.9;
        double specificity = 0.9;
        double expected = 0.0;
        double result = calculator.calculatePositiveProbability(prevalence, sensitivity, specificity);
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void testCalculatePositiveProbability_EdgeCase2() {
        double prevalence = 1.0;
        double sensitivity = 0.0;
        double specificity = 0.9;
        double expected = NaN;
        double result = calculator.calculatePositiveProbability(prevalence, sensitivity, specificity);
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void testCalculatePositiveProbability_EdgeCase3() {
        double prevalence = 0.5;
        double sensitivity = 0.0;
        double specificity = 0.0;
        double expected = 0.0;
        double result = calculator.calculatePositiveProbability(prevalence, sensitivity, specificity);
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void testCalculateNegativeProbability_EdgeCase1() {
        double prevalence = 0.0;
        double sensitivity = 0.9;
        double specificity = 0.9;
        double expected = 0.0;
        double result = calculator.calculateNegativeProbability(prevalence, sensitivity, specificity);
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void testCalculateNegativeProbability_EdgeCase2() {
        double prevalence = 1.0;
        double sensitivity = 0.0;
        double specificity = 0.9;
        double expected = 1.0;
        double result = calculator.calculateNegativeProbability(prevalence, sensitivity, specificity);
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void testCalculateNegativeProbability_EdgeCase3() {
        double prevalence = 0.5;
        double sensitivity = 0.0;
        double specificity = 0.0;
        double expected = 1.0;
        double result = calculator.calculateNegativeProbability(prevalence, sensitivity, specificity);
        assertEquals(expected, result, 0.0001);
    }
}
