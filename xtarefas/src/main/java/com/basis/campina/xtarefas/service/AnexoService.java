package com.basis.campina.xtarefas.service;

import com.basis.campina.xtarefas.domain.elastic.AnexoDocument;
import com.basis.campina.xtarefas.service.dto.AnexoDTO;
import com.basis.campina.xtarefas.service.filter.AnexoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface AnexoService extends ServiceGenericEntity<AnexoDTO, AnexoDocument> {

    @Override
    List<AnexoDTO> buscarTodos();

    @Override
    AnexoDTO salvar(AnexoDTO entity);

    @Override
    AnexoDTO atualizar(AnexoDTO id);

    @Override
    AnexoDTO buscarPorId(Integer id);

    @Override
    void delete(Integer entityId);

    Page<AnexoDocument> pesquisar(AnexoFilter filter, Pageable pageable);
}
