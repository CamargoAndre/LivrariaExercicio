package tech.ada.livraria.exceptions;

import org.aspectj.lang.annotation.AdviceName;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ResponseException> handlerSecurity(BusinessException e){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ResponseException(e.getMessage()));
    }

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<ResponseException> handlerSecurity(NotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseException(e.getMessage()));
    }
}
