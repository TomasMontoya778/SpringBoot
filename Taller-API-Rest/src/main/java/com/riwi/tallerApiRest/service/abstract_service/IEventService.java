package com.riwi.tallerApiRest.service.abstract_service;

import java.util.List;

import com.riwi.tallerApiRest.entities.Evento;

public interface IEventService {
    public Evento save(Evento evento);
    public List<Evento> getAll();
    public Evento findById(String id);
    public void delete(String id);
    public Evento update(Evento evento);
}
