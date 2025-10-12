package br.com.backend.Backend_satc.arquitetura1.mapper;

import br.com.backend.Backend_satc.arquitetura1.dto.TecnicoDTO;
import br.com.backend.Backend_satc.arquitetura1.entity.Tecnico;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TecnicoMapper {
    Tecnico toEntity(TecnicoDTO dto);
    TecnicoDTO toDTO(Tecnico entity);
}
