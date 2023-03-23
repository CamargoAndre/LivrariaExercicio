package tech.ada.livraria.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "livro")
public class LivroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome", unique = true, nullable = false)
    private String nome;
    @Column(name = "isbn", unique = true, nullable = false)
    private String isbn;
    @Column(name = "autor")
    private String autor;
}
