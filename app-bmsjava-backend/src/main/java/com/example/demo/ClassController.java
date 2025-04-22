package com.example.demo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;
@RestController
public class ClassController{
    List<Grade> grades = new ArrayList<>();
    public ClassController() {
        grades.add(new Grade("Harry", "Maths", "C-"));
        grades.add(new Grade("Rocky", "Science", "A-"));
        grades.add(new Grade("Chilly", "English", "A+"));
    }
    @GetMapping("/grades")
    public List<Grade> Grades(){
        // model.addAttribute("grades",grades);
        return grades;
    }

    @GetMapping("/gradesById")
    public ResponseEntity<?> GradeByID(@RequestParam(required=false) String id){
        for(Grade grade : grades){
            if(grade.getID().equals(id)){
                return ResponseEntity.ok(grade);
            }
        }
        Map<String,Object> errorResponse = new HashMap<>();
        errorResponse.put("status",404);
        errorResponse.put("message","Grade not found with id: " + id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}