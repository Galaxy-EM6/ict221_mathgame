public class HighScores {
    private int highestScore = 0;

    // Records the score if it's higher than the current highest score
    public void recordScore(int score) {
        if (score > highestScore) {
            highestScore = score;
        }
    }

    // Returns the highest score recorded
    public int getHighestScore() {
        return highestScore;
    }
}
