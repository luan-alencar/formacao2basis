package com.basis.campina.xtarefas.repository.elastic;

import com.basis.campina.xtarefas.domain.elastic.ResponsavelDocument;

public interface ResponsavelSearchRepository extends ElasticEntity<ResponsavelDocument, Integer> {

    @Override
    default Class<ResponsavelDocument> getEntityClass() {
        return ResponsavelDocument.class;
    }
}
