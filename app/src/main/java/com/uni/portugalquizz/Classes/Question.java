package com.uni.portugalquizz.Classes;

public class Question {

    private long id;
    private String name_question;


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

    public Question(long id, String name_question) {
        this.id = id;
        this.name_question = name_question;
    }

    public Question() {

    }
}
