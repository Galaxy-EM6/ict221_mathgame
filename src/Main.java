import java.util.Scanner;

public class Main {
    private HighScores highScores = new HighScores();  // HighScores field
    private Scanner scanner = new Scanner(System.in);  // Use a single scanner for the whole program

    public static void main(String[] args) {
        Main main = new Main();
        main.playMultipleGames();
    }

    public void playMultipleGames() {
        boolean playing = true;

        while (playing) {
            // Start a new game
            MathGame game = new MathGame();
            int score = game.playGame();  // Get the score after the game ends
            game.close();  // Close the game (release resources)

            // Record the score if it's higher than the current high score
            highScores.recordScore(score);
            System.out.println("Your new high score is: " + highScores.getHighestScore());

            // Ask user if they want to play again
            System.out.print("Do you want to play again? (yes/no): ");

            // Consume the newline left by nextInt() before reading the next line
            if (scanner.hasNextLine()) {
                scanner.nextLine();  // This clears the buffer
            }

            // Wait for the user to input a response
            String userResponse = scanner.nextLine().trim();

            // Check if the user wants to play again
            if (!userResponse.equalsIgnoreCase("yes")) {
                playing = false;
                System.out.println("Thank you for playing!");
            }
        }

        scanner.close();  // Close the scanner after the loop ends
    }
}
