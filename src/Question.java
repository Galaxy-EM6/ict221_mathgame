import java.util.Random;

public class Question {
    private int x;
    private int y;
    private String operator;
    private int correctAnswer;

    // Constructor for random questions (used in the game)
    public Question(Random rand) {
        this.x = rand.nextInt(12) + 1;
        this.y = rand.nextInt(12) + 1;
        int operationType = rand.nextInt(4); // 0 = +, 1 = -, 2 = *, 3 = /

        switch (operationType) {
            case 0: // Addition
                operator = "+";
                correctAnswer = x + y;
                break;
            case 1: // Subtraction (ensure non-negative result)
                operator = "-";
                if (x < y) { // Swap to ensure x >= y
                    int temp = x;
                    x = y;
                    y = temp;
                }
                correctAnswer = x - y;
                break;
            case 2: // Multiplication
                operator = "*";
                correctAnswer = x * y;
                break;
            case 3: // Division (ensure integer result)
                operator = "/";
                x = (rand.nextInt(12) + 1) * (rand.nextInt(6) + 1); // x is a multiple of some number
                y = getRandomDivisor(x, rand);
                correctAnswer = x / y;
                break;
        }
    }

    // Constructor for testing with specific values
    public Question(int x, int y, String operator) {
        this.x = x;
        this.y = y;
        this.operator = operator;

        switch (operator) {
            case "+":
                correctAnswer = x + y;
                break;
            case "-":
                if (x < y) {
                    int temp = x;
                    x = y;
                    y = temp;
                }
                correctAnswer = x - y;
                break;
            case "*":
                correctAnswer = x * y;
                break;
            case "/":
                x = (x == 0) ? 1 : x;  // Prevent division by zero
                y = (y == 0) ? 1 : y;  // Prevent division by zero
                correctAnswer = x / y;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    private int getRandomDivisor(int num, Random rand) {
        int divisor;
        do {
            divisor = rand.nextInt(num) + 1;
        } while (num % divisor != 0 || divisor == num); // Ensure valid divisor & avoid x / x
        return divisor;
    }

    public String getQuestion() {
        return String.format("What is %d %s %d? ", x, operator, y);
    }

    public boolean checkAnswer(int response) {
        return response == correctAnswer;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}
