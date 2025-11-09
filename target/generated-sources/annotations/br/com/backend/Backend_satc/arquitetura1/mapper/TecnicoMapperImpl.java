package br.com.backend.Backend_satc.arquitetura1.mapper;

import br.com.backend.Backend_satc.arquitetura1.dto.request.TecnicoRequestDTO;
import br.com.backend.Backend_satc.arquitetura1.dto.response.TecnicoResponseDTO;
import br.com.backend.Backend_satc.arquitetura1.entity.Tecnico;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-09T17:19:36-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
@Component
public class TecnicoMapperImpl implements TecnicoMapper {

    @Override
    public Tecnico toEntity(TecnicoRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Tecnico tecnico = new Tecnico();

        tecnico.setCpf( dto.getCpf() );
        tecnico.setNome( dto.getNome() );
        tecnico.setEspecialidade( dto.getEspecialidade() );

        return tecnico;
    }

    @Override
    public TecnicoResponseDTO toResponseDTO(Tecnico entity) {
        if ( entity == null ) {
            return null;
        }

        TecnicoResponseDTO tecnicoResponseDTO = new TecnicoResponseDTO();

        tecnicoResponseDTO.setId( entity.getId() );
        tecnicoResponseDTO.setNome( entity.getNome() );
        tecnicoResponseDTO.setCpf( entity.getCpf() );
        tecnicoResponseDTO.setEspecialidade( entity.getEspecialidade() );
        tecnicoResponseDTO.setChamadosAtendidos( entity.getChamadosAtendidos() );

        return tecnicoResponseDTO;
    }
}
