package org.Ideyalabs.CabBooking.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.Ideyalabs.CabBooking.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Arrays;

public class AppGlobalExceptionHandler {
    @ExceptionHandler(CustomerByIdDoesNotExistException.class)
    public ResponseEntity<?> customerByIdDoesNotExistException(
            CustomerByIdDoesNotExistException e ,
            HttpServletRequest request){
        ApiError apiError = ApiError.builder()
                .path(request.getRequestURI())
                .message(Arrays.asList(e.getLocalizedMessage()))
                .when(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);



    }
    @ExceptionHandler(UpdateUserByIdDoesNotExistException.class)
    public ResponseEntity<?> updateByIdDoesNotExistExceptionHandler
            (UpdateUserByIdDoesNotExistException e ,
             HttpServletRequest request){
        ApiError apiError = ApiError.builder()
                .path(request.getRequestURI())
                .message(Arrays.asList(e.getLocalizedMessage()))
                .when(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UserByIdDoesNotExistException.class)
    public ResponseEntity<?> userIdDoesNotExistExceptionHandler
            (UserByIdDoesNotExistException e,
             HttpServletRequest request) {

        ApiError apiError = ApiError.builder()
                .path(request.getRequestURI())
                .message(Arrays.asList(e.getLocalizedMessage()))
                .when(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }
}
