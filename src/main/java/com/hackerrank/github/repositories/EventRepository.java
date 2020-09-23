package com.hackerrank.github.repositories;

import com.hackerrank.github.model.Actor;
import com.hackerrank.github.model.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {

    List<Event> findAllByOrderByIdAsc();

    List<Event> findAllByActor(Actor actor);
}
