package com.company;

import java.io.IOException;

public class QuizGame {
    public Leaderboard leaderboard;
    private Quiz quiz;

    public QuizGame(User player, String usersDataPath, String questionsDataPath) throws IOException {
        leaderboard = new Leaderboard(usersDataPath);
        quiz = new Quiz(player, questionsDataPath, usersDataPath);
    }

    public void startGame() {
        quiz.initQuiz();
    }

    public void printLeaderboard() {
        leaderboard.printLeaderboard();
    }

    public void printUserInfo(String nickname) {
        leaderboard.printUserInfo(nickname);
    }
}
