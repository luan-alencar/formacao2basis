package com.basis.campina.xtarefas.service.dto;

import com.basis.campina.xtarefas.domain.Anexo;
import com.basis.campina.xtarefas.domain.Responsavel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "TB_TAREFA")
@Entity
@Getter
@Setter
public class TarefaDTO {

    private Integer id;

    private String nome;

    private LocalDateTime dataInicio;

    private LocalDateTime dataConclusao;

    private Boolean status;

    private List<Anexo> idAnexo;

    private Responsavel idResponsavel;

}
