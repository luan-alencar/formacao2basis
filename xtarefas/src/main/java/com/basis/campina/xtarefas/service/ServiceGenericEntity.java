package com.basis.campina.xtarefas.service;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface ServiceGenericEntity<T, X> {

    List<T> buscarTodos();

    X salvar(T entity);

    void delete(T entity);

    T buscarPorId(Integer id);

    X atualizar(T id);
}
