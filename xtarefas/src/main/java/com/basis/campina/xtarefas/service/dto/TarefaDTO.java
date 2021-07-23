package com.basis.campina.xtarefas.service.dto;

import com.basis.campina.xtarefas.domain.Responsavel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class TarefaDTO {

    private Integer id;

    private String nome;

    private LocalDateTime dataInicio;

    private LocalDateTime dataConclusao;

    private Boolean status;

    private Responsavel responsavel;

    private List<AnexoDTO> anexos;

}
