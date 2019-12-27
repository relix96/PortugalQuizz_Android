package com.uni.portugalquizz.Classes;

public class Answer {

    private int id_Answer;
    private String name_Answer;
    private int isCorrect;

    public Answer(int id_Question, String name_question, int isCorrect) {
        this.id_Answer = id_Question;
        this.name_Answer = name_question;
        this.isCorrect = isCorrect;
    }

    public Answer() {

    }

    public int getId_Answer() {
        return id_Answer;
    }

    public void setId_Answer(int id_Answer) {
        this.id_Answer = id_Answer;
    }

    public String getName_Answer() {
        return name_Answer;
    }

    public void setName_Answer(String name_Answer) {
        this.name_Answer = name_Answer;
    }

    public int isCorrect() {
        return isCorrect;
    }

    public void setIdCorrect(int idCorrect) {
        this.isCorrect = idCorrect;
    }


}
