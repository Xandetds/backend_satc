package br.com.backend.Backend_satc.arquitetura1.mapper;

import br.com.backend.Backend_satc.arquitetura1.dto.request.TecnicoRequestDTO;
import br.com.backend.Backend_satc.arquitetura1.dto.response.TecnicoResponseDTO;
import br.com.backend.Backend_satc.arquitetura1.entity.Tecnico;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TecnicoMapper {
    Tecnico toEntity(TecnicoRequestDTO dto);
    TecnicoResponseDTO toResponseDTO(Tecnico entity);
}
