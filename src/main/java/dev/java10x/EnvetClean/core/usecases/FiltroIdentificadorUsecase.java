package dev.java10x.EnvetClean.core.usecases;

import dev.java10x.EnvetClean.core.entities.Evento;

public interface FiltroIdentificadorUsecase {

    public Evento execute(String identificador);
}
