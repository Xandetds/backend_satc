package br.com.backend.Backend_satc.arquitetura1.resource;

import br.com.backend.Backend_satc.arquitetura1.dto.request.ChamadoRequestDTO;
import br.com.backend.Backend_satc.arquitetura1.dto.response.ChamadoResponseDTO;
import br.com.backend.Backend_satc.arquitetura1.service.ChamadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chamados")
public class ChamadoResource {

    @Autowired private ChamadoService service;

    @PostMapping
    public ResponseEntity<ChamadoResponseDTO> criar(@Valid @RequestBody ChamadoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChamadoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<ChamadoResponseDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChamadoResponseDTO> atualizar(@PathVariable Long id,
                                                        @Valid @RequestBody ChamadoRequestDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/fechar")
    public ResponseEntity<ChamadoResponseDTO> fechar(@PathVariable Long id) {
        return ResponseEntity.ok(service.fechar(id));
    }

    @PutMapping("/{id}/iniciar")
    public ResponseEntity<ChamadoResponseDTO> iniciar(@PathVariable Long id) {
        return ResponseEntity.ok(service.iniciarAtendimento(id));
    }
}