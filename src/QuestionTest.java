import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuestionTest {
    @Test
    void testCreate() {
        Question q = new Question(3, 4, "+");
        assertFalse(q.checkAnswer(0));  // 3 + 4 = 7, so 0 is incorrect
        assertTrue(q.checkAnswer(7));   // 3 + 4 = 7, so this is correct
    }

    @Test
    void testMultiplication() {
        Question q = new Question(3, 4, "*");
        assertTrue(q.checkAnswer(12));  // 3 * 4 = 12, so this is correct
        assertFalse(q.checkAnswer(11)); // 3 * 4 = 12, so 11 is incorrect
    }
}


