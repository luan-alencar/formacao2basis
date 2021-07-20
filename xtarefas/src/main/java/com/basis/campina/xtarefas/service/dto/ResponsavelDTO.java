package com.basis.campina.xtarefas.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
