package dev.java10x.EnvetClean.infrastructure.mapper;

import dev.java10x.EnvetClean.core.entities.Evento;
import dev.java10x.EnvetClean.infrastructure.persistence.EventoEntity;
import org.springframework.stereotype.Component;

@Component
public class EventoEntityMapper {

    public EventoEntity toEntity(Evento evento) {
        return new EventoEntity(
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

    public Evento toDomain(EventoEntity evento) {
        return new Evento(
                evento.getId(),
                evento.getNome(),
                evento.getDescricao(),
                evento.getIdentificador(),
                evento.getDataInicio(),
                evento.getDataFim(),
                evento.getLocalEvento(),
                evento.getCapacidade(),
                evento.getOrganizador(),
                evento.getTipo()
        );
    }
}
