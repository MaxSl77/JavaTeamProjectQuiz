package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<Question> questions;
    private User user;

    public Quiz(User user) {
        this.user = user;
    }


    private void loadQuestions() throws IOException {
        byte[] file = Files.readAllBytes(Paths.get("question.txt"));
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        questions = Arrays.asList(objectMapper.readValue(file, Question[].class));
    }
    private void initQuiz(){
        int counter = 0;
        String userAnswer;
        List <String> userAnswers = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < questions.size(); i++) {
            System.out.println(i + " question:\n " + questions.get(i).getFormulation);
            userAnswer = scanner.nextLine();
            userAnswers.add(i,userAnswer);
            if (checkAnswer(userAnswer,i))
                counter++;
        }
        user.setAnswers(userAnswers);
        user.setRating(counter*10/questions.size());
        scanner.close();
        user.saveToFile(user);
    }
    private boolean checkAnswer(String userAnswer, int i){
        if (userAnswer.equals(questions.get(i).getCorrectAnswer))
            return true;
        else return false;
    }

}
