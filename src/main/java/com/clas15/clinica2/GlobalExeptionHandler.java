package com.clas15.clinica2;


import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExeptionHandler {


    private static final Logger logger = Logger.getLogger(GlobalExeptionHandler.class);
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> todosErrores(Exception ex, WebRequest req){

        logger.error(ex.getMessage());
        return new ResponseEntity("error" + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
