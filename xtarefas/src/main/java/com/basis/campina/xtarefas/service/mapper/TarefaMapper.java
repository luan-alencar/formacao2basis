package com.basis.campina.xtarefas.service.mapper;


import com.basis.campina.xtarefas.domain.Anexo;
import com.basis.campina.xtarefas.domain.Tarefa;
import com.basis.campina.xtarefas.service.dto.AnexoDTO;
import com.basis.campina.xtarefas.service.dto.TarefaDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface TarefaMapper extends EntityMapper<TarefaDTO, Tarefa> {

    @Override
    Tarefa toEntity(TarefaDTO dto);

    @Override
    TarefaDTO toDTO(Tarefa entity);

    @Override
    List<Tarefa> toEntity(List<TarefaDTO> dtoList);

    @Override
    List<TarefaDTO> toDTO(List<Tarefa> entityList);
}
