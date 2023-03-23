package tech.ada.livraria.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import tech.ada.livraria.model.dto.LivroDTO;
import tech.ada.livraria.service.LivroService;

import java.util.List;

@RestController
@RequestMapping(value ="/livro")
public class LivroController {
    @Autowired
    private LivroService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LivroDTO> save(@Valid @RequestBody LivroDTO dto){
        return ResponseEntity.ok(service.save(dto));
    }
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LivroDTO> update(@Valid @RequestBody LivroDTO dto){
        return ResponseEntity.ok(service.update(dto));
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LivroDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LivroDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LivroDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }


}
