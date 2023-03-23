package tech.ada.livraria.exceptions;

public class BusinessException extends RuntimeException{

    public BusinessException(String message){
        super(message);
    }
}
