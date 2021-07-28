package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class User {
    private String nickname;
    private int rating;
    private List<String> answers;

    public User() {
    }

    public User(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public void saveToFile(String path) throws IOException {
        File file = new File(path);
        FileWriter fileWriter = new FileWriter(file, true);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        SequenceWriter seqWriter = mapper.writer().writeValuesAsArray(fileWriter);

        List<User> users;
        if (file.length() != 0) {
            // Reading data from the JSON
            users = Arrays.asList(mapper.readValue(file, User[].class));

            // Deleting file contents
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(path));
            writer.write("");
            writer.flush();

            // This cycle is needed in order to not write multiple same objects
            boolean isSameUserFound = false;
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getNickname().equals(this.nickname)) {
                    users.set(i, this);
                    isSameUserFound = true;
                    break;
                }
            }
            if (!isSameUserFound) {
                seqWriter.write(this);
            }
            // Writing our previously read json data back to the file
            seqWriter.writeAll(users);
        } else {
            // Writing only one our user as the file is empty
            seqWriter.write(this);
        }
        seqWriter.close();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return rating == user.rating && Objects.equals(nickname, user.nickname) && Objects.equals(answers, user.answers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, rating, answers);
    }

    public String toString() {
        return nickname + "\t\t" + rating + "\n" + getAnswers();
    }
}
