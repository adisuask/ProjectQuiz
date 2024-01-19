import java.util.*;

public class QuizSystem {
    private static Map<String, Integer> globalScores = new HashMap<>();

    public static void main(String[] args) {
        ArrayList<Question> allQuestions = populateQuestions();
        Quiz quiz = new Quiz(generateRandomQuiz(allQuestions));

        Scanner scanner = new Scanner(System.in);

        // Main Menu Loop
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Start Quiz");
            System.out.println("2. Display Results");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    startQuiz(scanner, quiz);
                    break;
                case 2:
                    displayResults();
                    break;
                case 3:
                    System.out.println("Exiting the Quiz System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    // Helper method to populate the list of questions
    private static ArrayList<Question> populateQuestions() {
        // Your implementation of adding questions to the list goes here
        // For simplicity, I'm creating two sample questions
        Question question1 = new Question("What is the capital of France?", new ArrayList<>(Arrays.asList("Berlin", "London", "Paris", "Madrid")), 3);
        Question question2 = new Question("Which planet is known as the Red Planet?", new ArrayList<>(Arrays.asList("Earth", "Mars", "Venus", "Jupiter")), 2);
        Question question3 = new Question("What is the capital of Ethiopia?", new ArrayList<>(Arrays.asList("Addis Abebe", "London", "Paris", "Madrid")), 1);
        Question question4 = new Question("What is the capital of Isreal?", new ArrayList<>(Arrays.asList("Addis Abebe", "London", "Paris", "Jerusalem")), 4);
        Question question5 = new Question("What is the capital of Spain?", new ArrayList<>(Arrays.asList("Addis Abebe", "London", "Paris", "Madrid")), 4);
        Question question6 = new Question("What is the capital of England?", new ArrayList<>(Arrays.asList("Addis Abebe", "London", "Paris", "Jerusalem")), 2);
        Question question7 = new Question("What is the capital of France?", new ArrayList<>(Arrays.asList("Berlin", "London", "Paris", "Madrid")), 3);
        Question question8 = new Question("Which planet is known as the Red Planet?", new ArrayList<>(Arrays.asList("Earth", "Mars", "Venus", "Jupiter")), 2);
        Question question9 = new Question("What is the capital of Ethiopia?", new ArrayList<>(Arrays.asList("Addis Abebe", "London", "Paris", "Madrid")), 1);
        Question question10 = new Question("What is the capital of Isreal?", new ArrayList<>(Arrays.asList("Addis Abebe", "London", "Paris", "Jerusalem")), 4);
        Question question11 = new Question("What is the capital of Spain?", new ArrayList<>(Arrays.asList("Addis Abebe", "London", "Paris", "Madrid")), 4);
        Question question12 = new Question("What is the capital of England?", new ArrayList<>(Arrays.asList("Addis Abebe", "London", "Paris", "Jerusalem")), 2);


        return new ArrayList<>(Arrays.asList(question1, question2));
    }

    // Helper method to generate a random quiz from the list of all questions
    private static ArrayList<Question> generateRandomQuiz(ArrayList<Question> allQuestions) {
        if (allQuestions.size() <= 10) {
            return allQuestions;
        }

        ArrayList<Question> randomQuiz = new ArrayList<>();
        Set<Integer> selectedIndices = new HashSet<>();

        Random random = new Random();
        while (selectedIndices.size() < 10) {
            int randomIndex = random.nextInt(allQuestions.size());
            if (selectedIndices.add(randomIndex)) {
                randomQuiz.add(allQuestions.get(randomIndex));
            }
        }

        return randomQuiz;
    }

    // Method to start the quiz for a user
    private static void startQuiz(Scanner scanner, Quiz quiz) {
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        QuizTaker quizTaker = new QuizTaker(playerName);
        quizTaker.takeQuiz(quiz);
        globalScores.put(playerName, quizTaker.getQuizScores().get(playerName));
    }

    // Method to display quiz results for all players
    private static void displayResults() {
        System.out.println("\nQuiz Results:");
        for (Map.Entry<String, Integer> entry : globalScores.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " points");
        }
    }
}