package tech.ada.livraria.model.mapper;

import org.springframework.stereotype.Component;
import tech.ada.livraria.model.dto.LivroDTO;
import tech.ada.livraria.model.entity.LivroEntity;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LivroMapper {
    public LivroEntity toEntity(LivroDTO dto) {

        LivroEntity entity = new LivroEntity();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setIsbn(dto.getIsbn());
        entity.setAutor(dto.getAutor());
        return entity;
    }

    public LivroDTO toDto(LivroEntity entity) {
        LivroDTO dto = new LivroDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setIsbn(entity.getIsbn());
        dto.setAutor(entity.getAutor());
        return dto;
    }

    public List<LivroDTO> toDto(List<LivroEntity> entities){
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
