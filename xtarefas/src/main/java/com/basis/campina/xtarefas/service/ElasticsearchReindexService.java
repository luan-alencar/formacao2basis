package com.basis.campina.xtarefas.service;

public interface ElasticsearchReindexService<E> {

    void reindex(E event);
}
