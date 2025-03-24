import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Question and MathQuestion classes.
 *
 * Ensures that math questions generate correct answers
 * and that checking answers functions correctly.
 *
 * @author Eli McArthur
 */

public class QuestionTest {
    @Test
    void testCreate() {
        MathQuestion q = new MathQuestion();

        String questionText = q.getQuestion();
        int expectedAnswer = q.getCorrectAnswer();

        assertFalse(q.checkAnswer(expectedAnswer - 1));
        assertTrue(q.checkAnswer(expectedAnswer));
    }
}
