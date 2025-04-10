package dev.java10x.EnvetClean.core.gateway;

import dev.java10x.EnvetClean.core.entities.Evento;

import java.util.List;
import java.util.Optional;

public interface EventoGateway {

    Evento criarEvento(Evento evento);

    List<Evento> buscarEventos();

    boolean existePorIdentificador(String identificador);

    Optional<Evento> filtrarPorIdentificador(String identificador);
}
