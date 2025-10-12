package br.com.backend.Backend_satc.arquitetura1.mapper;

import br.com.backend.Backend_satc.arquitetura1.dto.ChamadoDTO;
import br.com.backend.Backend_satc.arquitetura1.entity.Chamado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChamadoMapper {
    Chamado toEntity(ChamadoDTO dto);
    ChamadoDTO toDTO(Chamado entity);
}
