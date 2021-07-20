package com.basis.campina.xtarefas.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "xdocumentos", url = "${application.feing.url-documents}")
public interface DocumentClient {

    @GetMapping("api/documents")
    ResponseEntity<String> getString();
}
