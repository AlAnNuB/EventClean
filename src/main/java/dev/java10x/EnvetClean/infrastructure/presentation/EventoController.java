package dev.java10x.EnvetClean.infrastructure.presentation;

import dev.java10x.EnvetClean.core.entities.Evento;
import dev.java10x.EnvetClean.core.usecases.BuscarEventoUsecase;
import dev.java10x.EnvetClean.core.usecases.CriarEventoUsecase;
import dev.java10x.EnvetClean.core.usecases.FiltroIdentificadorUsecase;
import dev.java10x.EnvetClean.infrastructure.dtos.EventoDTO;
import dev.java10x.EnvetClean.infrastructure.mapper.EventoDTOMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1")
public class EventoController {

    private final CriarEventoUsecase criarEventoUsecase;
    private final EventoDTOMapper eventoDTOMapper;
    private final BuscarEventoUsecase buscarEventoUsecase;
    private final FiltroIdentificadorUsecase filtroIdentificadorUsecase;

    public EventoController(CriarEventoUsecase criarEventoUsecase, EventoDTOMapper eventoDTOMapper, BuscarEventoUsecase buscarEventoUsecase, FiltroIdentificadorUsecase filtroIdentificadorUsecase) {
        this.criarEventoUsecase = criarEventoUsecase;
        this.eventoDTOMapper = eventoDTOMapper;
        this.buscarEventoUsecase = buscarEventoUsecase;
        this.filtroIdentificadorUsecase = filtroIdentificadorUsecase;
    }

    @PostMapping("criarevento")
    public ResponseEntity<Map<String, Object>> criarEvento(@RequestBody EventoDTO evento) {
        Evento novoEvento = criarEventoUsecase.execute(eventoDTOMapper.toDomain(evento));

        Map<String, Object> response = new HashMap<>();
        response.put("Mensagem:", "Evento cadastrado com sucesso no banco de dados");
        response.put("Dados do evento:", eventoDTOMapper.toDTO(novoEvento));

        return ResponseEntity.ok(response);
    }

    @GetMapping("buscarevento")
    public List<EventoDTO> buscarEventos() {
        return buscarEventoUsecase.execute().stream()
                .map(eventoDTOMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/identificador/{identificador}")
    public ResponseEntity<Evento> buscarPorIdentificador(@PathVariable String identificador) {
        Evento evento = filtroIdentificadorUsecase.execute(identificador);

        return ResponseEntity.ok(evento);
    }
}
