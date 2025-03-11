import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * This is a simple math game for grades 3-5.
 *
 * @author Your Name
 */
public class MathGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
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

            if (question.checkAnswer(response)) {
                System.out.println("Correct! Well done!\n");
                correctCount++;
            } else {
                System.out.printf("Incorrect! The correct answer was %d.\n\n", question.getCorrectAnswer());
            }
        }

        // Display final score
        System.out.printf("You got %d out of 10 correct.\n", correctCount);
        if (correctCount >= 8) {
            System.out.println("Great job! You're a math pro!");
        } else {
            System.out.println("Keep practicing, you'll get better!");
        }

        input.close();
    }
}
