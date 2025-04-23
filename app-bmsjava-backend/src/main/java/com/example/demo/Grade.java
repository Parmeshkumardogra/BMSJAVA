package com.example.demo;
import java.util.*;
public class Grade{

    private String name;
    private String subject;
    private String score;
    private String id;

    public Grade(String name, String subject, String score){
        this.id=UUID.randomUUID().toString();
        this.name=name;
        this.subject=subject;
        this.score=score;
    }
    public Grade(Grade source){
        this.id=source.id;
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
    public String getID(){
        return this.id;
    }
    @Override
    public String toString() {
        return "Grade{" +
            "name='" + name + '\'' +
            ", subject='" + subject + '\'' +
            ", score='" + score + '\'' +
            ", id='" + id + '\'' +
            '}';
    }
}