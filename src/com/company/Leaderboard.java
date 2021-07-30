package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Leaderboard {
    private List<User> users = new LinkedList<>();
    private String usersDataPath;

    public Leaderboard(String usersDataPath) throws IOException {
        this.usersDataPath = usersDataPath;
        loadLeaderboard(usersDataPath);
    }

    private void loadLeaderboard(String usersDataPath) throws IOException {
        File file = new File(usersDataPath);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        if (file.length() != 0) {
            // Reading data from the JSON
            users = Arrays.asList(mapper.readValue(file, User[].class));
        }
    }

    public void printLeaderboard() throws IOException {
        loadLeaderboard(usersDataPath);
        if (!users.isEmpty()) {
            users.sort(Comparator.comparingInt(User::getRating));

            // Printing header of the table
            System.out.println("+" + "-".repeat(31) + "+");
            System.out.format("%1s%22s%10s", "|", "LEADERBOARD", "|");
            System.out.println("\n+" + "-".repeat(31) + "+");
            System.out.format("%1s%15s\t%7s%6s", "|", "USER", "RATING", "|");
            System.out.println("\n+" + "-".repeat(31) + "+");

            // Printing users
            for (User user : users) {
                System.out.format("%1s%15s%6d%11s", "|", user.getNickname(), user.getRating(), "|");
                System.out.println("\n+" + "-".repeat(31) + "+");
            }
        } else {
            System.out.println("Currently there are no players on the leaderboard.");
        }
    }

    public void printUserInfo(String nickname) throws IOException {
        loadLeaderboard(usersDataPath);
        if (!users.isEmpty()) {
            for (User user : users) {
                if (user.getNickname().equals(nickname)) {
                    System.out.println("\tUser " + user.getNickname()
                            + " has rating of " + user.getRating() + " points. "
                            + "Their answers were: " + user.getAnswers() + "\n");
                    return;
                }
            }
            System.out.println("\n\tWe have a problem: " +
                    "no user with nickname " + nickname + " found.\n");
        } else {
            System.out.println("Currently there are no players on the leaderboard.");
        }
    }
}
