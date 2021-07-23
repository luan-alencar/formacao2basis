package com.basis.campina.xtarefas.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ResponsavelDTO {

    private Integer id;

    private String nome;

    private LocalDate dataNascimento;

    private String email;

    private List<TarefaDTO> tarefas;

}
