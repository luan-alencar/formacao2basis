package com.basis.campina.xtarefas.service;

import com.basis.campina.xtarefas.domain.elastic.TarefaDocument;
import com.basis.campina.xtarefas.service.dto.TarefaDTO;
import com.basis.campina.xtarefas.service.filter.AnexoFilter;
import com.basis.campina.xtarefas.service.filter.TarefaFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TarefaService extends ServiceGenericEntity<TarefaDTO, TarefaDocument> {

    @Override
    List<TarefaDTO> buscarTodos();

    @Override
    TarefaDTO salvar(TarefaDTO entity);

    @Override
    TarefaDTO atualizar(TarefaDTO id);

    @Override
    TarefaDTO buscarPorId(Integer id);

    @Override
    void delete(Integer entityId);

    Page<TarefaDocument> pesquisar(TarefaFilter filter, Pageable pageable);
}
