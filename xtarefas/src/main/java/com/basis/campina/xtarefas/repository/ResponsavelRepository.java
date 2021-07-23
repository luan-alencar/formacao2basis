package com.basis.campina.xtarefas.repository;

import com.basis.campina.xtarefas.domain.Responsavel;
import com.basis.campina.xtarefas.domain.elastic.ResponsavelDocument;
import com.basis.campina.xtarefas.repository.elastic.Reindexer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Integer>, Reindexer {

    @Query("SELECT new com.basis.campina.xtarefas.domain.elastic.ResponsavelDocument(" +
            " r.id, r.nome,  r.email, r.dataNascimento) FROM Responsavel r WHERE r.id = :id")
    Page<ResponsavelDocument> reindexPage(Pageable pageable);

    @Query("SELECT new com.basis.campina.xtarefas.domain.elastic.ResponsavelDocument(" +
            " r.id, r.nome,  r.email, r.dataNascimento) FROM Responsavel r ORDER BY r.id")
    ResponsavelDocument getDocument(@Param("id") Integer id);

    @Override
    default String getEntity() {
        return "responsavel";
    }
}