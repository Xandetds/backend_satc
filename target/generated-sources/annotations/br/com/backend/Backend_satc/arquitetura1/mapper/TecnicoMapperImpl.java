package br.com.backend.Backend_satc.arquitetura1.mapper;

import br.com.backend.Backend_satc.arquitetura1.dto.TecnicoDTO;
import br.com.backend.Backend_satc.arquitetura1.entity.Tecnico;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-12T00:00:10-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
@Component
public class TecnicoMapperImpl implements TecnicoMapper {

    @Override
    public Tecnico toEntity(TecnicoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Tecnico tecnico = new Tecnico();

        tecnico.setCpf( dto.getCpf() );
        tecnico.setNome( dto.getNome() );
        tecnico.setEspecialidade( dto.getEspecialidade() );
        tecnico.setChamadosAtendidos( dto.getChamadosAtendidos() );

        return tecnico;
    }

    @Override
    public TecnicoDTO toDTO(Tecnico entity) {
        if ( entity == null ) {
            return null;
        }

        TecnicoDTO tecnicoDTO = new TecnicoDTO();

        tecnicoDTO.setNome( entity.getNome() );
        tecnicoDTO.setCpf( entity.getCpf() );
        tecnicoDTO.setEspecialidade( entity.getEspecialidade() );
        tecnicoDTO.setChamadosAtendidos( entity.getChamadosAtendidos() );

        return tecnicoDTO;
    }
}
