import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class QuizTaker {

    private String name;
    private Map<String, Integer> quizScores;

    public QuizTaker(String playerName) {
        this.name=playerName;
    }
    public QuizTaker() {
        this.quizScores = new HashMap<>();
    }


    // Constructor
    // Take a quiz and record the score
    public void takeQuiz(Quiz quiz) {
        System.out.println("Welcome, " + name + "!");
        System.out.println("You will be presented with 10 random questions.");

        // Initialize Variables
        ArrayList<Integer> playerAnswers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Take Quiz
        for (Question question : quiz.getQuestions()) {
            System.out.println("\nQuestion:");
            question.displayQuestion();

            // Prompt the quiz taker to enter their answer
            int userAnswer;
            do {
                System.out.print("Your answer (1-" + question.getOptions().size() + "): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next();
                }
                userAnswer = scanner.nextInt();
            } while (userAnswer < 1 || userAnswer > question.getOptions().size());

            // Record the quiz taker's answer
            playerAnswers.add(userAnswer);
        }

        // Score Quiz
        int score = quiz.scoreQuiz(playerAnswers);
        System.out.println("Quiz completed! Your score: " + score + "/" + quiz.getQuestions().size());

        // Record Score
        quizScores.put(this.name, score);
    }

    // Retrieve the map of quiz scores
    public Map<String, Integer> getQuizScores() {
        return quizScores;
    }
}
