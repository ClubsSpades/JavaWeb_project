package com.kk.entity;

import java.util.List;

public class Question {
    private int id;
    private String question;
    private List<Option> options;

    // getter ºÍ setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }

    public List<Option> getOptions() { return options; }
    public void setOptions(List<Option> options) { this.options = options; }
}
