package com.example.demo;
import java.lang.annotation.*;
import javax.validation.*;
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ScoreValidation.class)
public @interface Score{
    String message() default "Invalid Data";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
}