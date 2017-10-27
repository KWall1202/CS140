package assignment04;

public class FlexibleChoiceQuestionDemo {
    public static void main(String[] args) {
        FlexibleChoiceQuestion threeAnswersFiveChoices = new FlexibleChoiceQuestion("The answers are \"red\", \"7\" and \"alpha\"");
        threeAnswersFiveChoices.addChoice("red");
        threeAnswersFiveChoices.addChoice("alpha");
        threeAnswersFiveChoices.addChoice("dont pick me!");
        threeAnswersFiveChoices.addChoice("7");
        threeAnswersFiveChoices.addChoice("77");
        threeAnswersFiveChoices.addAnswer(1);
        threeAnswersFiveChoices.addAnswer(2);
        threeAnswersFiveChoices.addAnswer(4);
        
        FlexibleChoiceQuestion noCorrectAnswer = new FlexibleChoiceQuestion("This question has no correct answers.");
        noCorrectAnswer.addChoice("I'm not correct");
        noCorrectAnswer.addChoice(null);
        noCorrectAnswer.addChoice("Not me either");
        
        FlexibleChoiceQuestion noChoices = new FlexibleChoiceQuestion("There are no choices. The correct answer is choices 3 6 and 12");
        noChoices.addAnswer(3);
        noChoices.addAnswer(6);
        noChoices.addAnswer(12);
       
        threeAnswersFiveChoices.presentQuestion();
        noCorrectAnswer.presentQuestion();
        noChoices.presentQuestion();
        
        FlexibleChoiceQuestion testQuestion = new FlexibleChoiceQuestion("Test question");
        System.out.println("Expecting an IllegalArgumentException");
        try {
            testQuestion.addAnswer(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Received: " + e);
        }
        System.out.println("Expecting an IllegalArgumentException");
        try {
            testQuestion.addAnswer(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("Received: " + e);
        }
        System.out.println("Expecting an UnsupportedOperationException");
        try {
            testQuestion.addChoice("Can't add this as a choice", true);
        } catch (UnsupportedOperationException e) {
            System.out.println("Received: " + e);
        }
    }
}