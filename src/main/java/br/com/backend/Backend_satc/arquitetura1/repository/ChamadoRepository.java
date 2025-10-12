package br.com.backend.Backend_satc.arquitetura1.repository;

import br.com.backend.Backend_satc.arquitetura1.entity.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Long>{
}
