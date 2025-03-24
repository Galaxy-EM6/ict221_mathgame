import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Unit tests for the HighScores class.
 *
 * Tests whether scores are properly recorded and if the highest score
 * is updated correctly without decreasing.
 *
 * @author Eli McArthur
 */
class HighScoresTest {

    @Test
    void testRecordHighScore() {
        HighScores highScores = new HighScores();

        highScores.recordScore(5);
        assertEquals(5, highScores.getHighestScore());

        highScores.recordScore(10);
        assertEquals(10, highScores.getHighestScore());

        highScores.recordScore(7);
        assertEquals(10, highScores.getHighestScore()); // Should remain unchanged
    }
}
