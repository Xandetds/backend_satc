package br.com.backend.Backend_satc.arquitetura1.mapper;

import br.com.backend.Backend_satc.arquitetura1.dto.request.ClienteRequestDTO;
import br.com.backend.Backend_satc.arquitetura1.dto.response.ClienteResponseDTO;
import br.com.backend.Backend_satc.arquitetura1.entity.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    Cliente toEntity(ClienteRequestDTO dto);
    ClienteResponseDTO toResponseDTO(Cliente entity);
}
