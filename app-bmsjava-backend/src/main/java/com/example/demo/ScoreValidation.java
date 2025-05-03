package com.example.demo;
import java.util.*;
import javax.validation.*;
public class ScoreValidation implements ConstraintValidator<Score, String>{
    List<String> score = Arrays.asList(
        "A+","A","A-",
        "B+","B","B-",
        "C+", "C","C-",
        "D+", "D", "D-",
        "E+", "E", "E-",
        "F"
    );
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context){
        for(int i=0;i < score.size();i++){
            if(value.equals(score.get(i))){
                return true;
            }
        }
        return false;
    }
}