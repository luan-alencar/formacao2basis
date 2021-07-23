package com.basis.campina.xtarefas.service.impl;

import com.basis.campina.xtarefas.domain.Tarefa;
import com.basis.campina.xtarefas.domain.elastic.TarefaDocument;
import com.basis.campina.xtarefas.repository.TarefaRepository;
import com.basis.campina.xtarefas.repository.elastic.TarefaSearchRepository;
import com.basis.campina.xtarefas.service.TarefaService;
import com.basis.campina.xtarefas.service.dto.TarefaDTO;
import com.basis.campina.xtarefas.service.filter.TarefaFilter;
import com.basis.campina.xtarefas.service.mapper.TarefaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TarefaServiceImpl implements TarefaService {

    private final TarefaRepository respository;
    private final TarefaMapper mapper;
    private final TarefaSearchRepository searchRepository;

    @Override
    public List<TarefaDTO> buscarTodos() {
        return mapper.toDTO(respository.findAll());
    }

    @Override
    public TarefaDTO salvar(TarefaDTO entity) {
        Tarefa entidade = respository.save(mapper.toEntity(entity));
        return mapper.toDTO(entidade);
    }

    @Override
    public TarefaDTO atualizar(TarefaDTO entity) {
        return this.salvar(entity);
    }

    @Override
    public TarefaDTO buscarPorId(Integer id) {
        return mapper.toDTO(respository.findById(id).get());
    }

    @Override
    public void delete(Integer entityId) {
        respository.deleteById(entityId);
    }

    @Override
    public Page<TarefaDocument> pesquisar(TarefaFilter filter, Pageable pageable) {
        return searchRepository.search(filter.getFilter(), pageable);
    }
}
