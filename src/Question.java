import java.util.*;
public class Question {
    private String questionText;//Text of the question

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }

    public void setCorrectOptionIndex(int correctOptionIndex) {
        this.correctOptionIndex = correctOptionIndex;
    }

    private  ArrayList<String> options; //List of options for the question
    private int correctOptionIndex;
    //): Index of the correct option in the options list
    public Question(String questionText, ArrayList<String> options, int correctOptionIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }
    public void displayQuestion(){
        //Display the question and options
        System.out.println(questionText);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }
    public boolean isCorrectAnswer(int answerIndex){
        //Check if the given answer index is correct.
         boolean resualt=answerIndex == correctOptionIndex;
        return resualt;
    }

}
