import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ShapeClassifierTest {

    // Black Box Tests

    @Test
    @DisplayName("Invalid Input Format")
    public void testInvalidInput() {
        ShapeClassifier classifier = new ShapeClassifier();
        String result = classifier.evaluateGuess("InvalidFormat");
        assertEquals("No", result);
    }

     // White Box Tests - Based on code analysis

    @Test
    @DisplayName("Test Rectangle vs Square Branch")
    public void testRectangleClassification() {
        ShapeClassifier classifier = new ShapeClassifier();
        String result = classifier.evaluateGuess("Square,Large,Yes,20,20,30,30");
        assertTrue(result.contains("Suggestion=Rectangle"));
    }
    
    @Test
    @DisplayName("Test Triangle Invalid Sides")
    public void testInvalidTriangle() {
        ShapeClassifier classifier = new ShapeClassifier();
        String result = classifier.evaluateGuess("Scalene,Large,Yes,1,1,10");
        assertTrue(result.contains("Not A Triangle"));
    }

    // Example Test

    @Test
    @DisplayName("Example Test")
    public void example() {
    ShapeClassifier s = new ShapeClassifier();
    String answer = s.evaluateGuess("Equilateral,Large,Yes,100,100,100");
    assertNotEquals("Yes", answer);
    }
}
