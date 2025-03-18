import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HighScoresTest {

    @Test
    void testRecordHighScore() {
        HighScores highScores = new HighScores();

        // Record the first score and check if it's the highest
        highScores.recordScore(5);
        assertEquals(5, highScores.getHighestScore());

        // Record a higher score and check if the highest score is updated
        highScores.recordScore(10);
        assertEquals(10, highScores.getHighestScore());

        // Record a lower score and check if the highest score remains unchanged
        highScores.recordScore(7);
        assertEquals(10, highScores.getHighestScore()); // Should not decrease
    }
}
