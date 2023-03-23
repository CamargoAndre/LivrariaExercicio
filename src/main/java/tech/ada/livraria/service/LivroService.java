package tech.ada.livraria.service;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.ada.livraria.exceptions.BusinessException;
import tech.ada.livraria.exceptions.NotFoundException;
import tech.ada.livraria.model.dto.LivroDTO;
import tech.ada.livraria.model.entity.LivroEntity;
import tech.ada.livraria.model.mapper.LivroMapper;
import tech.ada.livraria.repository.LivroRepository;
import tech.ada.livraria.utils.MenssageUtils;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    @Autowired
    private LivroRepository repository;
    @Autowired
    private LivroMapper mapper;

    @Transactional
    public LivroDTO save(LivroDTO dto) {

        Optional<LivroEntity> optional = repository.findByNome(dto.getNome());
        if(optional.isPresent()){
           throw new BusinessException(MenssageUtils.LIVRO_EXIST);
        }
        LivroEntity entity = mapper.toEntity(dto);
        repository.save(entity);
        return mapper.toDto(entity);
    }

    @Transactional
    public LivroDTO update(LivroDTO dto) {

        this.findById(dto.getId());
        Optional<LivroEntity> optional = repository.findByUpdate(dto.getNome(), dto.getId());
        if(optional.isPresent()){
            throw new BusinessException(MenssageUtils.LIVRO_EXIST);
        }
        LivroEntity entity = mapper.toEntity(dto);
        repository.save(entity);
        return mapper.toDto(entity);
    }
    @Transactional(readOnly = true)
    public List<LivroDTO> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Transactional(readOnly = true)
    public LivroDTO findById(Long id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow(NotFoundException::new);
    }


    public LivroDTO delete(Long id) {
        LivroDTO dto = this.findById(id);
        repository.deleteById(id);
        return dto;
    }
}
