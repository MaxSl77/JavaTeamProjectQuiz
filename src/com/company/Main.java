package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        User user;
        System.out.println("Please enter your nickname:");
        user = new User(scanner.nextLine());
        try {
            QuizGame quiz = new QuizGame(user, "users.json", "questions.json");
            while (true) {
                System.out.println("Enter '0' to leave the game;\n" +
                        "Enter '1' to start the game;\n" +
                        "Enter '2' to show the leaderboard;\n" +
                        "Enter '3' to find game info about a user.");
                String response = scanner.nextLine();
                switch (response) {
                    case "0":
                        System.out.println("Thank you for playing! Bye.");
                        scanner.close();
                        return;
                    case "1":
                        System.out.println("Starting quiz...");
                        quiz.startGame();
                        break;
                    case "2":
                        quiz.printLeaderboard();
                        break;
                    case "3":
                        System.out.println("Enter user's nickname:");
                        quiz.printUserInfo(scanner.nextLine());
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
