package br.com.backend.Backend_satc.arquitetura1.mapper;

import br.com.backend.Backend_satc.arquitetura1.dto.ClienteDTO;
import br.com.backend.Backend_satc.arquitetura1.entity.Cliente;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-12T00:00:10-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public Cliente toEntity(ClienteDTO dto) {
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
    public ClienteDTO toDTO(Cliente entity) {
        if ( entity == null ) {
            return null;
        }

        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setNome( entity.getNome() );
        clienteDTO.setCpf( entity.getCpf() );
        clienteDTO.setEmail( entity.getEmail() );
        clienteDTO.setEndereco( entity.getEndereco() );

        return clienteDTO;
    }
}
