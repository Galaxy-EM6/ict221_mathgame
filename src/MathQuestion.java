import java.util.Random;

/**
 * Represents a randomly generated math question.
 *
 * This class generates an arithmetic question with random numbers
 * and an operator (+, -, *) and checks the user's answer.
 *
 * @author Eli McArthur
 */

public class MathQuestion extends Question {
    private int num1;
    private int num2;
    private String operator;
    private int correctAnswer;

    public MathQuestion() {
        super(""); // Call the parent constructor with an empty string

        Random rand = new Random();
        num1 = rand.nextInt(10) + 1;
        num2 = rand.nextInt(10) + 1;

        String[] operators = {"+", "-", "*"};
        operator = operators[rand.nextInt(operators.length)];

        switch (operator) {
            case "+": correctAnswer = num1 + num2; break;
            case "-": correctAnswer = num1 - num2; break;
            case "*": correctAnswer = num1 * num2; break;
        }

        // ✅ Use the setter instead of directly modifying questionText
        setQuestionText("What is " + num1 + " " + operator + " " + num2 + "?");
    }

    public String getQuestion() {
        return getQuestionText();
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public boolean checkAnswer(int answer) {
        return answer == correctAnswer;
    }
}
