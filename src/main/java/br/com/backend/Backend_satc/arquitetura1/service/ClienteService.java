package br.com.backend.Backend_satc.arquitetura1.service;

import br.com.backend.Backend_satc.arquitetura1.dto.request.ClienteRequestDTO;
import br.com.backend.Backend_satc.arquitetura1.dto.response.ClienteResponseDTO;
import br.com.backend.Backend_satc.arquitetura1.enums.Status;
import br.com.backend.Backend_satc.arquitetura1.exception.BusinessException;
import br.com.backend.Backend_satc.arquitetura1.mapper.ClienteMapper;
import br.com.backend.Backend_satc.arquitetura1.repository.ChamadoRepository;
import br.com.backend.Backend_satc.arquitetura1.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService {

    @Autowired private ClienteRepository repository;
    @Autowired private ChamadoRepository chamadoRepository;
    @Autowired private ClienteMapper mapper;

    @Transactional
    public ClienteResponseDTO criar(ClienteRequestDTO dto) {
        if (repository.existsByEmail(dto.getEmail())) throw new BusinessException("E-mail já cadastrado");
        if (repository.existsByCpf(dto.getCpf())) throw new BusinessException("CPF já cadastrado");
        var entity = mapper.toEntity(dto);
        return mapper.toResponseDTO(repository.save(entity));
    }

    public ClienteResponseDTO buscarPorId(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new BusinessException("Cliente não encontrado"));
        return mapper.toResponseDTO(entity);
    }

    public List<ClienteResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).toList();
    }

    @Transactional
    public ClienteResponseDTO atualizar(Long id, ClienteRequestDTO dto) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new BusinessException("Cliente não encontrado"));

        if (!entity.getEmail().equals(dto.getEmail()) && repository.existsByEmail(dto.getEmail()))
            throw new BusinessException("E-mail já cadastrado");
        if (!entity.getCpf().equals(dto.getCpf()) && repository.existsByCpf(dto.getCpf()))
            throw new BusinessException("CPF já cadastrado");

        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        entity.setEmail(dto.getEmail());
        entity.setEndereco(dto.getEndereco());
        return mapper.toResponseDTO(repository.save(entity));
    }

    @Transactional
    public void deletar(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new BusinessException("Cliente não encontrado"));

        if (chamadoRepository.existsByCliente_IdAndStatus(id, Status.ABERTO))
            throw new BusinessException("Cliente possui chamados em aberto");

        repository.delete(entity);
    }
}
