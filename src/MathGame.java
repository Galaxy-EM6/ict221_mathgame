import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * This is a simple math game for grades 3-5.
 *
 * @author Your Name
 */
public class MathGame {
    private Scanner input;
    private Random rand;

    public MathGame() {
        input = new Scanner(System.in);
        rand = new Random();
    }

    // Returns the score of the game
    public int playGame() {
        int correctCount = 0;
        System.out.println("Welcome to the Math Game!\n");

        for (int i = 0; i < 10; i++) {
            Question question = new Question(rand);
            System.out.print(question.getQuestion());

            int response;
            try {
                response = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.\n");
                input.next(); // Clear invalid input
                continue;
            }

            // Consume newline character left by nextInt()
            input.nextLine();

            if (question.checkAnswer(response)) {
                System.out.println("Correct! Well done!\n");
                correctCount++;
            } else {
                System.out.printf("Incorrect! The correct answer was %d.\n\n", question.getCorrectAnswer());
            }
        }

        displayScore(correctCount);
        return correctCount;  // Return the score
    }

    private void displayScore(int score) {
        System.out.printf("You got %d out of 10 correct.\n", score);
        if (score >= 8) {
            System.out.println("Great job! You're a math pro!");
        } else {
            System.out.println("Keep practicing, you'll get better!");
        }
    }

    public void close() {
        input.close();
    }
}
