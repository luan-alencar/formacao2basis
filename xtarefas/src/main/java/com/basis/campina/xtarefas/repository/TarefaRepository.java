package com.basis.campina.xtarefas.repository;

import com.basis.campina.xtarefas.domain.Tarefa;
import com.basis.campina.xtarefas.domain.elastic.ResponsavelDocument;
import com.basis.campina.xtarefas.domain.elastic.TarefaDocument;
import com.basis.campina.xtarefas.repository.elastic.Reindexer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Integer>, Reindexer {

    @Query("SELECT new com.basis.campina.xtarefas.domain.elastic.TarefaDocument(" +
            " t.id, t.nome, t.dataConclusao, t.dataInicio, t.status, t.responsavel) FROM Tarefa t ORDER BY t.id")
    Page<TarefaDocument> reindexPage(Pageable pageable);

    @Query("SELECT new com.basis.campina.xtarefas.domain.elastic.TarefaDocument(" +
            " t.id, t.nome, t.dataConclusao, t.dataInicio, t.status, t.responsavel) FROM Tarefa t WHERE t.id = :id")
    TarefaDocument getDocument(@Param("id") Integer id);

    @Override
    default String getEntity() {
        return "tarefa";
    }

}