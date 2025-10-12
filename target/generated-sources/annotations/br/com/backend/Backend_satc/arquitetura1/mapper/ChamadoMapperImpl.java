package br.com.backend.Backend_satc.arquitetura1.mapper;

import br.com.backend.Backend_satc.arquitetura1.dto.ChamadoDTO;
import br.com.backend.Backend_satc.arquitetura1.entity.Chamado;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-12T00:00:10-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
@Component
public class ChamadoMapperImpl implements ChamadoMapper {

    @Override
    public Chamado toEntity(ChamadoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Chamado chamado = new Chamado();

        chamado.setTitulo( dto.getTitulo() );
        chamado.setDescricao( dto.getDescricao() );
        chamado.setDataAbertura( dto.getDataAbertura() );
        chamado.setDataFechamento( dto.getDataFechamento() );
        chamado.setStatus( dto.getStatus() );

        return chamado;
    }

    @Override
    public ChamadoDTO toDTO(Chamado entity) {
        if ( entity == null ) {
            return null;
        }

        ChamadoDTO chamadoDTO = new ChamadoDTO();

        chamadoDTO.setTitulo( entity.getTitulo() );
        chamadoDTO.setDescricao( entity.getDescricao() );
        chamadoDTO.setStatus( entity.getStatus() );
        chamadoDTO.setDataAbertura( entity.getDataAbertura() );
        chamadoDTO.setDataFechamento( entity.getDataFechamento() );

        return chamadoDTO;
    }
}
