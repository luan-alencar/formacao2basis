package com.basis.campina.xtarefas.web.resource;
import com.basis.campina.xtarefas.service.ResponsavelService;
import com.basis.campina.xtarefas.service.dto.ResponsavelDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/responsaveis")
@RequiredArgsConstructor
public class ResponsavelResource {

    private final ResponsavelService service;

    @GetMapping
    public ResponseEntity<List<ResponsavelDTO>> listar() {
        List<ResponsavelDTO> list = service.buscarTodos();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsavelDTO> obterPorId(@PathVariable Integer id) {
        ResponsavelDTO entidadeDTO = service.buscarPorId(id);
        return ResponseEntity.ok(entidadeDTO);
    }

    @PostMapping
    public ResponseEntity<ResponsavelDTO> salvar(@RequestBody ResponsavelDTO entidadeDTO) {
        ResponsavelDTO entidade = service.salvar(entidadeDTO);
        return ResponseEntity.ok(entidade);
    }

    @PutMapping
    public ResponseEntity<ResponsavelDTO> editar(@RequestBody ResponsavelDTO entidadeDTO) {
        ResponsavelDTO entidade = service.salvar(entidadeDTO);
        return ResponseEntity.ok(entidade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
