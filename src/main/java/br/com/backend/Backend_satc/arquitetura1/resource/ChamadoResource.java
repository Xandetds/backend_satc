package br.com.backend.Backend_satc.arquitetura1.resource;

import br.com.backend.Backend_satc.arquitetura1.entity.Chamado;
import br.com.backend.Backend_satc.arquitetura1.service.ChamadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/chamados")
public class ChamadoResource {

    @Autowired
    private ChamadoService service;

    @PostMapping
    public Chamado criarChamado(@Valid @RequestBody Chamado chamado) {
        return service.criarChamado(chamado);
    }

    @GetMapping
    public List<Chamado> listarChamados() {
        return service.listarChamados();
    }

    @PutMapping("/{id}/fechar")
    public Chamado fecharChamado(@PathVariable Long id) {
        return service.fecharChamado(id);
    }
}
