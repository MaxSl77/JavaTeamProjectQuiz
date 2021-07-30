package com.company;

import java.io.IOException;

public class QuizGame {
    public Leaderboard leaderboard;
    private final Quiz quiz;

    public QuizGame(User player, String usersDataPath, String questionsDataPath) throws IOException {
        leaderboard = new Leaderboard(usersDataPath);
        quiz = new Quiz(player, questionsDataPath, usersDataPath);
    }

    public void startGame() throws IOException {
        quiz.initQuiz();
    }

    public void printLeaderboard() throws IOException {
        leaderboard.printLeaderboard();
    }

    public void printUserInfo(String nickname) throws IOException {
        leaderboard.printUserInfo(nickname);
    }
}
