package com.basis.campina.xtarefas.repository.elastic;

import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Reindexer {

    <T> Page<T> reindexPage(Pageable pageable);

    @SneakyThrows
    default String getEntity() {
        throw new IllegalAccessException("Metodo nao implementado");
    }
}
