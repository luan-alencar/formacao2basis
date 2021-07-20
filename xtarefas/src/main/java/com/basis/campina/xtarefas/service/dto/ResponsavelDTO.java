package com.basis.campina.xtarefas.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ResponsavelDTO {

    private Integer id;

    private String nome;

    private LocalDate dataNascimento;

    private String email;

}
