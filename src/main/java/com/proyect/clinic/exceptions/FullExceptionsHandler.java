package com.proyect.clinic.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class FullExceptionsHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundExeption(ResourceNotFoundException exept,
                                                      WebRequest request)
    {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ErrorDeleteDentistOrPatientException.class)
    public ResponseEntity<?> errorDeleteDentistExeption(ErrorDeleteDentistOrPatientException
                                                                    exep, WebRequest request)
    {
        return new ResponseEntity<>("No se puede elimiar este odontologo " +
                "ya que posee turnos asignados.", HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
