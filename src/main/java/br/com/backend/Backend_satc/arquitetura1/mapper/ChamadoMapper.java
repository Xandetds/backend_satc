package br.com.backend.Backend_satc.arquitetura1.mapper;

import br.com.backend.Backend_satc.arquitetura1.dto.request.ChamadoRequestDTO;
import br.com.backend.Backend_satc.arquitetura1.dto.response.ChamadoResponseDTO;
import br.com.backend.Backend_satc.arquitetura1.entity.Chamado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ChamadoMapper {
    Chamado toEntity(ChamadoRequestDTO dto);

    @Mapping(target = "clienteNome", source = "cliente.nome")
    @Mapping(target = "tecnicoNome", source = "tecnico.nome")
    ChamadoResponseDTO toResponseDTO(Chamado entity);
}
