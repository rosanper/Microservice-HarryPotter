package com.letscode.microservicoharrypotter.repositories;

import com.letscode.microservicoharrypotter.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno,Integer> {
    Optional<Aluno> findByNome(String nome);

    Optional<Aluno> findByChaveDaCasaSeletora(String chave);

}
