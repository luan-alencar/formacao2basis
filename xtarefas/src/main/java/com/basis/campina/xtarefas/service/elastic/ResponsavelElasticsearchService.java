package com.basis.campina.xtarefas.service.elastic;

import com.basis.campina.xtarefas.repository.elastic.ResponsavelRepositorySearch;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ResponsavelElasticsearchService {

    private final ResponsavelRepositorySearch repositorySearch;
}
