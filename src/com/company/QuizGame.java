package com.company;

import java.io.IOException;

public class QuizGame {
    public Leaderboard leaderboard;
    private final Quiz quiz;

    public QuizGame(User player, String usersDataPath, String questionsDataPath) throws IOException {
        leaderboard = new Leaderboard(usersDataPath);
        quiz = new Quiz(player, questionsDataPath, usersDataPath);
    }

    public int printMenu() {
        return 0;
    }

    private void startGame() throws IOException {
        quiz.initQuiz();
    }

    public void printLeaderboard() {
        leaderboard.printLeaderboard();
    }

    public void printUserInfo(String nickname) {
        leaderboard.printUserInfo(nickname);
    }
}
