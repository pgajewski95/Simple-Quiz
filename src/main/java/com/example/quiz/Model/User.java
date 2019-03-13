package com.example.quiz.Model;

public class User {

    private Integer numberOfPoints;

    public User(){
        numberOfPoints = 0;

    }

    public void addPoints(){

        numberOfPoints++;
    }

    public Integer getNumberOfPoints() {
        return numberOfPoints;
    }
}
