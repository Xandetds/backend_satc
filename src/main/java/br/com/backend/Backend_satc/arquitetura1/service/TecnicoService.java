package br.com.backend.Backend_satc.arquitetura1.service;

import br.com.backend.Backend_satc.arquitetura1.dto.request.TecnicoRequestDTO;
import br.com.backend.Backend_satc.arquitetura1.dto.response.TecnicoResponseDTO;
import br.com.backend.Backend_satc.arquitetura1.enums.Status;
import br.com.backend.Backend_satc.arquitetura1.exception.BusinessException;
import br.com.backend.Backend_satc.arquitetura1.mapper.TecnicoMapper;
import br.com.backend.Backend_satc.arquitetura1.repository.ChamadoRepository;
import br.com.backend.Backend_satc.arquitetura1.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TecnicoService {

    @Autowired private TecnicoRepository repository;
    @Autowired private ChamadoRepository chamadoRepository;
    @Autowired private TecnicoMapper mapper;

    @Transactional
    public TecnicoResponseDTO criar(TecnicoRequestDTO dto) {
        if (repository.existsByCpf(dto.getCpf())) throw new BusinessException("CPF já cadastrado");
        var entity = mapper.toEntity(dto);
        entity.setChamadosAtendidos(0);
        return mapper.toResponseDTO(repository.save(entity));
    }

    public TecnicoResponseDTO buscarPorId(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new BusinessException("Técnico não encontrado"));
        return mapper.toResponseDTO(entity);
    }

    public List<TecnicoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).toList();
    }

    @Transactional
    public TecnicoResponseDTO atualizar(Long id, TecnicoRequestDTO dto) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new BusinessException("Técnico não encontrado"));

        if (!entity.getCpf().equals(dto.getCpf()) && repository.existsByCpf(dto.getCpf()))
            throw new BusinessException("CPF já cadastrado");

        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        entity.setEspecialidade(dto.getEspecialidade());
        return mapper.toResponseDTO(repository.save(entity));
    }

    @Transactional
    public void deletar(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new BusinessException("Técnico não encontrado"));

        if (chamadoRepository.existsByTecnico_IdAndStatus(id, Status.ABERTO))
            throw new BusinessException("Técnico possui chamados em aberto");

        repository.delete(entity);
    }
}