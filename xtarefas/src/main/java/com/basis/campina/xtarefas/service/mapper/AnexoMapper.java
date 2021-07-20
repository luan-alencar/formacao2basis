package com.basis.campina.xtarefas.service.mapper;


import com.basis.campina.xtarefas.domain.Anexo;
import com.basis.campina.xtarefas.service.dto.AnexoDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface AnexoMapper extends EntityMapper<AnexoDTO, Anexo> {

    @Override
    Anexo toEntity(AnexoDTO dto);

    @Override
    AnexoDTO toDTO(Anexo entity);

    @Override
    List<Anexo> toEntity(List<AnexoDTO> dtoList);

    @Override
    List<AnexoDTO> toDTO(List<Anexo> entityList);
}
