package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Question {

    String questionquiz;
    String answer;

    private String arrayquestion[];
    private String arrayanswer[];

    public String getQuestionquiz() {
        return questionquiz;
    }

    public void setQuestionquiz(String questionquiz) {
        this.questionquiz = questionquiz;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Question(String questionquiz, String answer) {
        this.questionquiz = questionquiz;
        this.answer = answer;
    }

    public void saveToFile(String path) throws IOException {
        File file = new File(path);
        FileWriter fileWriter = new FileWriter(file, true);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        SequenceWriter seqWriter = mapper.writer().writeValuesAsArray(fileWriter);

        List<Question> questions;
        if (file.length() != 0) {
            // Reading data from the JSON
            questions = Arrays.asList(mapper.readValue(file, Question[].class));

            // Deleting file contents
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(path));
            writer.write("");
            writer.flush();

            // This cycle is needed in order to not write multiple same objects
            boolean isSameQuestionFound = false;
            for (int i = 0; i < question.size(); i++) {
                if (questions.get(i).getQuestionquiz().equals(this.questionquiz)) {
                    questions.set(i, this);
                    isSameQuestionFound = true;
                    break;
                }
            }
            if (!isSameQuestionFound) {
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

}

