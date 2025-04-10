package dev.java10x.EnvetClean.infrastructure.gateway;

import dev.java10x.EnvetClean.core.entities.Evento;
import dev.java10x.EnvetClean.core.gateway.EventoGateway;
import dev.java10x.EnvetClean.infrastructure.mapper.EventoEntityMapper;
import dev.java10x.EnvetClean.infrastructure.persistence.EventoEntity;
import dev.java10x.EnvetClean.infrastructure.persistence.EventoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EventoRepositoryGateway implements EventoGateway {

    private final EventoRepository eventoRepository;
    private final EventoEntityMapper eventoEntityMapper;

    public EventoRepositoryGateway(EventoRepository eventoRepository, EventoEntityMapper eventoEntityMapper) {
        this.eventoRepository = eventoRepository;
        this.eventoEntityMapper = eventoEntityMapper;
    }

    @Override
    public Evento criarEvento(Evento evento) {
        EventoEntity eventoEntity = eventoEntityMapper.toEntity(evento);
        EventoEntity novoEvento = eventoRepository.save(eventoEntity);

        return eventoEntityMapper.toDomain(novoEvento);
    }

    @Override
    public List<Evento> buscarEventos() {
        return eventoRepository.findAll().stream()
                .map(eventoEntityMapper::toDomain)
                .toList();
    }

    @Override
    public boolean existePorIdentificador(String identificador) {
        return eventoRepository.findAll().stream()
                .anyMatch(evento -> evento.getIdentificador().equalsIgnoreCase(identificador));
    }

    @Override
    public Optional<Evento> filtrarPorIdentificador(String identificador) {
        return eventoRepository.findByIdentificador(identificador);
    }
}
