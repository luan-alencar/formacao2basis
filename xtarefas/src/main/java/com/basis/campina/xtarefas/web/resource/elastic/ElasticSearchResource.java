package com.basis.campina.xtarefas.web.resource.elastic;

import com.basis.campina.xtarefas.service.elastic.ElasticSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/elasticsearch/reindex")
public class ElasticSearchResource {

    private final ElasticSearchService service;

    @GetMapping
    public ResponseEntity<String> reindex() {
        return ResponseEntity.ok("Reindexando todo o ElasticSearch");
    }

    @GetMapping("/{entity}")
    public ResponseEntity<String> reindex(@PathVariable("entity") String entity) {
        return ResponseEntity.ok("Reindexando o ElasticSearch");
    }
}
