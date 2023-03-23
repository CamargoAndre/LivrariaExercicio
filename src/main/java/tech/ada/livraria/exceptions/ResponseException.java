package tech.ada.livraria.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResponseException {
    private String message;
}
