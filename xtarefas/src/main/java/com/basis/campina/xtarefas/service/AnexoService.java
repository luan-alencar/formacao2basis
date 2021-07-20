package com.basis.campina.xtarefas.service;

import com.basis.campina.xtarefas.service.dto.AnexoDTO;

import java.util.List;

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
    void delete(AnexoDTO entity);
}
