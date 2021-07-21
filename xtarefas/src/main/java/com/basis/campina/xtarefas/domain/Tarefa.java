package com.basis.campina.xtarefas.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "TB_TAREFA")
@Entity
@Getter
@Setter
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ANEXO")
    @SequenceGenerator(name = "SQ_ANEXO", allocationSize = 1, sequenceName = "SQ_ANEXO")
    private Integer id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DATA_INICIO")
    private LocalDateTime dataInicio;

    @Column(name = "DATA_CONCLUSAO")
    private LocalDateTime dataConclusao;

    @Column(name = "STATUS")
    private Boolean status;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "ANEXO")
    @Column(name = "ID_ANEXO")
    private List<Anexo> idAnexo;

    @Column(name = "ID_RESPONSAVEL")
    @OneToOne(cascade = CascadeType.ALL)
    private Responsavel idResponsavel;

}
