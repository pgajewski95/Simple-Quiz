package com.example.quiz.Model;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String content;

    private Boolean correct;
    @ManyToOne
    public Test test;

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
    public Question(){}

    public Question(String content, Boolean correct) {
        this.content = content;
        this.correct = correct;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }
}
