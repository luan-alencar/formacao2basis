package com.basis.campina.xtarefas.service.feign;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface DocumentClient {

    @GetMapping("api/documents")
    ResponseEntity<String> getString();
}
