package com.basis.campina.xtarefas.service;

import com.basis.campina.xtarefas.service.dto.ResponsavelDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface ResponsavelService extends ServiceGenericEntity<ResponsavelDTO> {

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
}
