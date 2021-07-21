package com.basis.campina.xtarefas.service;

import com.basis.campina.xtarefas.service.dto.AnexoDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface AnexoService extends ServiceGenericEntity<AnexoDTO> {

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
}
