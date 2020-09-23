package com.hackerrank.github.controller;

import com.hackerrank.github.model.Actor;
import com.hackerrank.github.model.Event;
import com.hackerrank.github.services.ActorService;
import com.hackerrank.github.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/events")
public class EventsController {

    private final EventService eventService;
    private final ActorService actorService;

    @Autowired
    public EventsController(EventService eventService, ActorService actorService) {
        this.eventService = eventService;
        this.actorService = actorService;
    }

    @PostMapping
    public ResponseEntity<Event> addEvent(@RequestBody Event event){

        if(eventService.getEventById(event.getId()).isPresent()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        eventService.createEvent(event);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents(){
        return new ResponseEntity<>(eventService.getAllEvents(), HttpStatus.OK);
    }

    @GetMapping( value="/{id}" )
    public ResponseEntity<Event> getEventById(@PathVariable Long id){
        Optional<Event> event = eventService.getEventById(id);
        return event.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping( value="/actors/{actorID}" )
    public ResponseEntity<List<Event>> getEventByActorId(@PathVariable Long actorID){
        Optional<Actor> actor = actorService.getActorById(actorID);
        return actor.map(value -> new ResponseEntity<>(eventService.getAllEventsByActor(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
