package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String q1 = "Вопрос1?\n"
                  +"(a)Вариант1\n(b)Вариант2\n(c)Вариант3\n(d)Вариант4\n";
        String q2 = "Вопрос2?\n"
                +"(a)Вариант1\n(b)Вариант2\n(c)Вариант3\n(d)Вариант4\n";
        String q3 = "Вопрос3?\n"
                +"(a)Вариант1\n(b)Вариант2\n(c)Вариант3\n(d)Вариант4\n";
        String q4 = "Вопрос4?\n"
                +"(a)Вариант1\n(b)Вариант2\n(c)Вариант3\n(d)Вариант4\n";
        String q5 = "Вопрос5?\n"
                +"(a)Вариант1\n(b)Вариант2\n(c)Вариант3\n(d)Вариант4\n";
        String q6 = "Вопрос6?\n"
                +"(a)Вариант1\n(b)Вариант2\n(c)Вариант3\n(d)Вариант4\n";
        String q7 = "Вопрос7?\n"
                +"(a)Вариант1\n(b)Вариант2\n(c)Вариант3\n(d)Вариант4\n";
        String q8 = "Вопрос8?\n"
                +"(a)Вариант1\n(b)Вариант2\n(c)Вариант3\n(d)Вариант4\n";
        String q9 = "Вопрос9?\n"
                +"(a)Вариант1\n(b)Вариант2\n(c)Вариант3\n(d)Вариант4\n";
        String q10 = "Вопрос10?\n"
                +"(a)Вариант1\n(b)Вариант2\n(c)Вариант3\n(d)Вариант4\n";

        Question [] questions = {
                new Question(q1,"a"),
                new Question(q2,"a"),
                new Question(q3,"a"),
                new Question(q4,"a"),
                new Question(q5,"a"),
                new Question(q6,"a"),
                new Question(q7,"a"),
                new Question(q8,"a"),
                new Question(q9,"a"),
                new Question(q10,"a")
        };
        startQuiz(questions);
    }
    public static void startQuiz(Question [] questions){
        int result = 0;
        Scanner answerInput = new Scanner(System.in);

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i].questionquiz);
            String answer = answerInput.nextLine();
            if (answer.equals(questions[i].answer));  {
                result++;
            }

        }
        System.out.println("You result "+result+"/"+questions.length);
    }
}
