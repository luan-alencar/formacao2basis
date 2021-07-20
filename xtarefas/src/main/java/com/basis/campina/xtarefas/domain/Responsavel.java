package com.basis.campina.xtarefas.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDate;

@Table(name = "TB_RESPONSAVEL")
@Entity
@Getter
@Setter
public class Responsavel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_RESPONSAVEL")
    @SequenceGenerator(name = "SQ_RESPONSAVEL", allocationSize = 1, sequenceName = "SQ_RESPONSAVEL")
    private Integer id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

    @Column(name = "EMAIL")
    private String email;

}
