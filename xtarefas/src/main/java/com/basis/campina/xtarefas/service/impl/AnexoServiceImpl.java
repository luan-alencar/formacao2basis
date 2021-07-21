package com.basis.campina.xtarefas.service.impl;

import com.basis.campina.xtarefas.domain.Anexo;
import com.basis.campina.xtarefas.repository.AnexoRepository;
import com.basis.campina.xtarefas.service.AnexoService;
import com.basis.campina.xtarefas.service.dto.AnexoDTO;
import com.basis.campina.xtarefas.service.mapper.AnexoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AnexoServiceImpl implements AnexoService {

    private final AnexoRepository respository;
    private final AnexoMapper mapper;

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
}
