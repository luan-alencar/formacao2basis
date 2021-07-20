package com.basis.campina.xtarefas.service;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public interface ServiceGenericEntity<D> {

    List<D> buscarTodos();

    D salvar(D entity);

    D atualizar(D id);

    D buscarPorId(Integer id);

    void delete(Integer entityId);
}
