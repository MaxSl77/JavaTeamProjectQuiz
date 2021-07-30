package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static com.company.Main.scanner;

public class Quiz {
    private List<Question> questions;
    private User player;
    private String questionsDataPath;
    private String usersDataPath;

    public Quiz(User user, String questionsDataPath, String usersDataPath) throws IOException {
        this.player = user;
        this.questionsDataPath = questionsDataPath;
        this.usersDataPath = usersDataPath;
        loadQuestions();
    }

    private void loadQuestions() throws IOException {
        File file = new File(questionsDataPath);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        questions = Arrays.asList(objectMapper.readValue(file, Question[].class));
    }

    public void initQuiz() throws IOException {
        int counter = 0;
        String userAnswer;
        List <String> userAnswers = new LinkedList<>();
        for (int i = 0; i < questions.size(); i++) {
            System.out.print("\n" + (i + 1) + " question:\n " + questions.get(i).getFormulation());
            userAnswer = scanner.nextLine();
            userAnswer = userAnswer.toLowerCase();
            userAnswers.add(i,userAnswer);
            if (isUserAnswerCorrect(userAnswer,i))
                counter++;
        }
        player.setAnswers(userAnswers);
        player.setRating(counter*10/questions.size());
        player.saveToFile(usersDataPath);
    }

    private boolean isUserAnswerCorrect(String userAnswer, int i){
        return userAnswer.equals(questions.get(i).getAnswer());
    }

}
