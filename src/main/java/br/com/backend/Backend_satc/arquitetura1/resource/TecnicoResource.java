package br.com.backend.Backend_satc.arquitetura1.resource;

import br.com.backend.Backend_satc.arquitetura1.dto.request.TecnicoRequestDTO;
import br.com.backend.Backend_satc.arquitetura1.dto.response.TecnicoResponseDTO;
import br.com.backend.Backend_satc.arquitetura1.service.TecnicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoResource {

    @Autowired private TecnicoService service;

    @PostMapping
    public ResponseEntity<TecnicoResponseDTO> criar(@Valid @RequestBody TecnicoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TecnicoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<TecnicoResponseDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TecnicoResponseDTO> atualizar(@PathVariable Long id,
                                                        @Valid @RequestBody TecnicoRequestDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
