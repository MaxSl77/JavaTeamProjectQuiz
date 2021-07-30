package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user;
        System.out.println("Please enter your nickname:");
        user = new User(scanner.nextLine());
        try {
            QuizGame quiz = new QuizGame(user, "users.json", "questions.json");
            while (true) {
                if (quiz.printMenu() == 0) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


//        String q1 = "What is a correct syntax to output \"Hello World\" in Java?\n" + " a) \n print (\"Hello World\");" +
//                "b) Console.WriteLine(\"Hello World\");\n c) echo(\"Hello World\");\n d) System.out.println(\"Hello World\");";
//        String q2 = "Java is short for \"JavaScript\" (Yes or No)?\n";
//        String q3 = "How do you insert COMMENTS in Java code?\n" + " a) // This is a comment\n b) # This is a comment\n c) /* This is a comment\n";
//        String q4 = "Which data type is used to create a variable that should store text?\n" + " a) string\n b) String\n c) myString\n d) Txt\n";
//        String q5 = "How do you create a variable with the numeric value 5?\n" + " a) int x = 5;\n b) num x = 5\n c) x = 5;\n d) float x = 5;\n";
//        String q6 = "How do you create a variable with the floating number 2.8?\n" + " a) byte x = 2.8f\n b) x = 2.8f;\n c) float x = 2.8f;\n d) int x = 2.8f;\n";
//        String q7 = "Which method can be used to find the length of a string?\n" + " a) getLength()\n b) length()\n c) getSize()\n d) len()\n";
//        String q8 = "The value of a string variable can be surrounded by single quotes. (Yes or No) \n";
//        String q9 = "Which method can be used to return a string in upper case letters?\n" + " a) touppercase()\n b) upperCase()\n c) tuc()\n d) toUpperCase()\n";
//        String q10 = "Which keyword is used to create a class in Java?\n" + " a) MyClass\n b) class \n c) className\n d) class()\n";
//
//        Question [] questions = {
//                new Question(q1,"d"),
//                new Question(q2,"no"),
//                new Question(q3,"a"),
//                new Question(q4,"b"),
//                new Question(q5,"a"),
//                new Question(q6,"c"),
//                new Question(q7,"b"),
//                new Question(q8,"no"),
//                new Question(q9,"d"),
//                new Question(q10,"b"),
//        };
    }
}
