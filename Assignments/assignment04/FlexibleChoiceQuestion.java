package assignment04;

import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

public class FlexibleChoiceQuestion extends ChoiceQuestion{
    private Set<String> answers = new HashSet<String>();
    
    public FlexibleChoiceQuestion(String qText) {
        super(qText);
    }
    
    public void addChoice(String choice, boolean correct) {
        throw new UnsupportedOperationException("Use the one-argument version");
    }
    
    public void addChoice(String choice) {
        super.addChoice(choice, false);
    }
    
    public void addAnswer(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Answers must be numbered from 1");
        } else {
            answers.add("" + i);
        }
    }
    
    public void presentQuestion() {
		display();
		System.out.print("Your answer (separate multiple answers by a space): ");
		Scanner in = new Scanner(System.in);
		String response = in.nextLine();
		System.out.println(checkAnswer(response));
    }
    
    public boolean checkAnswer(String response) {
        String[] parts = response.trim().split("\\s+");
        Set<String> responses = new HashSet<String>();
        for (String i : parts) {
            responses.add(i);
        }
        int numResponses = responses.size();
        if (numResponses != parts.length) {
            System.out.println("You have repeated answers");
        }
        if (responses.equals(answers)) { 
            return true; 
        }
        responses.removeAll(answers);
        if (responses.size() == 0) {
            System.out.println("Your answers were correct but you missed some");
            return false;
        }
        if (responses.size() < numResponses) {
            System.out.println("You have some correct answers and some incorrect ones");
            return false;
        }
        System.out.println("All your answers were wrong");
        return false;
    }
}