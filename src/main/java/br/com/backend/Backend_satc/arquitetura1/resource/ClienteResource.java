package br.com.backend.Backend_satc.arquitetura1.resource;

import br.com.backend.Backend_satc.arquitetura1.dto.ClienteDTO;
import br.com.backend.Backend_satc.arquitetura1.entity.Cliente;
import br.com.backend.Backend_satc.arquitetura1.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @PostMapping
    public Cliente criarCliente(@Valid @RequestBody ClienteDTO dto) {
        return service.criarCliente(dto);
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return service.listarClientes();
    }
}
