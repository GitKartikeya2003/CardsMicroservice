package com.example.Cards.exception;


import com.example.Cards.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

import static java.time.LocalTime.now;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> GlobalExceptionHandler(Exception exception,
                                                                   WebRequest webRequest) {

        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                webRequest.getDescription(false),   //this is to only get the api path if i would have set
                // it to true, then we will get more information that
                // is not needed right now.....
                HttpStatus.NOT_FOUND,
                exception.getMessage(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);

    }


    public ResponseEntity<ErrorResponseDto> handleCardAlreadyExistsException(CardAlreadyExistsException exception, WebRequest webRequest) {
        ErrorResponseDto responseDto = new ErrorResponseDto(webRequest.getDescription(false),   //this is to only get the api path if i would have set
                // it to true, then we will get more information that
                // is not needed right now.....
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                LocalDateTime.now());

        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {
        ErrorResponseDto responseDto = new ErrorResponseDto(webRequest.getDescription(false),   //this is to only get the api path if i would have set
                // it to true, then we will get more information that
                // is not needed right now.....
                HttpStatus.NOT_FOUND,
                exception.getMessage(),
                LocalDateTime.now());

        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }

}
