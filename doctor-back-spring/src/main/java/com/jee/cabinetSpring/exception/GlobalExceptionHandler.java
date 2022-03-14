package com.jee.cabinetSpring.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    //@ExceptionHandler : pour spécifier la classe d'exception
    @ExceptionHandler(ResourceNotFound.class)
    //ResponseEntity<?> : retour de ResponseEntity de n'importe qu'elle type
    public ResponseEntity<?> not_found(ResourceNotFound ex){
        Responce res = new Responce(ex.getMessage());
        return ResponseEntity.ok().body(res);
    }

    //si l'exception n'est pas traiter dans cette classe alors cette exception va etre soulever
    @ExceptionHandler(Exception.class)
    public  ResponseEntity<?> not_found(Exception ex){
        return ResponseEntity.internalServerError().body("Internal server Error");
    }
}
