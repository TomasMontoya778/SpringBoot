package com.riwi.tallerApiRest.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.tallerApiRest.entities.Evento;
import com.riwi.tallerApiRest.repository.EventRepository;
import com.riwi.tallerApiRest.service.abstract_service.IEventService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EventService implements IEventService {
    @Autowired
    private final EventRepository objEventRepository;

    @Override
    public void delete(String id) {
        Evento objEvento = this.objEventRepository.findById(id).orElseThrow();
        this.objEventRepository.delete(objEvento);
    }

    @Override
    public Evento findById(String id) {
        Optional<Evento> objEvento = this.objEventRepository.findById(id);
        return objEvento.orElse(null);
    }

    @Override
    public List<Evento> getAll() {
        return this.objEventRepository.findAll();
    }

    @Override
    public Evento save(Evento evento) {
        return evento.getCapacidad() > 0 && evento.getFecha().isAfter(LocalDate.now())
                ? this.objEventRepository.save(evento)
                : null;
    }

    @Override
    public Evento update(Evento evento) {
        return this.objEventRepository.save(evento);
    }

}
