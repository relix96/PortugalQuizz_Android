package com.uni.portugalquizz.Classes;

import java.util.List;

public class Question {

    private long id;
    private String name_question;
    private List<Answer> answers;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName_question() {
        return name_question;
    }

    public void setName_question(String name_question) {
        this.name_question = name_question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }


    public Question(long id, String name_question, List<Answer> answers) {
        this.id = id;
        this.name_question = name_question;
        this.answers = answers;
    }

    public Question(long id, String name_question) {
        this.id = id;
        this.name_question = name_question;
    }

    public Question() {

    }
}
