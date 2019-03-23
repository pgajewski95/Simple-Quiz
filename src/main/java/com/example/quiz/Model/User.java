package com.example.quiz.Model;

public class User {

    private Integer numberOfPoints;

    private String login;

    private String passoword;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {

        this.login = login;

    }

    public String getPassoword() {
        return passoword;
    }

    public void setPassoword(String passoword) {

        this.passoword = passoword;


    }

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
