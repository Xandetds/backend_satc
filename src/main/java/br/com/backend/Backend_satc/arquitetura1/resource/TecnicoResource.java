package br.com.backend.Backend_satc.arquitetura1.resource;

import br.com.backend.Backend_satc.arquitetura1.dto.TecnicoDTO;
import br.com.backend.Backend_satc.arquitetura1.entity.Tecnico;
import br.com.backend.Backend_satc.arquitetura1.service.TecnicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoResource {

    @Autowired
    private TecnicoService service;

    @PostMapping
    public Tecnico criarTecnico(@Valid @RequestBody TecnicoDTO dto) {
        return service.criarTecnico(dto);
    }

    @GetMapping
    public List<Tecnico> listarTecnicos() {
        return service.listarTecnicos();
    }
}
