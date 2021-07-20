package com.basis.campina.xtarefas.service.mapper;


import com.basis.campina.xtarefas.domain.Responsavel;
import com.basis.campina.xtarefas.service.dto.ResponsavelDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface ResponsavelMapper extends EntityMapper<ResponsavelDTO, Responsavel> {

    @Override
    Responsavel toEntity(ResponsavelDTO dto);

    @Override
    ResponsavelDTO toDTO(Responsavel entity);

    @Override
    List<Responsavel> toEntity(List<ResponsavelDTO> dtoList);

    @Override
    List<ResponsavelDTO> toDTO(List<Responsavel> entityList);
}
