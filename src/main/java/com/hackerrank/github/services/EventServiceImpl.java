package com.hackerrank.github.services;

import com.hackerrank.github.model.Actor;
import com.hackerrank.github.model.Event;
import com.hackerrank.github.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    @Transactional
    public void createEvent(Event event) {
        eventRepository.save(event);
    }

    @Override
    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAllByOrderByIdAsc();
    }

    @Override
    public List<Event> getAllEventsByActor(Actor actor) {
        return eventRepository.findAllByActor(actor);
    }

    @Override
    @Transactional
    public void deleteRecords() {
        eventRepository.deleteAll();
    }

}
