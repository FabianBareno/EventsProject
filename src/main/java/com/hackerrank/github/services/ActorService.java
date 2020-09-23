package com.hackerrank.github.services;

import com.hackerrank.github.model.Actor;

import java.util.List;
import java.util.Optional;

public interface ActorService {

    void createActor(Actor actor);

    Optional<Actor> getActorById(Long id);

    List<Actor> getAllActors();

    Actor updateAvatarURL(Actor actor);

    void deleteRecords();
}
