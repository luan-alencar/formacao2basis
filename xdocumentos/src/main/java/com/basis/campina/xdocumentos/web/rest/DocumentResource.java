package com.basis.campina.xdocumentos.web.rest;

import com.basis.campina.xdocumentos.service.dto.DocumentDTO;
import com.basis.campina.xdocumentos.service.dto.DocumentService;
import lombok.RequiredArgsConstructor;
import org.simpleframework.xml.Path;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/documentos")
public class DocumentResource {

    private final DocumentService service;

    @GetMapping
    public ResponseEntity<DocumentDTO> buscar(@Path("uuid") String uuid) {
        return ResponseEntity.ok(service.buscarDocument(uuid));
    }

    @PostMapping
    public ResponseEntity<String> salvar(@RequestBody DocumentDTO documento) {
        return ResponseEntity.ok(service.salvar(documento));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletar(@PathVariable("uuid") String uuid) {
        service.deletar(uuid);
        return ResponseEntity.ok().build();
    }

}
