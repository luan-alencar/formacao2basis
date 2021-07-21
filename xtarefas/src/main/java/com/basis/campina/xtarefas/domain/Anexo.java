package com.basis.campina.xtarefas.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "tb_anexo")
@Entity
@Getter
@Setter
public class Anexo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_anexo")
    @SequenceGenerator(name = "sq_anexo", allocationSize = 1, sequenceName = "sq_anexo")
    private Integer id;

    @Column(name = "file")
    private String file;

    @Column(name = "filename")
    private String filename;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tarefa", nullable = false)
    private Tarefa tarefa;
}
