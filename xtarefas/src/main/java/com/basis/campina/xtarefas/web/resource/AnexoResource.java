package com.basis.campina.xtarefas.web.resource;

import com.basis.campina.xtarefas.service.AnexoService;
import com.basis.campina.xtarefas.service.ResponsavelService;
import com.basis.campina.xtarefas.service.dto.AnexoDTO;
import com.basis.campina.xtarefas.service.dto.ResponsavelDTO;
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
@RequestMapping("/api/anexos")
@RequiredArgsConstructor
public class AnexoResource {

    private final AnexoService service;

    @GetMapping
    public ResponseEntity<List<AnexoDTO>> listar() {
        List<AnexoDTO> list = service.buscarTodos();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnexoDTO> obterPorId(@PathVariable Integer id) {
        AnexoDTO entidadeDTO = service.buscarPorId(id);
        return ResponseEntity.ok(entidadeDTO);
    }

    @PostMapping
    public ResponseEntity<AnexoDTO> salvar(@RequestBody AnexoDTO entidadeDTO) {
        AnexoDTO entidade = service.salvar(entidadeDTO);
        return ResponseEntity.ok(entidade);
    }

    @PutMapping
    public ResponseEntity<AnexoDTO> editar(@RequestBody AnexoDTO entidadeDTO) {
        AnexoDTO entidade = service.salvar(entidadeDTO);
        return ResponseEntity.ok(entidade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
