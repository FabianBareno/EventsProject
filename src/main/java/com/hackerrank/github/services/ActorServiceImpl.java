package com.hackerrank.github.services;

import com.hackerrank.github.model.Actor;
import com.hackerrank.github.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    @Transactional
    public void createActor(Actor actor) {
        actorRepository.save(actor);
    }

    @Override
    public Optional<Actor> getActorById(Long id) {
        return actorRepository.findById(id);
    }

    @Override
    public List<Actor> getAllActors() {
        return (List<Actor>) actorRepository.findAll();
    }

    @Override
    public Actor updateAvatarURL(Actor actor){

        Optional<Actor> actorOptional = actorRepository.findById(actor.getId());

        if(!actorOptional.isPresent() || !actor.getLogin().equals(actorOptional.get().getLogin())){
            throw new IllegalArgumentException();
        }

        Actor actorDatabase = actorOptional.get();
        actorDatabase.setAvatar(actor.getAvatar());
        return actorRepository.save(actorDatabase);
    }

    @Override
    @Transactional
    public void deleteRecords() {
        actorRepository.deleteAll();
    }
}
