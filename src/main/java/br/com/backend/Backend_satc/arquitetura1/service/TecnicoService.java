package br.com.backend.Backend_satc.arquitetura1.service;

import br.com.backend.Backend_satc.arquitetura1.dto.TecnicoDTO;
import br.com.backend.Backend_satc.arquitetura1.entity.Tecnico;
import br.com.backend.Backend_satc.arquitetura1.exception.BusinessException;
import br.com.backend.Backend_satc.arquitetura1.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;

    public Tecnico criarTecnico(TecnicoDTO dto) {
        if (repository.existsByCpf(dto.getCpf())) {
            throw new BusinessException("CPF já cadastrado!");
        }

        Tecnico tecnico = new Tecnico();
        tecnico.setNome(dto.getNome());
        tecnico.setCpf(dto.getCpf());
        tecnico.setEspecialidade(dto.getEspecialidade());
        tecnico.setChamadosAtendidos(dto.getChamadosAtendidos());
        return repository.save(tecnico);
    }

    public List<Tecnico> listarTecnicos() {
        return repository.findAll();
    }
}
