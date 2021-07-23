package com.basis.campina.xtarefas.service;

import com.basis.campina.xtarefas.domain.elastic.ResponsavelDocument;
import com.basis.campina.xtarefas.service.dto.ResponsavelDTO;
import com.basis.campina.xtarefas.service.filter.AnexoFilter;
import com.basis.campina.xtarefas.service.filter.ResponsavelFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface ResponsavelService extends ServiceGenericEntity<ResponsavelDTO, ResponsavelDocument> {

    @Override
    List<ResponsavelDTO> buscarTodos();

    @Override
    ResponsavelDTO salvar(ResponsavelDTO entity);

    @Override
    ResponsavelDTO atualizar(ResponsavelDTO entity);

    @Override
    ResponsavelDTO buscarPorId(Integer id);

    @Override
    void delete(Integer entity);

    Page<ResponsavelDocument> pesquisar(ResponsavelFilter filter, Pageable pageable);
}
