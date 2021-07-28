package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<Question> questions;
    private User player;

    public Quiz(User user, String questionsDataPath) throws IOException {
        this.player = user;
        loadQuestions(questionsDataPath);
    }

    private void loadQuestions(String questionsDataPath) throws IOException {
        File file = new File(questionsDataPath);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        questions = Arrays.asList(objectMapper.readValue(file, Question[].class));
    }

    public void initQuiz(String usersDataPath) throws IOException {
        int counter = 0;
        String userAnswer;
        List <String> userAnswers = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < questions.size(); i++) {
            System.out.println(i + " question:\n " + questions.get(i).getFormulation());
            userAnswer = scanner.nextLine();
            userAnswers.add(i,userAnswer);
            if (checkAnswer(userAnswer,i))
                counter++;
        }
        player.setAnswers(userAnswers);
        player.setRating(counter*10/questions.size());
        scanner.close();
        player.saveToFile(usersDataPath);
    }
    private boolean checkAnswer(String userAnswer, int i){
        return userAnswer.equals(questions.get(i).getCorrectAnswer());
    }

}
