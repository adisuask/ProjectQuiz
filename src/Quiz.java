import java.util.ArrayList;

public class Quiz {
   private ArrayList <Question>questions;
    public Quiz(ArrayList<Question> questions) {
        this.questions = questions;
    }
    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }
    public void displayQuiz() {
        for (int i = 0; i < questions.size(); i++) {
            System.out.println("Question " + (i + 1) + ":");
            questions.get(i).displayQuestion();
            System.out.println(); // Add a newline for better readability
        }
    }
    public int scoreQuiz(ArrayList<Integer> playerAnswers) {
        if (playerAnswers.size() != questions.size()) {
            throw new IllegalArgumentException("Number of player answers must match the number of questions.");
        }
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i).isCorrectAnswer(playerAnswers.get(i))) {
                score++;
            }
        }
        return score;
    }
}
