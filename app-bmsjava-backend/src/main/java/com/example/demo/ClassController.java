package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
@Controller
public class ClassController{
    @GetMapping("/grades")
    // @ResponseBody
    public String Grades(Model model){
        List<Grade> grades = new ArrayList<>();
        grades.add(new Grade("Harry","Maths","C-"));
        grades.add(new Grade("Rocky","Science","A-"));
        model.addAttribute("grades",grades);
        return "grades";
    }
}