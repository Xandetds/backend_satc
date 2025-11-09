package br.com.backend.Backend_satc.arquitetura1.mapper;

import br.com.backend.Backend_satc.arquitetura1.dto.request.ChamadoRequestDTO;
import br.com.backend.Backend_satc.arquitetura1.dto.response.ChamadoResponseDTO;
import br.com.backend.Backend_satc.arquitetura1.entity.Chamado;
import br.com.backend.Backend_satc.arquitetura1.entity.Cliente;
import br.com.backend.Backend_satc.arquitetura1.entity.Tecnico;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-09T17:19:35-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
@Component
public class ChamadoMapperImpl implements ChamadoMapper {

    @Override
    public Chamado toEntity(ChamadoRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Chamado chamado = new Chamado();

        chamado.setTitulo( dto.getTitulo() );
        chamado.setDescricao( dto.getDescricao() );

        return chamado;
    }

    @Override
    public ChamadoResponseDTO toResponseDTO(Chamado entity) {
        if ( entity == null ) {
            return null;
        }

        ChamadoResponseDTO chamadoResponseDTO = new ChamadoResponseDTO();

        chamadoResponseDTO.setClienteNome( entityClienteNome( entity ) );
        chamadoResponseDTO.setTecnicoNome( entityTecnicoNome( entity ) );
        chamadoResponseDTO.setIdChamado( entity.getIdChamado() );
        chamadoResponseDTO.setTitulo( entity.getTitulo() );
        chamadoResponseDTO.setDescricao( entity.getDescricao() );
        chamadoResponseDTO.setStatus( entity.getStatus() );
        chamadoResponseDTO.setDataAbertura( entity.getDataAbertura() );
        chamadoResponseDTO.setDataFechamento( entity.getDataFechamento() );

        return chamadoResponseDTO;
    }

    private String entityClienteNome(Chamado chamado) {
        if ( chamado == null ) {
            return null;
        }
        Cliente cliente = chamado.getCliente();
        if ( cliente == null ) {
            return null;
        }
        String nome = cliente.getNome();
        if ( nome == null ) {
            return null;
        }
        return nome;
    }

    private String entityTecnicoNome(Chamado chamado) {
        if ( chamado == null ) {
            return null;
        }
        Tecnico tecnico = chamado.getTecnico();
        if ( tecnico == null ) {
            return null;
        }
        String nome = tecnico.getNome();
        if ( nome == null ) {
            return null;
        }
        return nome;
    }
}
