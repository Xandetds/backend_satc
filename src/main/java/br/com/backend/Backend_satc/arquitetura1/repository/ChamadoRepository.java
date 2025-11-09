        package br.com.backend.Backend_satc.arquitetura1.repository;

import br.com.backend.Backend_satc.arquitetura1.entity.Chamado;
import br.com.backend.Backend_satc.arquitetura1.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Long> {
    boolean existsByCliente_IdAndStatus(Long clienteId, Status status);
    boolean existsByTecnico_IdAndStatus(Long tecnicoId, Status status);
}
