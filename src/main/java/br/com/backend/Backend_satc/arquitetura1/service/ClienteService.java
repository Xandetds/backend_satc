package br.com.backend.Backend_satc.arquitetura1.service;

import br.com.backend.Backend_satc.arquitetura1.dto.ClienteDTO;
import br.com.backend.Backend_satc.arquitetura1.entity.Cliente;
import br.com.backend.Backend_satc.arquitetura1.exception.BusinessException;
import br.com.backend.Backend_satc.arquitetura1.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente criarCliente(ClienteDTO dto) {
        if (repository.existsByEmail(dto.getEmail())) {
            throw new BusinessException("E-mail já cadastrado!");
        }
        if (repository.existsByCpf(dto.getCpf())) {
            throw new BusinessException("CPF já cadastrado!");
        }

        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setCpf(dto.getCpf());
        cliente.setEmail(dto.getEmail());
        cliente.setEndereco(dto.getEndereco());
        return repository.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return repository.findAll();
    }
}
