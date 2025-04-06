package dev.java10x.EnvetClean.infrastructure.mapper;

import dev.java10x.EnvetClean.core.entities.Evento;
import dev.java10x.EnvetClean.infrastructure.dtos.EventoDTO;
import org.springframework.stereotype.Component;

@Component
public class EventoDTOMapper {

    public EventoDTO toDTO(Evento evento) {
        return new EventoDTO(
                evento.id(),
                evento.nome(),
                evento.descricao(),
                evento.identificador(),
                evento.dataInicio(),
                evento.dataFim(),
                evento.localEvento(),
                evento.capacidade(),
                evento.organizador(),
                evento.tipo()
        );
    }

    public Evento toDomain(EventoDTO dto) {
        return new Evento(
                dto.id(),
                dto.nome(),
                dto.descricao(),
                dto.identificador(),
                dto.dataInicio(),
                dto.dataFim(),
                dto.localEvento(),
                dto.capacidade(),
                dto.organizador(),
                dto.tipo()
        );
    }
}
