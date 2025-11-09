package br.com.backend.Backend_satc.arquitetura1.service;

import br.com.backend.Backend_satc.arquitetura1.dto.request.ChamadoRequestDTO;
import br.com.backend.Backend_satc.arquitetura1.dto.response.ChamadoResponseDTO;
import br.com.backend.Backend_satc.arquitetura1.entity.Chamado;
import br.com.backend.Backend_satc.arquitetura1.enums.Status;
import br.com.backend.Backend_satc.arquitetura1.exception.BusinessException;
import br.com.backend.Backend_satc.arquitetura1.mapper.ChamadoMapper;
import br.com.backend.Backend_satc.arquitetura1.repository.ChamadoRepository;
import br.com.backend.Backend_satc.arquitetura1.repository.ClienteRepository;
import br.com.backend.Backend_satc.arquitetura1.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChamadoService {

    @Autowired private ChamadoRepository chamadoRepo;
    @Autowired private ClienteRepository clienteRepo;
    @Autowired private TecnicoRepository tecnicoRepo;
    @Autowired private ChamadoMapper mapper;

    @Transactional
    public ChamadoResponseDTO criar(ChamadoRequestDTO dto) {
        Chamado ch = mapper.toEntity(dto);
        var cliente = clienteRepo.findById(dto.getIdCliente())
                .orElseThrow(() -> new BusinessException("Cliente não encontrado"));
        var tecnico = tecnicoRepo.findById(dto.getIdTecnico())
                .orElseThrow(() -> new BusinessException("Técnico não encontrado"));

        ch.setCliente(cliente);
        ch.setTecnico(tecnico);
        ch.setDataAbertura(LocalDateTime.now());
        ch.setStatus(Status.ABERTO);

        return mapper.toResponseDTO(chamadoRepo.save(ch));
    }

    public ChamadoResponseDTO buscarPorId(Long id) {
        var ch = chamadoRepo.findById(id)
                .orElseThrow(() -> new BusinessException("Chamado não encontrado"));
        return mapper.toResponseDTO(ch);
    }

    public List<ChamadoResponseDTO> listar() {
        return chamadoRepo.findAll().stream().map(mapper::toResponseDTO).toList();
    }

    @Transactional
    public ChamadoResponseDTO atualizar(Long id, ChamadoRequestDTO dto) {
        var ch = chamadoRepo.findById(id)
                .orElseThrow(() -> new BusinessException("Chamado não encontrado"));

        ch.setTitulo(dto.getTitulo());
        ch.setDescricao(dto.getDescricao());

        if (dto.getIdCliente() != null) {
            var cliente = clienteRepo.findById(dto.getIdCliente())
                    .orElseThrow(() -> new BusinessException("Cliente não encontrado"));
            ch.setCliente(cliente);
        }
        if (dto.getIdTecnico() != null) {
            var tecnico = tecnicoRepo.findById(dto.getIdTecnico())
                    .orElseThrow(() -> new BusinessException("Técnico não encontrado"));
            ch.setTecnico(tecnico);
        }
        return mapper.toResponseDTO(chamadoRepo.save(ch));
    }

    @Transactional
    public void deletar(Long id) {
        var ch = chamadoRepo.findById(id)
                .orElseThrow(() -> new BusinessException("Chamado não encontrado"));

        if (ch.getStatus() == Status.ABERTO || ch.getStatus() == Status.EM_ANDAMENTO) {
            throw new BusinessException("Não é possível excluir um chamado que está em aberto ou em andamento.");
        }

        chamadoRepo.delete(ch);
    }

    @Transactional
    public ChamadoResponseDTO fechar(Long id) {
        var ch = chamadoRepo.findById(id)
                .orElseThrow(() -> new BusinessException("Chamado não encontrado"));

        if (ch.getStatus() == Status.CONCLUIDO) {
            throw new BusinessException("Este chamado já está concluído.");
        }

        ch.setStatus(Status.CONCLUIDO);
        ch.setDataFechamento(LocalDateTime.now());
        return mapper.toResponseDTO(chamadoRepo.save(ch));
    }

    @Transactional
    public ChamadoResponseDTO iniciarAtendimento(Long id) {
        var ch = chamadoRepo.findById(id)
                .orElseThrow(() -> new BusinessException("Chamado não encontrado"));

        if (ch.getStatus() != Status.ABERTO) {
            throw new BusinessException("O chamado só pode ser iniciado se estiver com status 'ABERTO'.");
        }

        ch.setStatus(Status.EM_ANDAMENTO);
        return mapper.toResponseDTO(chamadoRepo.save(ch));
    }
}