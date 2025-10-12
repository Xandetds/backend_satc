package br.com.backend.Backend_satc.arquitetura1.service;

import br.com.backend.Backend_satc.arquitetura1.entity.Chamado;
import br.com.backend.Backend_satc.arquitetura1.enums.Status;
import br.com.backend.Backend_satc.arquitetura1.repository.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository repository;

    public Chamado criarChamado(Chamado chamado) {
        chamado.setDataAbertura(LocalDateTime.now());
        chamado.setStatus(Status.ABERTO);
        return repository.save(chamado);
    }

    public List<Chamado> listarChamados() {
        return repository.findAll();
    }

    public Chamado buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Chamado fecharChamado(Long id) {
        Chamado chamado = buscarPorId(id);
        if (chamado != null) {
            chamado.setStatus(Status.CONCLUIDO);
            chamado.setDataFechamento(LocalDateTime.now());
            return repository.save(chamado);
        }
        return null;
    }
}
