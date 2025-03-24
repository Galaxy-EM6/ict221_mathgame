/**
 * Abstract class representing a general question.
 *
 * This class serves as a base for different types of questions,
 * providing common functionality like displaying the question.
 *
 * @author Eli McArthur
 */

public abstract class Question {
    private String questionText;

    public Question(String questionText) {
        this.questionText = questionText;
    }

    public void showQuestion() {
        System.out.println(questionText);
    }

    public String getQuestionText() {
        return questionText;
    }

    // ✅ Add this setter to allow subclasses to modify questionText
    protected void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public abstract boolean checkAnswer(int answer);
}
