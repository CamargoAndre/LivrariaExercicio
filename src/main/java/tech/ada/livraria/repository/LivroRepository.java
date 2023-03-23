package tech.ada.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tech.ada.livraria.model.entity.LivroEntity;

import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, Long> {
    Optional<LivroEntity> findByNome(String nome);

    @Query("SELECT entity FROM LivroEntity entity WHERE entity.nome = :nome AND entity.id <> :id")
    Optional<LivroEntity> findByUpdate(String nome, Long id);
}
