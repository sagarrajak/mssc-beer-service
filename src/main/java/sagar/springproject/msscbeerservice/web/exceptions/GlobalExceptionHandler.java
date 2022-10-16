package sagar.springproject.msscbeerservice.web.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;


@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException constraintViolationException) {
        List<String> arrayList = new ArrayList<>();
        constraintViolationException.getConstraintViolations().forEach(constraintViolation -> {
            arrayList.add(constraintViolation.getPropertyPath()+ " : "+constraintViolation.getMessage());
        });
        return new ResponseEntity(arrayList, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<List>  onMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {
        List<String> arrayList = new ArrayList<>();
        e.getBindingResult().getFieldErrors().forEach(fieldError -> {
            arrayList.add(fieldError.getField() +" : "+fieldError.getDefaultMessage());
        });
        e.getBindingResult().getGlobalErrors().forEach(objectError -> {
            arrayList.add(objectError.getObjectName()+" : "+objectError.getDefaultMessage());
        });

        return new ResponseEntity(arrayList, HttpStatus.BAD_REQUEST);
    }
}
