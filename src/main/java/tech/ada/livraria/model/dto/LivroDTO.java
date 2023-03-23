package tech.ada.livraria.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LivroDTO {

    private Long id;
    @NotBlank(message = "O nome é obrigatorio")
    private String nome;
    @NotBlank(message = "O isbn é obrigatorio")
    @Size(max = 13, min = 13)
    private String isbn;
    private String autor;

}
