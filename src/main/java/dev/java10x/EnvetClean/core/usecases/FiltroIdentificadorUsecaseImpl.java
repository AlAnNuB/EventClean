package dev.java10x.EnvetClean.core.usecases;

import dev.java10x.EnvetClean.core.entities.Evento;
import dev.java10x.EnvetClean.core.gateway.EventoGateway;
import dev.java10x.EnvetClean.infrastructure.exception.NotFoundEventException;

public class FiltroIdentificadorUsecaseImpl implements FiltroIdentificadorUsecase {

    private final EventoGateway eventoGateway;

    public FiltroIdentificadorUsecaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(String identificador) {
        return eventoGateway.filtrarPorIdentificador(identificador)
                .orElseThrow(() -> new NotFoundEventException("Não foi possível encontrar o evento com o identificador: " + identificador));
    }
}
