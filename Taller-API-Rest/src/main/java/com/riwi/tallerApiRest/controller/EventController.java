package com.riwi.tallerApiRest.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.tallerApiRest.entities.Evento;
import com.riwi.tallerApiRest.service.abstract_service.IEventService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api-events/v1/evento")
@AllArgsConstructor
public class EventController {
    @Autowired
    private final IEventService objEventService;

    @PostMapping("/post")
    public ResponseEntity<Evento> save(@RequestBody Evento evento){
        return ResponseEntity.ok(this.objEventService.save(evento));
    }
    @GetMapping("/get")
    public ResponseEntity<List<Evento>> getAll(){
        return ResponseEntity.ok(this.objEventService.getAll());
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Evento> getById(@PathVariable String id){
        return ResponseEntity.ok(this.objEventService.findById(id));
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        this.objEventService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Evento> update(@PathVariable String id, @RequestBody Evento evento){
        evento.setId(id);
        return ResponseEntity.ok(this.objEventService.update(evento));
    }

}
