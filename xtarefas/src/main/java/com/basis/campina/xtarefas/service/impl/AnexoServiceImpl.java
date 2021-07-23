package com.basis.campina.xtarefas.service.impl;

import com.basis.campina.xtarefas.domain.Anexo;
import com.basis.campina.xtarefas.domain.elastic.AnexoDocument;
import com.basis.campina.xtarefas.repository.AnexoRepository;
import com.basis.campina.xtarefas.repository.elastic.AnexoSearchRepository;
import com.basis.campina.xtarefas.service.AnexoService;
import com.basis.campina.xtarefas.service.dto.AnexoDTO;
import com.basis.campina.xtarefas.service.filter.AnexoFilter;
import com.basis.campina.xtarefas.service.mapper.AnexoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AnexoServiceImpl implements AnexoService {

    private final AnexoRepository respository;
    private final AnexoMapper mapper;
    private final AnexoSearchRepository searchRepository;

    @Override
    public List<AnexoDTO> buscarTodos() {
        return mapper.toDTO(respository.findAll());
    }

    @Override
    public AnexoDTO salvar(AnexoDTO entity) {
        Anexo entidade = respository.save(mapper.toEntity(entity));
        return mapper.toDTO(entidade);
    }

    @Override
    public AnexoDTO atualizar(AnexoDTO entity) {
        return this.salvar(entity);
    }

    @Override
    public AnexoDTO buscarPorId(Integer id) {
        return mapper.toDTO(respository.findById(id).get());
    }

    @Override
    public void delete(Integer entityId) {
        respository.deleteById(entityId);
    }

    @Override
    public Page<AnexoDocument> pesquisar(AnexoFilter filter, Pageable pageable) {
        return searchRepository.search(filter.getFilter(), pageable);
    }
}
