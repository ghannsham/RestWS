package com.spring.security.advice;

import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.core.Ordered;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.spring.security.dto.SpringSecurityResponse;
import com.spring.security.dto.ValidationErrorDto;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class MethodArgumentNotValidExceptionHandler {

    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public SpringSecurityResponse methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<org.springframework.validation.FieldError> fieldErrors = result.getFieldErrors();
        return processFieldErrors(fieldErrors);
    }

    private SpringSecurityResponse processFieldErrors(List<org.springframework.validation.FieldError> fieldErrors) 
    {
        List<ValidationErrorDto> beanValidationsDtos =  fieldErrors.stream()
        .map( fe -> new ValidationErrorDto(fe.getField(), fe.getDefaultMessage()) )
        .collect(Collectors.toList());
        
        SpringSecurityResponse error = new SpringSecurityResponse(BAD_REQUEST, beanValidationsDtos, "validation error");
        return error;
    }
}