import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A simple math game for grades 3-5.
 *
 * This class handles game interactions, takes user input,
 * and provides feedback on correct and incorrect answers.
 *
 * @author Eli McArthur
 */

public class MathGame {
    private Scanner input;

    public MathGame() {
        input = new Scanner(System.in);
    }

    /**
     * Runs the game and returns the final score.
     *
     * @return score achieved by the player
     */
    public int playGame() {
        int correctCount = 0;
        System.out.println("Welcome to the Math Game!\n");

        for (int i = 0; i < 10; i++) {
            MathQuestion question = new MathQuestion();
            System.out.println(question.getQuestion());

            int response;
            try {
                response = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.\n");
                input.nextLine(); // Correct buffer handling
                continue;
            }

            input.nextLine(); // Consume newline

            if (question.checkAnswer(response)) {
                System.out.println("Correct! Well done!\n");
                correctCount++;
            } else {
                System.out.printf("Incorrect! The correct answer was %d.\n\n", question.getCorrectAnswer());
            }
        }

        displayScore(correctCount);
        return correctCount;
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
