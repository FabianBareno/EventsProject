package com.hackerrank.github.services;

import com.hackerrank.github.model.Actor;
import com.hackerrank.github.model.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {

    void createEvent(Event event);

    Optional<Event> getEventById(Long id);

    List<Event> getAllEvents();

    List<Event> getAllEventsByActor(Actor actor);

    void deleteRecords();
}
