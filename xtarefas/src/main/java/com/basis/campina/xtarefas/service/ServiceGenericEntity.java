package com.basis.campina.xtarefas.service;

import com.basis.campina.xtarefas.service.filter.AnexoFilter;
import com.basis.campina.xtarefas.service.filter.DefaultFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public interface ServiceGenericEntity<D, T> {

    List<D> buscarTodos();

    D salvar(D entity);

    D atualizar(D id);

    D buscarPorId(Integer id);

    void delete(Integer entityId);

}
