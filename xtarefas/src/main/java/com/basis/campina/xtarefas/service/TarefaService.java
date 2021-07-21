package com.basis.campina.xtarefas.service;

import com.basis.campina.xtarefas.service.dto.TarefaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TarefaService extends ServiceGenericEntity<TarefaDTO> {

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
}
