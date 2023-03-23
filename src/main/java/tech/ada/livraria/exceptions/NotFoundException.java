package tech.ada.livraria.exceptions;


import tech.ada.livraria.utils.MenssageUtils;

public class NotFoundException extends RuntimeException{
    public NotFoundException(){
        super(MenssageUtils.NOT_FOUND_ID);
    }



}
