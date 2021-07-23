package com.basis.campina.xtarefas.service.elastic;

import com.basis.campina.xtarefas.domain.elastic.ResponsavelDocument;
import com.basis.campina.xtarefas.repository.ResponsavelRepository;
import com.basis.campina.xtarefas.service.ElasticsearchReindexService;
import com.basis.campina.xtarefas.service.mapper.ResponsavelMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ResponsavelElasticsearchService implements ElasticsearchReindexService<ResponsavelDocument> {

    private final ResponsavelRepository repository;
    private final ResponsavelMapper mapper;


    @Override
    public void reindex(ResponsavelDocument event) {

    }
}
