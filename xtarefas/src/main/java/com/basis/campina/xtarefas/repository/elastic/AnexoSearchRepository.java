package com.basis.campina.xtarefas.repository.elastic;

import com.basis.campina.xtarefas.domain.elastic.AnexoDocument;

public interface AnexoSearchRepository extends ElasticEntity<AnexoDocument, Integer> {

    @Override
    default Class<AnexoDocument> getEntityClass() {
        return AnexoDocument.class;
    }
}
