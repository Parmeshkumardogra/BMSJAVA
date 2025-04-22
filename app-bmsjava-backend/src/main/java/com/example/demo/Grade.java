package com.example.demo;

public class Grade{
    private String name;
    private String subject;
    private String score;

    public Grade(String name, String subject, String score){
        this.name=name;
        this.subject=subject;
        this.score=score;
    }
    public Grade(Grade source){
        this.name=source.name;
        this.subject=source.subject;
        this.score=source.score;
    }
    public String getName(){
        return this.name;
    }
    public String getSubject(){
        return this.subject;
    }
    public String getScore(){
        return this.score;
    }
    public void setName(String newName){
        this.name=newName;
    }
    public void setSubject(String newSubject){
        this.subject=newSubject;
    }
    public void setScore(String newScore){
        this.score=newScore;
    }
}