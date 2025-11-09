package br.com.backend.Backend_satc.arquitetura1.mapper;

import br.com.backend.Backend_satc.arquitetura1.dto.request.ClienteRequestDTO;
import br.com.backend.Backend_satc.arquitetura1.dto.response.ClienteResponseDTO;
import br.com.backend.Backend_satc.arquitetura1.entity.Cliente;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-09T17:19:36-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public Cliente toEntity(ClienteRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setCpf( dto.getCpf() );
        cliente.setNome( dto.getNome() );
        cliente.setEmail( dto.getEmail() );
        cliente.setEndereco( dto.getEndereco() );

        return cliente;
    }

    @Override
    public ClienteResponseDTO toResponseDTO(Cliente entity) {
        if ( entity == null ) {
            return null;
        }

        ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO();

        clienteResponseDTO.setId( entity.getId() );
        clienteResponseDTO.setNome( entity.getNome() );
        clienteResponseDTO.setCpf( entity.getCpf() );
        clienteResponseDTO.setEmail( entity.getEmail() );
        clienteResponseDTO.setEndereco( entity.getEndereco() );

        return clienteResponseDTO;
    }
}
