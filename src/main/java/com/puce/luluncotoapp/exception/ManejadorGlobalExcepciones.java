package com.puce.luluncotoapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ManejadorGlobalExcepciones {

    @ExceptionHandler(UsuarioNoEncontradoException.class)
    public ResponseEntity<RespuestaError> manejarUsuarioNoEncontrado(UsuarioNoEncontradoException excepcion) {
        RespuestaError error = new RespuestaError(HttpStatus.NOT_FOUND.value(), excepcion.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ContrasenaIncorrectaException.class)
    public ResponseEntity<RespuestaError> manejarContrasenaIncorrecta(ContrasenaIncorrectaException excepcion) {
        RespuestaError error = new RespuestaError(HttpStatus.UNAUTHORIZED.value(), excepcion.getMessage());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(RegistroDuplicadoException.class)
    public ResponseEntity<RespuestaError> manejarRegistroDuplicado(RegistroDuplicadoException excepcion) {
        RespuestaError error = new RespuestaError(HttpStatus.CONFLICT.value(), excepcion.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(RecursoNoEncontradoException.class)
    public ResponseEntity<RespuestaError> manejarRecursoNoEncontrado(RecursoNoEncontradoException excepcion) {
        RespuestaError error = new RespuestaError(HttpStatus.NOT_FOUND.value(), excepcion.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AccesoDenegadoException.class)
    public ResponseEntity<RespuestaError> manejarAccesoDenegado(AccesoDenegadoException excepcion) {
        RespuestaError error = new RespuestaError(HttpStatus.FORBIDDEN.value(), excepcion.getMessage());
        return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RespuestaError> manejarExcepcionGeneral(Exception excepcion) {
        RespuestaError error = new RespuestaError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error interno del servidor");
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
