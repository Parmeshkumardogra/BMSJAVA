package com.example.demo;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.BindingResult;
import java.util.stream.Collectors;
import javax.validation.Valid;
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
    @PostMapping("/gradeForm")
    public ResponseEntity<?> addGrade(@Valid @RequestBody Grade requestedData, BindingResult result){
        System.out.println("Received Grade object: " + requestedData.toString());
        System.out.println("Result binding status "+ result.hasErrors());
        if(result.hasErrors()){
            System.out.println("Inside has error condition!!");
            Map<String,String> errors = result.getFieldErrors().stream().collect(Collectors.toMap(
                FieldError::getField, // Use FieldError::getField
                FieldError::getDefaultMessage
            ));
            return ResponseEntity.badRequest().body(errors);
        }
        // Map<String,Object> errors = new HashMap<>();
        // if (requestedData.getName() == null || requestedData.getName().trim().isEmpty()) {
        //     errors.put("name", "Name cannot be blank");
        // }
        // if (requestedData.getSubject() == null || requestedData.getSubject().trim().isEmpty()) {
        //     errors.put("subject", "Subject cannot be blank");
        // }
        // if (requestedData.getScore() == null || requestedData.getScore().trim().isEmpty()) {
        //     errors.put("score", "Score cannot be blank");
        // }
        // if(!errors.isEmpty()){
        //     errors.put("statusCode",400);
        //     errors.put("message","bad request");
        //     return ResponseEntity.badRequest().body(errors);
        // }
        grades.add(requestedData);
        return ResponseEntity.ok(requestedData);
    }
}