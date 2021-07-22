package com.company;

import java.io.*;
import java.util.List;
import java.util.Objects;

public class User implements Serializable {
    private String nickname;
    private int bestRating;
    private List<String> answers;

    public User(String nickname) {
        this.nickname = nickname;
    }

    public int getBestRating() {
        return bestRating;
    }

    public void setBestRating(int bestRating) {
        this.bestRating = bestRating;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public void saveToFile(String path) {
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(path))) {
            stream.writeObject(this);
            System.out.println("Written user to the file. (Note: this message is only for testing)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return bestRating == user.bestRating && Objects.equals(nickname, user.nickname) && Objects.equals(answers, user.answers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, bestRating, answers);
    }
}
