package com.basis.campina.xtarefas.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Table(name = "tb_tarefa")
@Entity
@Getter
@Setter
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_tarefa")
    @SequenceGenerator(name = "sq_tarefa", allocationSize = 1, sequenceName = "sq_tarefa")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "data_conclusao")
    private LocalDate dataConclusao;

    @Column(name = "status")
    private Boolean status;

    @OneToMany(mappedBy = "tarefa", cascade = CascadeType.ALL)
    private List<Anexo> anexos;

    @ManyToOne()
    @JoinColumn(name = "`id_responsavel`")
    private Responsavel responsavel;

}
