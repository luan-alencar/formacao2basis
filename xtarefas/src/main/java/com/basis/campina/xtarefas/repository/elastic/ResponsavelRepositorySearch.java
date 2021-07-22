package com.basis.campina.xtarefas.repository.elastic;

import com.basis.campina.xtarefas.domain.elastic.ResponsavelDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ResponsavelRepositorySearch extends ElasticsearchRepository<ResponsavelDocument, Integer> {

}
