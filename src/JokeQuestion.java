/**
 * Represents a joke question that provides humor instead of a math problem.
 *
 * This subclass of Question overrides methods to display joke-based questions
 * with no wrong answers.
 *
 * @author Eli McArthur
 */

class JokeQuestion extends Question {
    public JokeQuestion() {
        super("How many programmers does it take to change a lightbulb?\nAnswer: None, that's a hardware problem!");
    }

    @Override
    public void showQuestion() {
        System.out.println(getQuestionText());
    }

    @Override
    public boolean checkAnswer(int answer) {
        return true; // No wrong answer for a joke!
    }
}
