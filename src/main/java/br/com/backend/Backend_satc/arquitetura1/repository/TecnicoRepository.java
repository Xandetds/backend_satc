package br.com.backend.Backend_satc.arquitetura1.repository;

import br.com.backend.Backend_satc.arquitetura1.entity.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
    boolean existsByCpf(String cpf);
}
