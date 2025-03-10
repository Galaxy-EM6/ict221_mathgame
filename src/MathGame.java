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

        for (int i = 0; i < 10; i++) { // Generate 10 questions
            if (askQuestion(rand, input)) {
                correctCount++;
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

    /**
     * Asks a single math question and returns whether the answer was correct.
     * @param rand Random object for generating numbers
     * @param input Scanner object for reading user input
     * @return true if the answer was correct, false otherwise
     */
    public static boolean askQuestion(Random rand, Scanner input) {
        int x = rand.nextInt(12) + 1; // Random number between 1 and 12
        int y = rand.nextInt(12) + 1;
        String operator = "+";
        int correct;

        // Randomly decide between addition or subtraction
        if (rand.nextBoolean()) {
            correct = x + y;
        } else {
            operator = "-";
            correct = Math.max(x, y) - Math.min(x, y);
        }

        // Ask the question
        System.out.printf("What is %2d %s %2d? ", Math.max(x, y), operator, Math.min(x, y));

        int response;
        try {
            response = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a number.\n");
            input.next(); // Clear the invalid input
            return false;
        }

        // Check the answer
        if (response == correct) {
            System.out.println("Correct! Well done!\n");
            return true;
        } else {
            System.out.printf("Incorrect! The correct answer was %d.\n\n", correct);
            return false;
        }
    }
}
