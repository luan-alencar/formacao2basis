package com.basis.campina.xtarefas.web.resource;
import com.basis.campina.xtarefas.domain.Tarefa;
import com.basis.campina.xtarefas.service.AnexoService;
import com.basis.campina.xtarefas.service.TarefaService;
import com.basis.campina.xtarefas.service.dto.AnexoDTO;
import com.basis.campina.xtarefas.service.dto.TarefaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
@RequiredArgsConstructor
public class TarefaResource {

    private final TarefaService service;

    @GetMapping
    public ResponseEntity<List<TarefaDTO>> listar() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDTO> obterPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<TarefaDTO> salvar(@RequestBody TarefaDTO entidadeDTO) {
        return ResponseEntity.ok(service.salvar(entidadeDTO));
    }

    @PutMapping
    public ResponseEntity<TarefaDTO> editar(@RequestBody TarefaDTO entidadeDTO) {
        return ResponseEntity.ok(service.salvar(entidadeDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
