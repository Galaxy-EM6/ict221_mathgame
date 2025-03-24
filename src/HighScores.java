/**
 * Tracks the highest score recorded in the game.
 * <p>
 * This class stores and updates the highest score achieved
 * across multiple game sessions.
 *
 * @author Eli McArthur
 */

public class HighScores {
    private int highestScore = 0;

    /**
     * Records the score if it's higher than the current highest score.
     *
     * @param score the score achieved in a game session
     */
    public void recordScore(int score) {
        if (score > highestScore) {
            highestScore = score;
        }
    }

    /**
     * Returns the highest score recorded.
     *
     * @return highest score achieved
     */
    public int getHighestScore() {
        return highestScore;
    }
}
