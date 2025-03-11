import java.util.Random;

public class Question {
    private int x;
    private int y;
    private String operator;
    private int correctAnswer;

    public Question(Random rand) {
        x = rand.nextInt(12) + 1;
        y = rand.nextInt(12) + 1;
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
