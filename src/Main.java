import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Main class for the Math Game.
 * Manages the list of questions and handles game flow.
 *
 * This class creates and manages a list of math and joke questions,
 * tracks the player's score, and ensures incorrect answers are repeated.
 *
 * @author Eli McArthur
 */


public class Main {
    private ArrayList<Question> questions = new ArrayList<>();

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int initialSize = 10;

        // Generate 9 MathQuestion objects and 1 JokeQuestion
        for (int i = 0; i < 9; i++) {
            questions.add(new MathQuestion());
        }
        questions.add(new JokeQuestion());

        int i = 0;
        while (i < questions.size()) {
            Question q = questions.get(i);
            q.showQuestion();

            if (q instanceof MathQuestion) {
                int userAnswer;
                try {
                    userAnswer = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid input! Please enter a number.");
                    scanner.nextLine(); // Correct buffer handling
                    continue;
                }

                if (q.checkAnswer(userAnswer)) {
                    System.out.println("Correct!");
                    if (i < initialSize) {
                        score++; // Only award points for first attempt
                    }
                } else {
                    System.out.println("Incorrect! Try again later.");
                    questions.add(q); // Re-add question for retry
                    Collections.shuffle(questions); // Shuffle list after adding
                }
            } else {
                System.out.println("Just for fun! No points awarded.");
            }
            i++;
        }

        System.out.println("Final Score: " + score + " out of " + initialSize);
        scanner.close();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.playGame();
    }
}
