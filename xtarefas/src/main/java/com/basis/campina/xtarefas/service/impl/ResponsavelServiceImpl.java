package com.basis.campina.xtarefas.service.impl;

import com.basis.campina.xtarefas.domain.Responsavel;
import com.basis.campina.xtarefas.repository.ResponsavelRepository;
import com.basis.campina.xtarefas.service.ResponsavelService;
import com.basis.campina.xtarefas.service.dto.ResponsavelDTO;
import com.basis.campina.xtarefas.service.mapper.ResponsavelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ResponsavelServiceImpl implements ResponsavelService {

    private final ResponsavelRepository respository;
    private final ResponsavelMapper mapper;

    @Override
    public List<ResponsavelDTO> buscarTodos() {
        return mapper.toDTO(respository.findAll());
    }

    @Override
    public ResponsavelDTO salvar(ResponsavelDTO entity) {
        Responsavel responsavel = respository.save(mapper.toEntity(entity));
        return mapper.toDTO(responsavel);
    }

    @Override
    public ResponsavelDTO atualizar(ResponsavelDTO entity) {
        return this.salvar(entity);
    }

    @Override
    public ResponsavelDTO buscarPorId(Integer id) {
        return mapper.toDTO(respository.findById(id).get());
    }

    @Override
    public void delete(Integer entityId) {
        respository.deleteById(entityId);
    }
}
