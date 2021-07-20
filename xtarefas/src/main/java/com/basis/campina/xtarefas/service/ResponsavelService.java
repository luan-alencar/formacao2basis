package com.basis.campina.xtarefas.service;

import com.basis.campina.xtarefas.service.dto.ResponsavelDTO;

import java.util.List;

public interface ResponsavelService extends ServiceGenericEntity<ResponsavelDTO> {

    @Override
    List<ResponsavelDTO> buscarTodos();

    @Override
    ResponsavelDTO salvar(ResponsavelDTO entity);

    @Override
    ResponsavelDTO atualizar(ResponsavelDTO id);

    @Override
    ResponsavelDTO buscarPorId(Integer id);

    @Override
    void delete(ResponsavelDTO entity);
}
