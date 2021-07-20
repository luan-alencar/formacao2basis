package com.basis.campina.xtarefas.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "TB_ANEXO")
@Entity
@Getter
@Setter
public class Anexo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ANEXO")
    @SequenceGenerator(name = "SQ_ANEXO", allocationSize = 1, sequenceName = "SQ_ANEXO")
    private Integer id;

    @Column(name = "FILE")
    private String file;

    @Column(name = "FILENAME")
    private String filename;

    @ManyToOne
    @JoinColumn(name = "idAnexo")
    private Tarefa tarefa;
}
